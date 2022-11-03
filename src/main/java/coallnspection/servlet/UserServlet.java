package coallnspection.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户功能的跳转实现
 */
@RequestMapping(value = "/user")
@Controller
public class UserServlet {

    /**
     * 跳转到主题外观界面
     * @return
     */
    @RequestMapping(value = "/appearance")
    public String toAppearance(){
        return "/user/appearance";
    }

    /**
     * 跳转到表格界面
     * @return
     */
    @RequestMapping(value = "/dataChart")
    public String toDataChart(){
        return "/user/dataChart";
    }

    /**
     * 跳转到信息界面
     * @return
     */
    @RequestMapping(value = "/information")
    public String toInformation(){
        return "/user/information";
    }

    /**
     * 跳转到监控界面
     * @return
     */
    @RequestMapping(value = "/monitor")
    public String toMonitor(){
        return "/user/monitor";
    }

    /**
     * 跳转到用户界面
     * @return
     */
    @RequestMapping(value = "/user")
    public String toUser(){
        return "/user/user";
    }


}
