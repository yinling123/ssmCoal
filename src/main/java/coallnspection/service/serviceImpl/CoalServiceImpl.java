package coallnspection.service.serviceImpl;

import coallnspection.mapper.CoalmineMapper;
import coallnspection.pojo.Coalmine;
import coallnspection.service.CoalService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * coal数据表操作的相关实现类
 */

public class CoalServiceImpl implements CoalService {

    @Autowired
    CoalmineMapper coalmineMapper;

    @Override
    public boolean addCoal(Coalmine coalmine) {
        //进行增加操作
        int i = coalmineMapper.addCoalmine(coalmine);
        //进行判断
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public int countCoal() {
        //获取1分钟之内的异常物数目
        int account = coalmineMapper.getAccount();
        return account;
    }
}
