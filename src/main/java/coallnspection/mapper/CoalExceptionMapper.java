package coallnspection.mapper;

import coallnspection.pojo.CoalException;

import java.util.List;

/**
 * 针对coalException表的操作
 */
public interface CoalExceptionMapper {

    /**
     * 查询所有未解决的异常信息
     * @return
     */
    public List<CoalException> selectUnfinished();

    /**
     * 查询已经解决的异常信息
     * @return
     */
    public List<CoalException> selectFinished();

    /**
     * 更新当前煤块的状态
     * @return
     */
    public int updateCoalException(int id);

    /**
     * 增加异常信息
     * @param coalException
     * @return
     */
    public int addCoalException(CoalException coalException);

    /**
     * 删除对应的模块
     * @param id
     * @return
     */
    public int deleteCoalException(int id);

    /**
     * 删除所有异常信息
     * @return
     */
    public int deleteAllCoalException();
}
