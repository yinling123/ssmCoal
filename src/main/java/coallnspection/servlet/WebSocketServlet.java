package coallnspection.servlet;

import coallnspection.Thread.ThreadPool;
import coallnspection.pojo.Device;
import coallnspection.service.DeviceService;
import coallnspection.service.WebSocketService;
import coallnspection.utils.Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 进行有关websocket的相关操作
 */

@Controller
@RequestMapping(value = "/websocket")
public class WebSocketServlet {

    //进行自动装配
    @Autowired
    WebSocketService webSocketService;

    @Autowired
    ThreadPool threadPool;

    @Autowired
    DeviceService deviceService;

    /**
     *启动单个线程
     * @param id
     */
    @RequestMapping(value = "/start/{id}")
    public void sendOne(@PathVariable("id") String id, HttpSession httpSession){
        //获取当前的对象名称
        String username = (String)httpSession.getAttribute("username");
        //启动对应的线程并且进行对应的会话
        if(id.equals("1")){
            System.out.println(new Device(username, "区域1", Util.getCurrentTime(0)));
            deviceService.addDevice(new Device(username, "区域1", Util.getCurrentTime(0)));
            threadPool.startOne();
        }else if(id.equals("2")){
            deviceService.addDevice(new Device(username, "区域2", Util.getCurrentTime(0)));
            threadPool.startTwo();
        }else if(id.equals("3")){
            deviceService.addDevice(new Device(username, "区域3", Util.getCurrentTime(0)));
            threadPool.startThree();
        }else if(id.equals("4")){
            deviceService.addDevice(new Device(username, "区域4", Util.getCurrentTime(0)));
            threadPool.startFour();
        }else{
            throw new RuntimeException("连接不符合");
        }
    }

    /**
     * 启动所有线程
     */
    @RequestMapping(value = "/start/all")
    public void sendAll(){
        //启动所有监测
        threadPool.startOne();
        threadPool.startTwo();
        threadPool.startThree();
        threadPool.startFour();
    }

    /**
     * 停止某一个线程监测
     */
    @RequestMapping(value = "/stop/{id}")
    public void stopOne(@PathVariable("id") String id){
        if(id.equals("1")){
            threadPool.setStart1(0);
        }else if(id.equals("2")){
            threadPool.setStart2(0);
        }else if(id.equals("3")){
            threadPool.setStart3(0);
        }else if(id.equals("4")){
            threadPool.setStart4(0);
        }
    }

    /**
     * 停止所有实时视频，但是内部仍进行分帧处理
     */
    @RequestMapping(value = "/stop/all")
    public void stopAll(){
        threadPool.setStart1(0);
        threadPool.setStart2(0);
        threadPool.setStart3(0);
        threadPool.setStart4(0);
    }

    /**
     * 关闭某一个线程监测
     */
    @RequestMapping(value = "/close/{id}")
    public void closeOne(@PathVariable("id") String id){
        if(id.equals("1")){
            threadPool.setStart1(2);
        }else if(id.equals("3")){
            threadPool.setStart2(2);
        }else if(id.equals("3")){
            threadPool.setStart3(2);
        }else if(id.equals("4")){
            threadPool.setStart4(2);
        }
    }

    /**
     * 停止所有视频流
     */
    @RequestMapping(value = "/close/all")
    public void closeAll(){
        threadPool.setStart1(2);
        threadPool.setStart2(2);
        threadPool.setStart3(2);
        threadPool.setStart4(2);
    }

    @RequestMapping(value = "/test/{id}")
    public String sendPhotos(@PathVariable("id") String id){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 2; i <= 199; i++){
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        BufferedImage bufferedImage = ImageIO.read(new File("D:\\Note\\imge\\" + "coal@" + i +".jpg"));
                        ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);
//                        System.out.println(byteArrayOutputStream);
//                        synchronized (webSocketService){
//                            webSocketService.sendImage(byteArrayOutputStream,id);
//                        }
                        webSocketService.sendImage(byteArrayOutputStream,id);
                        Thread.sleep(200);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return "test2";
    }







}
