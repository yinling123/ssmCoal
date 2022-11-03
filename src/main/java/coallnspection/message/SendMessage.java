package coallnspection.message;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;

@Component
public class SendMessage {
    /**
     * 封装的发验证码的方法
     * @param account 平台账户
     * @param password 平台密码
     * @param token 平台token
     * @param templateid 短信模板id
     * @param phone 短信接收方手机号
     * @param code  验证码
     * @return
     */
    public MsgResult sendMsgPost(String account,String password,String token,String templateid,String phone,String code){
        //时间戳
        long timestamp = System.currentTimeMillis();
        //System.out.println(timestamp);
        //url
        String url = "http://www.lokapi.cn/smsUTF8.aspx";
        //签名
        String beforSign = "action=sendtemplate&username="+account+"&password="+getMD5String(password)+"&token="+token+"&timestamp="+timestamp;
        //参数串
        String postData = "action=sendtemplate&username="+account+"&password="+getMD5String(password)+"&token="+token+"&templateid="+templateid+"&param="+phone+"|"+code+"&rece=json&timestamp="+timestamp+"&sign="+getMD5String(beforSign);
        //发送请求
        String result = sendPost(url,postData);
        //将json结果转为对象，方便判断
        MsgResult msgResult = JSON.parseObject(result, MsgResult.class);
        return msgResult;
    }
    //原本的发送方法
    public String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        } finally{  //使用finally块来关闭输出流、输入流
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    //用来计算MD5的函数
    public String getMD5String(String rawString){
        String[] hexArray = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(rawString.getBytes());
            byte[] rawBit = md.digest();
            String outputMD5 = " ";
            for(int i = 0; i<16; i++){
                outputMD5 = outputMD5+hexArray[rawBit[i]>>>4& 0x0f];
                outputMD5 = outputMD5+hexArray[rawBit[i]& 0x0f];
            }
            return outputMD5.trim();
        }catch(Exception e){
            System.out.println("计算MD5值发生错误");
            e.printStackTrace();
        }
        return null;
    }
}

