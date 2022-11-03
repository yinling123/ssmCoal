package coallnspection.Detect;

import coallnspection.utils.Analyzing;
import coallnspection.utils.Util;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class EasyDl {

    //存储合并的流总体
//    public static List<byte[]> list = new LinkedList<>();

//    public static void main(String[] args) throws IOException {
//        System.out.println(doPostFile("http://127.0.0.1:24401/","D:\\projectTest\\Jdbc\\src\\img\\037.jpg"));
//        Util.refresh();
//    }

    /**
     * 适用于百度EasyDL 离线SDK服务请
     * @param  reqUrl 接口地址
     * @param bi 本地图片路径
     * @return java.lang.String
     **/
    public static String doPostFile(String reqUrl, BufferedImage bi) {
        HttpURLConnection url_con = null;
        String responseContent = null;
        try {
            URL url = new URL(reqUrl);
            url_con = (HttpURLConnection) url.openConnection();
            url_con.setRequestMethod("POST");
            url_con.setDoOutput(true);
            url_con.setRequestProperty("Content-type", "application/x-java-serialized-object");
            Util.readFileByBytes(bi,  url_con.getOutputStream());

//            list.add(((ByteArrayOutputStream)url_con.getOutputStream()).toByteArray());

            url_con.getOutputStream().flush();
            url_con.getOutputStream().close();

            InputStream in = url_con.getInputStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String tempLine = rd.readLine();
            StringBuffer tempStr = new StringBuffer();
            String crlf = System.getProperty("line.separator");
            while (tempLine != null) {
                tempStr.append(tempLine);
                tempStr.append(crlf);
                tempLine = rd.readLine();
            }
            responseContent = tempStr.toString();
            rd.close();
            in.close();
        } catch (IOException e) {
            System.out.println("请求错信息:"+e.getMessage());
        } finally {
            if (url_con != null) {
                url_con.disconnect();
            }
        }
        return responseContent;
    }
}