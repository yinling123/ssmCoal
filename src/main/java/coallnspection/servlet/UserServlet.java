package coallnspection.servlet;

import coallnspection.service.CoalExceptionService;
import coallnspection.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 用户功能的跳转实现
 */
@SuppressWarnings("all")
@RequestMapping(value = "/user")
@Controller
public class UserServlet {

    @Autowired
    WeatherService weatherService;

    /**
     * 跳转到主题外观界面
     * @return
     */
    @RequestMapping(value = "/toAppearance")
    public String toAppearance(Model model){
        model.addAttribute("themes", "theme2.css");
        return "user/appearance";
    }

    /**
     * 跳转到表格界面
     * @return
     */
    @RequestMapping(value = "/toDataChart")
    public String toDataChart(){
        return "user/dataChart";
    }

    /**
     * 跳转到信息界面
     * @return
     */
    @RequestMapping(value = "/toInformation")
    public String toInformation(){
        return "user/information";
    }

    /**
     * 跳转到监控界面
     * @return
     */
    @RequestMapping(value = "/toMonitor")
    public String toMonitor(){
        return "user/monitor";
    }

    /**
     * 跳转到用户界面
     * @return
     */
    @RequestMapping(value = "/toUser")
    public String toUser(Model model){
        //获取当前的气温
        String temperature = weatherService.getTemperature();
        String[] split = temperature.split("~");
        model.addAttribute("minTemperature", split[0]);
        model.addAttribute("maxTemperature", split[1]);
        return "user/user";
    }


}
