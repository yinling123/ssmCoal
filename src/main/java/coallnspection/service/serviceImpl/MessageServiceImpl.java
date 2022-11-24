package coallnspection.service.serviceImpl;

import coallnspection.mapper.WorkerMapper;
import coallnspection.message.MsgResult;
import coallnspection.message.SendMessage;
import coallnspection.service.MessageService;
import coallnspection.utils.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 进行信息发送的服务
 */

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    SendMessage sendMessage;

    @Autowired
    WorkerMapper workerMapper;

    @Override
    public void codeMessage(String phone,String randomCode) {
        //进行验证码发送
        MsgResult msgResult = sendMessage.sendMsgPost("19880036651","19880036651","860aa858","B96FC554",phone,randomCode);
        //进行判断
        if("success".equals(msgResult.getReturnstatus()) && msgResult.getCode()==0){
            System.out.println("发送成功");
        }else{
            System.out.println("发送失败，原因是："+msgResult.getRemark());
        }
    }

    @Override
    public void coalMessage(String phone,String template) {
        //进行验证码发送
        MsgResult msgResult = sendMessage.sendMsgPost("19880036651","19880036651","58a04cd1",template,phone,"0");
        //进行判断
        if("success".equals(msgResult.getReturnstatus()) && msgResult.getCode()==0){
            System.out.println("发送成功");
        }else{
            System.out.println("发送失败，原因是："+msgResult.getRemark());
        }
    }
}
