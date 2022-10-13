package coallnspection.Thread;

import coallnspection.Detect.EasyDl;
import coallnspection.Detect.RealDetect;
import coallnspection.mapper.CoalmineMapper;
import coallnspection.pojo.Analysis;
import coallnspection.pojo.Coalmine;
import coallnspection.utils.*;

import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.FrameGrabber;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设置线程池进行同时检测
 */

@SuppressWarnings("all")
public class ThreadPool {

    //创建线程池
    static ExecutorService executorService = Executors.newFixedThreadPool(8);
    //创建mapper接口
    @Autowired
    CoalmineMapper coalmineMapper;
    //设置线程结束标识
    public static boolean end1 = false;
    static boolean end2;
    static boolean end3;
    static boolean end4;

    //启动第一线程
    public void startOne(){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(FrameBlocking.frameCompletion == false){
                    //获取数据库连接
                    //接口和本地图片暂代填充
                    String s = EasyDl.doPostFile("http://127.0.0.1:24401/", "D:\\CoalImage\\coal@.jpg");
                    //获取元素对应值
                    Analysis analyzing = Analyzing.analyzing(s);
                    if(analyzing != null){
                        Coalmine coalMine = new Coalmine(1, Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
                        //将解析值存入数据库
                        coalmineMapper.addCoalmine(coalMine);
                    }
                }
                //将识别的视频进行保存
                try {
                    Util.pic2MovByFfmpeg("D:\\CoalImage\\meiliutest.mp4",700,500);
                } catch (FFmpegFrameRecorder.Exception e) {
                    e.printStackTrace();
                }
                //运行完毕，关闭线程池
                executorService.shutdown();
                System.out.println("运行已经完成");
            }

        });
    }

    //关闭第一线程
    public static void closeOne(){
        end1 = false;
    }

    //启动第二线程
    public void startTwo(){
        //设置启动
        end1 = true;

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(FrameBlocking.frameCompletion == false){
                    //接口和本地图片暂代填充
                    String s = EasyDl.doPostFile("http://127.0.0.1:24401/", "D:\\CoalImage\\coal@.jpg");
                    //获取元素对应值
                    Analysis analyzing = Analyzing.analyzing(s);
                    Coalmine coalMine = new Coalmine(1,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
                    System.out.println(coalMine);
                    //将解析值存入数据库
                    coalmineMapper.addCoalmine(coalMine);
                }
            }
        });
    }

    //关闭第二线程
    public static void closeTwo(){
        end2 = false;
    }

    //启动第三线程
    public void startThree(){
        //设置启动
        end1 = true;

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(FrameBlocking.frameCompletion == false){
                    //接口和本地图片暂代填充
                    String s = EasyDl.doPostFile("http://127.0.0.1:24401/", "D:\\CoalImage\\coal@.jpg");
                    //获取元素对应值
                    Analysis analyzing = Analyzing.analyzing(s);
                    Coalmine coalMine = new Coalmine(1,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
                    System.out.println(coalMine);
                    //将解析值存入数据库
                    coalmineMapper.addCoalmine(coalMine);
                }
            }
        });
    }

    //关闭第三线程
    public static void closeThree(){
        end3 = false;
    }

    //启动第四线程
    public void startFour(){
        //设置启动
        //设置启动
        end1 = true;

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(FrameBlocking.frameCompletion == false){
                    //接口和本地图片暂代填充
                    String s = EasyDl.doPostFile("http://127.0.0.1:24401/", "D:\\CoalImage\\coal@.jpg");
                    //获取元素对应值
                    Analysis analyzing = Analyzing.analyzing(s);
                    Coalmine coalMine = new Coalmine(1,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
                    System.out.println(coalMine);
                    //将解析值存入数据库
                    coalmineMapper.addCoalmine(coalMine);
                }
            }
        });
    }

    //关闭第四线程
    public static void closeFour(){
        end4 = false;
    }

    //开启线程进行视频分帧
    public static void startFrame(){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                FrameBlocking frameBlocking = new FrameBlocking();
                frameBlocking.framing("D:\\CoalImage\\meiliu.mp4","coal","D:\\CoalImage");
            }
        });
    }

    //开启线程进行实时检测
    public static void startDetect(){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    RealDetect.detect();
                } catch (FrameGrabber.Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
