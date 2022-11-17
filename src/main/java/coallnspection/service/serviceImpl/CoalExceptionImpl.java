package coallnspection.service.serviceImpl;

import coallnspection.mapper.CoalExceptionMapper;
import coallnspection.pojo.CoalException;
import coallnspection.service.CoalExceptionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoalExceptionImpl implements CoalExceptionService {

    @Autowired
    CoalExceptionMapper coalExceptionMapper;

    @Override
    public List<CoalException> selectAll() {
        //返回对应的存储列表
        List<CoalException> coalExceptions = coalExceptionMapper.selectAll();
        return coalExceptions;
    }

    @Override
    public int updateCoalException(int id) {
        //返回对应的结果
        int i = coalExceptionMapper.updateCoalException(id);
        return i;
    }

    @Override
    public int deleteCoalException(int id) {
        //删除对应异常行
        int i = coalExceptionMapper.deleteCoalException(id);
        return i;
    }

    @Override
    public int addCoalException(CoalException coalException) {
        //增加异常信息
        int i = coalExceptionMapper.addCoalException(coalException);
        return i;
    }

    @Override
    public int deleteAll() {
        //删除所有信息
        int i = coalExceptionMapper.deleteAllCoalException();
        return i;
    }
}
