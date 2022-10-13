import coallnspection.mapper.CoalmineMapper;
import coallnspection.mapper.UserMapper;
import coallnspection.pojo.Coalmine;
import coallnspection.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * mapper接口的配置类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestMappers {

    @Autowired
    UserMapper userMapper;

    @Autowired
    CoalmineMapper coalmineMapper;

    @Test
    public void testUserMapper() {
        userMapper.addUser(new User("houyinbo","1232132","ddddd"));
    }

    @Test
    public void testCoalmineMapper(){
        coalmineMapper.addCoalmine(new Coalmine(22,getCurrentTime(),"ss",22,22));
    }

    public static Timestamp getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return new Timestamp(date.getTime());
    }
}
