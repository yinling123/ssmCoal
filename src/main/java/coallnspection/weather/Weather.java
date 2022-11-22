package coallnspection.weather;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 获取当前的天气信息
 */
@Component
@SuppressWarnings("all")
public class Weather {

    /**
     * 获取当前的气温
     */
    public String getWeather() {
        String temperatue = null;
        try {
            URL url = new URL("http://t.weather.itboy.net/api/weather/city/101110103");
            InputStreamReader isReader = new InputStreamReader(url.openStream(), "UTF-8");//“UTF- 8”万国码，可以显示中文，这是为了防止乱码
            BufferedReader br = new BufferedReader(isReader);//采用缓冲式读入
            String str;
            while ((str = br.readLine()) != null) {
                String regex = "\\p{Punct}+";
                String digit[] = str.split(regex);
                System.out.println('\n' + "城市:" + digit[22] + digit[18]);
                System.out.println('\n' + "时间:" + digit[49] + "年" + digit[50] + "月" + digit[51] + "日" + digit[53]);
                System.out.println('\n' + "温度:" + digit[47] + "~" + digit[45]);
                System.out.println('\n' + "天气:" + digit[67] + " " + digit[63] + digit[65]);
                System.out.println('\n' + digit[69]);
                temperatue = digit[47] + "~" + digit[45];
            }
            br.close();//网上资源使用结束后，数据流及时关闭
            isReader.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }finally {
            return temperatue;
        }
    }

}
