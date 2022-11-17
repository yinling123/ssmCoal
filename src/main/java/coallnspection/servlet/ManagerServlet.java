package coallnspection.servlet;

import coallnspection.pojo.Manager;
import coallnspection.pojo.User;
import coallnspection.pojo.Worker;
import coallnspection.service.ManagerService;
import coallnspection.service.UserService;
import coallnspection.service.WorkerService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员的界面servlet
 */

@SuppressWarnings("all")
@Controller
@RequestMapping(value = "/manager")
public class ManagerServlet {

    //进行自动装配
    @Autowired
    UserService userService;

    @Autowired
    WorkerService workerService;

    @Autowired
    ManagerService managerService;

    /**
     * 跳转到管理员个人界面
     * @return
     */
    @RequestMapping(value = "/toUser")
    public String toUser(){
        return "manager/user";
    }

    /**
     * 跳转到装置界面
     * @return
     */
    @RequestMapping(value = "/toDevice")
    public String toDevice(){
        return "manager/device";
    }

    /**
     * 跳转到账号信息界面
     * @return
     */
    @RequestMapping(value = "/toAccount")
    public String toAccount(){
        return "manager/account";
    }

    /**
     * 增加员工
     * @return
     */
    @RequestMapping(value = "/addWorker")
    public String addWorker(Worker worker, Model model){
        boolean b = workerService.addWorker(worker);
        //如果增加成功
        if(b){
            model.addAttribute("error","增加成功");
        }else{
            model.addAttribute("error","增加失败");
        }
        return "manager/user";
    }

    /**
     *进行员工删除
     * @param worker
     * @return
     */
    @RequestMapping(value = "/deleteWorker")
    public String deleteWorker(Worker worker,Model model){
        boolean b = workerService.deleteWorker(worker);
        //如果删除成功
        if(b){
            model.addAttribute("error","删除成功");
        }else{
            model.addAttribute("error","删除失败");
        }
        return "manager/user";
    }

    /**
     * 进行用户增加
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User user){
        // 进行用户增加
        boolean b = userService.signUp(user);
        if(b){
            return "";
        }else{
            return "";
        }
    }

    /**
     * 进行用户删除
     * @param user
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(User user){
        // 进行用户删除
        boolean b = userService.deleteUser(user);
        if(b){
            return "";
        }else{
            return "";
        }
    }

    /**
     * 给前台传递用户数据
     * @return
     */
    @RequestMapping(value = "/getUsers")
    public String getUser(Model model){
        List<Worker> workers = workerService.checkAllWorkers();
        String string = JSON.toJSONString(workers);
        model.addAttribute("userdata",string);
        return "manager/user";
    }

    /**
     * 进行用户页面的修改
     * @param phone
     * @param company
     * @return
     */
    @RequestMapping(value = "/updateManager")
    public String updateManager(String username, String password,String phone, String company){
        boolean b = managerService.updateManager(new Manager(username, password, phone, company));
        if(b){

        }else{

        }
        return "manager/account";
    }

    @RequestMapping(value = "/updatePassword")
    public String updatePassword(String oldPassword, String rePassword, String newPassword, HttpServletRequest request, Model model){
        //获取当前用户名
        String username = (String)request.getSession().getAttribute("username");
        System.out.println(username);
        //进行密码修改
        boolean b = managerService.updatePassword(username, oldPassword, newPassword);
        //如果修改成功
        if(b){
            model.addAttribute("error", "修改成功");
            return "redirect:/toAccount";
        }else{
            model.addAttribute("error", "原密码错误");
            return "manager/account";
        }
    }






}
