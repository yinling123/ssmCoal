//import coallnspection.mapper.CoalmineMapper;
//import coallnspection.mapper.CodeMapper;
//import coallnspection.mapper.ManagerMapper;
//import coallnspection.mapper.UserMapper;
//import coallnspection.pojo.*;
//import coallnspection.service.ManagerService;
//import com.alibaba.fastjson.JSON;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.io.InputStream;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * mapper接口的配置类
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring.xml"})
//@Controller
//public class TestMappers {
//
//    @Autowired
//    UserMapper userMapper;
//
//    @Autowired
//    CoalmineMapper coalmineMapper;
//
//    @Autowired
//    CodeMapper codeMapper;
//
//    @Autowired
//    ManagerService managerMapper;
//
//    @Test
//    public void testUserMapper() {
////        final int i = userMapper.addUser(new User("houyinbo3", "1232132", "ddddd"));
//        final Manager manager = managerMapper.checkManager(new Manager("hyb123", "hyb123"));
//        System.out.println(manager);
//    }
//
//    @Test
//    public void testCoalmineMapper(){
//        coalmineMapper.addCoalmine(new Coalmine(22,getCurrentTime(0),"ss",22,22));
//    }
//
//    @Test
//    public void testCodeMapper(){
//        codeMapper.addCode(new Code("2121212","3232323",getCurrentTime(0),getCurrentTime(1000 * 60)));
//    }
//
//    @Test
//    public void testSelectCode(){
////        System.out.println(1111);
//        final List<Code> codes = codeMapper.selectCodes("2121212", "3232323");
//        System.out.println(codes.get(0).toString());
//    }
//
//    @Test
//    public void testJson(){
//        List<User> workers = userMapper.selectAllUsers();
//        String string = JSON.toJSONString(workers);
//        System.out.println(string);
//    }
//
//
//    public static Timestamp getCurrentTime(int ts){
//        Date date = new Date();
//        date.setTime(date.getTime() + ts);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(date);
//        return new Timestamp(date.getTime());
//    }
//}
