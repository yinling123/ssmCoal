package coallnspection.service;

/**
 * 进行验证码和各类报错信息的发送
 */
public interface MessageService {

    /**
     * 发送用户登录验证码
     */
    public void codeMessage(String phone,String randomCode);

    /**
     * 发送检测过程中的异常信息，给对应的人员
     */
    public void coalMessage(String phone,String token);
}
