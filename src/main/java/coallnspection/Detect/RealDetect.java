package coallnspection.Detect;

import coallnspection.mapper.CoalmineMapper;
import coallnspection.pojo.Analysis;
import coallnspection.pojo.Coalmine;
import coallnspection.pojo.Worker;
import coallnspection.service.MessageService;
import coallnspection.service.WebSocketService;
import coallnspection.service.WorkerService;
import coallnspection.utils.Util;
import com.alibaba.fastjson.JSON;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import coallnspection.utils.Analyzing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 进行实时检测
 */

@Component
public class RealDetect {

    @Autowired
    private static CoalmineMapper coalmineMapper;

    @Autowired
    public WebSocketService webSocketService;

    @Autowired
    public MessageService messageService;

    @Autowired
    public WorkerService workerService;

    static String videoPath = "D:\\CoalImage\\meiliu.mp4";
    static String file_name = "coal";
    static String out_directory_path = "D:\\CoalImage";
    static String img_type = "jpg";
    //进行检验的图片路径
    static String photoPath = "D:\\CoalImage\\coal@.png";

    //start有3个值,0:停止，1播放，2结束
    private int start = 0;

    //进行辅助转化为字节流
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    public ByteArrayOutputStream getByteArrayOutputStream() {
        return byteArrayOutputStream;
    }

    public void setByteArrayOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputStream = byteArrayOutputStream;
    }

    /**
     * 对视频进行实时监测
     *
     * @throws FrameGrabber.Exception
     */
    public void detect(int start,int num,int area) throws FrameGrabber.Exception {
        FFmpegFrameGrabber ff = null;
        try {
            ff = FFmpegFrameGrabber.createDefault(videoPath);
            ff.setOption("rtsp_transport", "tcp");
            Java2DFrameConverter converter = new Java2DFrameConverter();
            ff.start();
            int i = 1;
            while (true) {
                if(start == 0){
                    continue;
                }else if(start == 1){
                    // 获取每一帧的数据
                    Frame frame = ff.grabImage();
                    if (frame == null) break;
                    // 根据每帧的时间戳进行文件命名
                    //            long timestamp = frame.timestamp;
                    //            Date date = new Date();
                    //            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
                    //            String format = simpleDateFormat.format(date);
                    //            String curTime =simpleDateFormat.format(new Date().getTime() + timestamp);
                    // 写出图片
                    BufferedImage bi = converter.getBufferedImage(frame);
//                String out_file_name = file_name + i + "." + img_type;
//                String file_name_path = out_directory_path + File.separator + out_file_name;
//                System.out.println(file_name_path);
//                File output = new File(file_name_path);
//                try {
//                    //保存图片
//                    ImageIO.write(bi, img_type, output);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                    String s = EasyDl.doPostFile("http://127.0.0.1:24401/", bi);
                    Analysis analyzing = Analyzing.analyzing(s);

                    //当当前检测到的数目比较多，则发送短信提醒
                    //当1分钟出现的数目超过10条，则发送短信
                    if(coalmineMapper.countArea(area) > 10){
                        //查询该地点的工作人员
                        synchronized (workerService){
                            final Worker worker = workerService.checkWorker("区域" + area);
                            if(worker != null){
                                //发送短信
                                messageService.coalMessage(worker.getPhone(), "14AF275E");
                            }
                        }
                    }

                    if (analyzing != null) {
                        Graphics g = bi.getGraphics();
                        g.setColor(Color.RED);//画笔颜色
                        g.drawRect(analyzing.getLeft(), analyzing.getTop(), analyzing.getWidth(), analyzing.getLength());
                        ImageIO.write(bi, img_type, byteArrayOutputStream);
                        if(num > 1){
                            addCoal(new Coalmine(area,new Timestamp(new Date().getTime()),analyzing.getType(),analyzing.getLength(),analyzing.getWidth()));
                        }else{
                            coalmineMapper.addCoalmine(new Coalmine(area,new Timestamp(new Date().getTime()),analyzing.getType(),analyzing.getLength(),analyzing.getWidth()));
                        }
                        webSocketService.sendMessage(JSON.toJSONString(new Coalmine(area,new Timestamp(new Date().getTime()),analyzing.getType(),analyzing.getLength(),analyzing.getWidth())), String.valueOf(area));
                    }else{
                        ImageIO.write(bi, img_type, byteArrayOutputStream);
                    }
                    //如果此时有多个对象进行方法调用
                    //更新窗口内图片
//                    i++;
//                    if (i == 10) {
//                        i = 1;
//                    }
                    System.out.println(s);
                    //将四个区的数据同一规划为1，2，3，4
                    if(byteArrayOutputStream != null){
                        webSocketService.sendImage(byteArrayOutputStream,String.valueOf(area));
                    }
                }else if(start == 2){
                    break;
                }
            }
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                ff.stop();
//            } catch (FrameGrabber.Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    //创建共有加锁方法
    public synchronized static void addCoal(Coalmine coalmine){
        coalmineMapper.addCoalmine(coalmine);
    }

    /**
     * 对图片进行检测并且标注
     */
    public static void detectPhoto() {
//        //写出的图片路径
//        String outPath = "D:\\CoalImage\\coal@1.jpg";
//        //进行检测并且标注
//        Image image = new ImageIcon(photoPath).getImage();
//        //将image对象转化为BufferedImage对象
//        BufferedImage bufferedImage = Util.toBufferedImage(image);
//        //写出文件的文件对象
//        File output = new File(outPath);
//        try {
//            //保存图片
//            ImageIO.write(bufferedImage, img_type, output);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String s = EasyDl.doPostFile("http://127.0.0.1:24401/",);
//        Analysis analyzing = Analyzing.analyzing(s);
//        if (analyzing != null) {
//            Graphics g = bufferedImage.getGraphics();
//            g.setColor(Color.RED);//画笔颜色
//            g.drawRect(analyzing.getLeft(), analyzing.getTop(), analyzing.getWidth(), analyzing.getLength());
//            try {
//                //保存图片
//                ImageIO.write(bufferedImage, img_type, output);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
