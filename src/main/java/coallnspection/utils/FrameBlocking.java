package coallnspection.utils;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 该类用于进行视频分帧操作
 */

public class FrameBlocking {

    public static boolean frameCompletion = false;

    /**
     * 为了方便起见，直接将存储路径改为一张图片的路径，这样可以保持实时更新
     * 作用为将视频进行分帧处理
     * @param videoPath 视频的本地路径
     * @param file_name 文件的项目名称
     * @param out_directory_path 文件的存储目录
     * @throws FrameGrabber.Exception
     */

    public void framing(String videoPath,String file_name,String out_directory_path){
        // 视频抓取器
        FFmpegFrameGrabber ff = null;
        int i = 0;
        try {
            String img_type = "jpg";
            ff = FFmpegFrameGrabber.createDefault(videoPath);
            ff.setOption("rtsp_transport", "tcp");
            Java2DFrameConverter converter = new Java2DFrameConverter();
            ff.start();
            while (true) {
                // 获取每一帧的数据
                Frame frame = ff.grabImage();
                if (frame == null) break;
//                 根据每帧的时间戳进行文件命名
                    long timestamp = frame.timestamp;
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
                    String format = simpleDateFormat.format(date);
                    String curTime =simpleDateFormat.format(new Date().getTime() + timestamp);
                // 写出图片
                BufferedImage bi = converter.getBufferedImage(frame);
                String out_file_name = file_name + "@" + i + "." + img_type;
                String file_name_path = out_directory_path + File.separator + out_file_name;
                System.out.println(file_name_path);
                File output = new File(file_name_path);
                try {
                    ImageIO.write(bi, img_type, output);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //设置休眠时间
//                Thread.sleep(300);
                i++;
                if(i >= 200){
                    break;
                }
            }
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ff.stop();
            } catch (FrameGrabber.Exception e) {
                e.printStackTrace();
            }
            frameCompletion = true;
        }
    }


}
