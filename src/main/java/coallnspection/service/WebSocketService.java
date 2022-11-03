package coallnspection.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

public interface WebSocketService {

    /**
     * 将后台进行标注完成的数据利用websocket给对应的用户发送处理完的字节流
     */
    public void sendImage(ByteArrayOutputStream byteArrayOutputStream, String id);

}
