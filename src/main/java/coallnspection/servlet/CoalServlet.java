package coallnspection.servlet;

import coallnspection.service.CoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :hyb
 * @shool :xust
 * 进行煤流检测数据的传递
 */
@SuppressWarnings("all")
@Controller
@RequestMapping(value = "/coal")
public class CoalServlet {

    @Autowired
    CoalService coalService;

    /**
     * 获取各个四个区域各自的变化值
     * @return
     */
    @RequestMapping(value = "/coal/ajax")
    @ResponseBody
    public Map<Integer,Integer> accountArea(){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= 4; i++){
            map.put(i,coalService.countArea(i));
        }
        return map;
    }



}
