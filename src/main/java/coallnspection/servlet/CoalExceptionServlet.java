package coallnspection.servlet;

import coallnspection.pojo.CoalException;
import coallnspection.service.CoalExceptionService;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

/**
 * 进行异常信息的操作
 */

@Controller
@RequestMapping(value = "/coalException")
public class CoalExceptionServlet {

    @Autowired
    CoalExceptionService coalExceptionService;

    /**
     * 查询信息结果
     * @return
     */
    @RequestMapping(value = "/selectUnfinished")
    public String selectUnfinished(Model model){
        //查询对用的结果
        List<CoalException> coalExceptions = coalExceptionService.selectUnfinished();
        String string = JSON.toJSONString(coalExceptions);
        model.addAttribute("unfinished", string);
        return "user/information";
    }

    /**
     * 查询所有被解决的值
     * @return
     */
    @RequestMapping(value = "/selectFinished")
    public String selectFinished(Model model){
        List<CoalException> coalExceptions = coalExceptionService.selectFinished();
        String string = JSON.toJSONString(coalExceptions);
        model.addAttribute("finished", string);
        return "user/information";
    }

    /**
     * 解决已经处理的请求
     * @return
     */
    @RequestMapping(value = "/updateException/{id}")
    public String updateException(@PathVariable("id") String id){
        int i = coalExceptionService.updateCoalException(Integer.parseInt(id));
        return "redirect:user/selectFinished";
    }

    /**
     * 查询所有信息
     * @return
     */
    @RequestMapping(value = "/selectAll")
    public String selectAll(Model model){
        final List<CoalException> coalExceptions = coalExceptionService.selectALl();
        final int i = coalExceptionService.countAll();
        final int i1 = coalExceptionService.countFinished();
        final int i2 = coalExceptionService.countUnfinished();
        final String string = JSON.toJSONString(coalExceptions);
        System.out.println(string);
        model.addAttribute("exceptions", string);
        model.addAttribute("all", i);
        model.addAttribute("finished", i1);
        model.addAttribute("unfinished", i2);
        return "user/information";
    }


}
