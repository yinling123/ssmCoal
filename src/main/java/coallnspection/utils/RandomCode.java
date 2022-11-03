package coallnspection.utils;

import java.util.Random;

/**
 * 随机生成四位验证码
 */

public class RandomCode {

    /**
     * 随机生成n位验证码
     * @param n
     * @return
     */
    public static String randomCode(int n) {
        Random r = new Random();
        String code = " ";//分配一个空字符内存
        for(int i = 0; i < n; i++) {
            int type = r.nextInt(3);
            switch(type) {
                case 0://大写字母
                    char c0 = (char)(r.nextInt(26) + 65);//ASII中大写字母的范围
                    code += c0;
                    break;
                case 1 ://小写字母
                    char c1 = (char)(r.nextInt(26) + 97);//ASII中小写字母的范围
                    code += c1;
                    break;
                case 2://数字
                    int m = r.nextInt(10);//生成0~9的随机数
                    code += m;
                    break;

            }
        }
        return code;
    }
}
