package coallnspection.servlet;

import coallnspection.pojo.Device;
import coallnspection.pojo.Manager;
import coallnspection.pojo.User;
import coallnspection.pojo.Worker;
import coallnspection.service.DeviceService;
import coallnspection.service.ManagerService;
import coallnspection.service.UserService;
import coallnspection.service.WorkerService;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    DeviceService deviceService;

    /**
     * 跳转到管理员个人界面
     * @return
     */
    @RequestMapping(value = "/toUser")
    public String toUser(){
        return "redirect:/manager/getUsers";
    }

    /**
     * 跳转到管理员个人界面
     * @return
     */
    @RequestMapping(value = "/toWorker")
    public String toWorker(){
        return "redirect:/manager/getWorkers";
    }

    /**
     * 跳转到装置界面
     * @return
     */
    @RequestMapping(value = "/toDevice")
    public String toDevice(){
        return "redirect:/manager/getDevices";
    }

    /**
     * 跳转到账号信息界面
     * @return
     */
    @RequestMapping(value = "/toAccount")
    public String toAccount(){
        return "redirect:/manager/getAccount";
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
        return "manager/worker";
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
        return "manager/worker";
    }

    @RequestMapping(value = "/getWorkers")
    public String getWorkers(Model model){
        List<Worker> workers = workerService.checkAllWorkers();
        String string = JSON.toJSONString(workers);
        model.addAttribute("workers",string);
        System.out.println(string);
        return "manager/worker";
    }

    /**
     * 进行用户增加
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User user, Model model){
        // 进行用户增加
        boolean b = userService.signUp(user);
        if(b){
            //如果删除成功,重定向到其他程序进行数据查找
            model.addAttribute("error", "删除成功");
            return "forward:/manager/getUsers";
        }else{
            //删除失败返回原界面
            model.addAttribute("error", "删除失败");
            return "manager/user";
        }
    }

    /**
     * 进行用户删除
     * @param user
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(User user, Model model){
        // 进行用户删除
        boolean b = userService.deleteUser(user);
        if(b){
            //如果删除成功,重定向到其他程序进行数据查找
            model.addAttribute("error", "删除成功");
            return "forward:/manager/getUsers";
        }else{
            //删除失败返回原界面
            model.addAttribute("error", "删除失败");
            return "manager/user";
        }
    }

    /**
     * 给前台传递用户数据
     * @return
     */
    @RequestMapping(value = "/getUsers")
    public String getUsers(Model model){
        List<User> users = userService.checkUsers();
        String string = JSON.toJSONString(users);
        model.addAttribute("users",string);
        System.out.println(string);
        return "manager/user";
    }

    /**
     * 查询设备信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/getDevices")
    public String getDevices(Model model){
        //查询所有的设备信息
        List<Device> devices = deviceService.selectAll();
        String string = JSON.toJSONStringWithDateFormat(devices,"yyyy-MM-dd HH:mm:ss");
        model.addAttribute("devices", string);
        return "manager/device";
    }

    /**
     * 增加设备信息
     * @param device
     * @param model
     * @return
     */
    @RequestMapping(value = "/addDevice")
    public String addDevice(Device device, Model model){
        boolean b = deviceService.addDevice(device);
        if(b){
            //如果增加成功
            model.addAttribute("error", "增加成功");
            return "forward:/manager/getDevices";
        }else{
            model.addAttribute("error", "增加失败");
            return "manager/device";
        }
    }

    /**
     * 删除设备信息
     * @param device
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteDevice")
    public String deleteDevice(Device device, Model model){
        boolean b = deviceService.addDevice(device);
        if(b){
            //如果增加成功
            model.addAttribute("error", "删除成功");
            return "forward:/manager/getDevices";
        }else{
            model.addAttribute("error", "删除失败");
            return "manager/device";
        }
    }

    /**
     * 获取管理员账号信息
     * @return
     */
    @RequestMapping(value = "/getAccount")
    public String getAccount(HttpSession httpSession, Model model){
        //获取当前登录的管理员信息
        String username = (String)httpSession.getAttribute("username");
        //进行查询
        Manager manager = managerService.checkUsername(username);
        //将各项数据存储到域对象中
        model.addAttribute("username", manager.getUsername());
        model.addAttribute("phone", manager.getPhone());
        model.addAttribute("company", manager.getCompany());
        //返回到该视图
        return "manager/account";
    }

    /**
     * 进行管理员信息修改
     * @param phone
     * @param company
     * @return
     */
    @RequestMapping(value = "/updateManager")
    public String updateManager(String username, String password, String phone, String company, Model model){
        boolean b = managerService.updateManager(new Manager(username, password, phone, company));
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("phone", phone);
        model.addAttribute("company", company);
        //如果修改成功
        if(b){
            model.addAttribute("error", "修改成功");
        }else{
            model.addAttribute("error", "修改失败");
        }
        return "manager/account";
    }

    @RequestMapping(value = "/updatePassword")
    public String updatePassword(String oldPassword, String newPassword, String rePassword, HttpServletRequest request, Model model){
        //获取当前用户名
        String username = (String)request.getSession().getAttribute("username");
        System.out.println(username);
        //进行密码修改
        boolean b = managerService.updatePassword(username, oldPassword, newPassword);
        //如果修改成功
        if(b){
            model.addAttribute("error", "修改成功");
            return "manager/account";
        }else{
            model.addAttribute("error", "原密码错误");
            return "manager/account";
        }
    }






}
