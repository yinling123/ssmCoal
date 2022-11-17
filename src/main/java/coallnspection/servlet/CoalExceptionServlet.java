package coallnspection.servlet;

import coallnspection.pojo.CoalException;
import coallnspection.service.CoalExceptionService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 进行异常信息的操作
 */

@RequestMapping(value = "/coalException")
public class CoalExceptionServlet {

    @Autowired
    CoalExceptionService coalExceptionService;

    /**
     * 查询信息结果
     * @return
     */
    @RequestMapping(value = "/selectAll")
    public String selectAll(Model model){
        //查询对用的结果
        List<CoalException> coalExceptions = coalExceptionService.selectAll();
        String string = JSON.toJSONString(coalExceptions);
        model.addAttribute("coalExceptions", string);
        return "";
    }

}
