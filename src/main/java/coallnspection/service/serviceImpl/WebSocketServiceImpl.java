package coallnspection.service.serviceImpl;

import coallnspection.Detect.RealDetect;
import coallnspection.service.WebSocketService;
import coallnspection.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class WebSocketServiceImpl implements WebSocketService {

    //对websocket对象进行自动装配
    @Autowired
    WebSocket webSocket;

    @Override
    public void sendImage(ByteArrayOutputStream byteArrayOutputStream, String id) {
        webSocket.sendImage(byteArrayOutputStream,id);
    }

    @Override
    public void sendMessage(String s, String id) {
        webSocket.sendOneMessage(id, s);
    }
}
