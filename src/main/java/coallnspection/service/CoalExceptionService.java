package coallnspection.service;

import coallnspection.pojo.CoalException;

import java.util.List;

/**
 * coalException表的操作
 */
public interface CoalExceptionService {

    /**
     * 查询coalException表中未被处理的数据
     * @return
     */
    public List<CoalException> selectUnfinished();

    /**
     * 查询已经处理完的
     * @return
     */
    public List<CoalException> selectFinished();

    /**
     * 更新对应的状态
     * @param id
     * @return
     */
    public int updateCoalException(int id);

    /**
     * 删除对应的信息
     * @param id
     * @return
     */
    public int deleteCoalException(int id);

    /**
     * 进行增加异常信息
     * @param coalException
     * @return
     */
    public int addCoalException(CoalException coalException);

    /**
     * 删除所有信息
     * @return
     */
    public int deleteAll();

    /**
     * 查询所有信息
     * @return
     */
    public List<CoalException> selectALl();

    /**
     * 查询异常总数目
     * @return
     */
    public int countAll();

    /**
     * 查询完成的数目
     * @return
     */
    public int countFinished();

    /**
     * 查询未完成数目
     * @return
     */
    public int countUnfinished();
}
