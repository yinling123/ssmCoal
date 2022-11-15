package coallnspection.service;

import coallnspection.pojo.Coalmine;

/**
 * 进行Coal数据表使用的相关操作的接口
 */
public interface CoalService {

    /**
     *进行煤矿增加操作
     * @param coalmine
     * @return
     */
    public boolean addCoal(Coalmine coalmine);

    /**
     *进行煤矿异常总数目查询操作
     */
    public int countCoal();

    /**
     * 求出对应的区域的煤矿数目
     */
    public int countArea(int area);

}
