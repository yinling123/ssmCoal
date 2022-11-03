package coallnspection.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 进行煤流检测数据的传递
 */

@Controller
@RequestMapping(value = "/coal")
public class CoalServlet {

    /**
     * 处理页面的ajax请求
     * @return
     */
    @RequestMapping(value = "/coal/ajax")
    @ResponseBody
    public String accountCoal(){
        return "";
    }


}
