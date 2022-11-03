package coallnspection.servlet;

import coallnspection.pojo.User;
import coallnspection.pojo.Worker;
import coallnspection.service.ManagerService;
import coallnspection.service.UserService;
import coallnspection.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员的界面servlet
 */

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
        return "/manager/user";
    }

    /**
     * 跳转到装置界面
     * @return
     */
    @RequestMapping(value = "/toDevice")
    public String toDevice(){
        return "/manager/device";
    }

    /**
     * 跳转到账号信息界面
     * @return
     */
    @RequestMapping(value = "/toAccount")
    public String toAccount(){
        return "/manager/account";
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

        }else{

        }
        return "";
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

        }else{

        }
        return "";
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





}
