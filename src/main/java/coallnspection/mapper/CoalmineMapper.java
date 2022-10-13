package coallnspection.mapper;

import coallnspection.pojo.Coalmine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoalmineMapper {

    //插入煤流异常数据
    public int addCoalmine(Coalmine coalmine);

    //查询所有数据
    public List<Coalmine> selectAllCoalmine();

    //获取每分钟的异常数目
    public int getAccount();
}
