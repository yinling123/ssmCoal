package coallnspection.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import coallnspection.pojo.Analysis;


/**
 * 将EasyDl包解析后返回字符串进行解析，获取对应的值
 */

public class Analyzing {

    /**
     * 进行字符串解析，返回对应值
     * @param s
     * @return
     */
    public static Analysis analyzing(String s){

        //将字符串进行转化
        JSONObject parse = JSONObject.parseObject(s);
        System.out.println(parse);
        JSONArray results = (JSONArray) parse.get("results");
        final Object cost_ms = parse.get("cost_ms");

        if(results.size() > 0){
            //先转化为数组，在进行求解
            JSONObject jsonObject = (JSONObject) results.get(0);
            //获取标签属性
            final Object label = jsonObject.get("label");
            //获取长宽属性
            JSONObject location = (JSONObject) jsonObject.get("location");
            int length = (int) location.get("height");
            int width = (int) location.get("width");
            int left = (int) location.get("left");
            int top = (int) location.get("top");


            //创建对应数组
            Analysis analysis = null;

            //创建对应分析值
            if(label.equals("stone")){
                analysis = new Analysis("矸石",length,width,left,top);
            }else{
                analysis = new Analysis("大煤矿",length,width,left,top);
            }

            return analysis;
        }
        return null;
    }


}
