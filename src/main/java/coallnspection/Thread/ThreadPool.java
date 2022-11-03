package coallnspection.Thread;

import coallnspection.Detect.EasyDl;
import coallnspection.Detect.RealDetect;
import coallnspection.mapper.CoalmineMapper;
import coallnspection.pojo.Analysis;
import coallnspection.pojo.Coalmine;
import coallnspection.utils.*;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.FrameGrabber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author hyb
 * @school Xust
 * 设置线程池进行同时检测，并进行管理
 */

@Slf4j
@Component
@SuppressWarnings("all")
public class ThreadPool {

    //创建线程池,最大可以支持
    static ExecutorService executorService = Executors.newFixedThreadPool(8);

    //创建mapper接口
    @Autowired
    CoalmineMapper coalmineMapper;

    //创建6个检测类,分别表示六个监控录像
    private RealDetect realDetect1 = new RealDetect();
    private RealDetect realDetect2 = new RealDetect();
    private RealDetect realDetect3 = new RealDetect();
    private RealDetect realDetect4 = new RealDetect();

    //记录总开启线程
    private int num;

    //进行判断
    private int start1;
    private int start2;
    private int start3;
    private int start4;

    public RealDetect getRealDetect1() {
        return realDetect1;
    }

    public void setRealDetect1(RealDetect realDetect1) {
        this.realDetect1 = realDetect1;
    }

    public RealDetect getRealDetect2() {
        return realDetect2;
    }

    public void setRealDetect2(RealDetect realDetect2) {
        this.realDetect2 = realDetect2;
    }

    public RealDetect getRealDetect3() {
        return realDetect3;
    }

    public void setRealDetect3(RealDetect realDetect3) {
        this.realDetect3 = realDetect3;
    }

    public RealDetect getRealDetect4() {
        return realDetect4;
    }

    public void setRealDetect4(RealDetect realDetect4) {
        this.realDetect4 = realDetect4;
    }

    //开启一个线程进行监测
    public void startAny(String userid){
        if(userid.equals("1")){
            startOne();
        }else if(userid.equals("2")){
            startTwo();
        }else if(userid.equals("3")){
            startThree();
        }else{
            startFour();
        }
    }

    //启动第一线程进行监测
    public void startOne(){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                num++;
                start1 = 1;
                try {
                    realDetect1.detect(start1,num,1);
                } catch (FrameGrabber.Exception e) {
                    e.printStackTrace();
                }finally {
                    log.info("主窗口1监测完成");
                    num--;
                }
            }
        });
    }

    public int getStart1() {
        return start1;
    }

    public void setStart1(int start1) {
        this.start1 = start1;
    }

    public int getStart2() {
        return start2;
    }

    public void setStart2(int start2) {
        this.start2 = start2;
    }

    public int getStart3() {
        return start3;
    }

    public void setStart3(int start3) {
        this.start3 = start3;
    }

    public int getStart4() {
        return start4;
    }

    public void setStart4(int start4) {
        this.start4 = start4;
    }

    //启动第二线程
    public void startTwo(){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                num++;
                start2 = 1;
                try {
                    realDetect1.detect(start2,num,2);
                } catch (FrameGrabber.Exception e) {
                    e.printStackTrace();
                }finally {
                    log.info("主窗口2监测完成");
                    num--;
                }
            }
        });
    }

    //启动第三线程
    public void startThree(){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                num++;
                start3 = 1;
                try {
                    realDetect1.detect(start3,num,3);
                } catch (FrameGrabber.Exception e) {
                    e.printStackTrace();
                }finally {
                    log.info("主窗口3监测完成");
                    num--;
                }
            }
        });
    }

    //启动第四线程
    public void startFour(){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                num++;
                start4 = 1;
                try {
                    realDetect1.detect(start4,num,4);
                } catch (FrameGrabber.Exception e) {
                    e.printStackTrace();
                }finally {
                    log.info("主窗口4监测完成");
                    num--;
                }
            }
        });
    }

    //开启线程进行视频分帧
//    public static void startFrame(){
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                FrameBlocking frameBlocking = new FrameBlocking();
//                frameBlocking.framing("D:\\CoalImage\\meiliu.mp4","coal","D:\\CoalImage");
//            }
//        });
//    }

    //开启线程进行实时检测
//    public static void startDetect(){
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    new RealDetect().detect();
//                } catch (FrameGrabber.Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

}
