package coallnspection.servlet;

import coallnspection.pojo.Code;
import coallnspection.pojo.Manager;
import coallnspection.pojo.User;
import coallnspection.service.CodeService;
import coallnspection.service.ManagerService;
import coallnspection.service.MessageService;
import coallnspection.service.UserService;
import coallnspection.utils.RandomCode;
import coallnspection.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 进行用户登录注册的servlet
 */

@SuppressWarnings("all")
@RequestMapping(value = "/login")
@Controller
public class LoginServlet {

    @Autowired
    UserService userService;

    @Autowired
    CodeService codeService;

    @Autowired
    MessageService messageService;

    @Autowired
    ManagerService managerService;

    /**
     * 进行登录页面重定向
     * @return
     */
    @RequestMapping(value = "/toSignIn")
    public String toSignIn(){
        //进行登录页面跳转
        return "redirect:login/login";
    }


    /**
     * 进行登录成功判断
     * @param username 用户名
     * @param password 密码
     * @return 返回跳转页面
     */
    @RequestMapping(value = "/signIn")
    public String signIn(String username,String password,Model model){
        //将值存储到回话域对象
        model.addAttribute("username", username);
        model.addAttribute("password",password);

        //先进行管理员登录判断
        Manager manager = managerService.checkManager(new Manager(username, password));

        //如果查询到管理员界面，则进行跳转
        if(manager != null){
            return "manager/user";
        }

        //当登录成功时进行页面跳转
        if(userService.signIn(new User(username,password,null))){
            return "user/user";
        }

        //登录失败的话，返回登录页面，并且进行数据回显
        return "login/login";
    }

//    public String signUp(String phone,String password){
//        if()
//    }

    /**
     * 进行注册页面的重定向
     * @return
     */
    @RequestMapping(value = "/toSignUp")
    public String toRegiste(){
        //进行用户注册
        return "login/register";
    }

    /**
     * 获取验证码并且进行发送
     */
    @RequestMapping(value = "/sendCode")
    public String sendCode(String phone, String username, String pwd, String repwd, Model model){
        model.addAttribute("username",username);
        model.addAttribute("pwd",pwd);
        model.addAttribute("repwd",repwd);
        model.addAttribute("phone",phone);

        //生成随机验证码，并进行存储
        String randomCode = RandomCode.randomCode(4);
        int i = codeService.addCode(new Code(phone, randomCode, Util.getCurrentTime(0), Util.getCurrentTime(1000 * 60)));

        //进行验证码发送
        messageService.codeMessage(phone,randomCode);

        //跳转回原页面
        return "login/register";

    }

    /**
     * 进行用户注册判断
     * @param username
     * @param password
     * @param phone
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(String username,String password,String phone,String code){
        //如果用户注册成功
        List<Code> codes = codeService.selectCodes(phone, code);

        //如果当前验证码错误或者超时
        if(codes.size() <= 0){
            return "login/register";
        }

        if(userService.signUp(new User(username,password,phone))){
            return "login/login";
        }else{
            return "login/register";
        }
    }

}
