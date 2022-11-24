import coallnspection.weather.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestWeather {

    @Autowired
    Weather weather;
    @Test
    public void testWeather(){
        String temperature = weather.getWeather();
        String[] split = temperature.split("~");
        System.out.println(split[0].split(" ")[1]);
        System.out.println(split[1].split(" ")[1]);
    }
}
