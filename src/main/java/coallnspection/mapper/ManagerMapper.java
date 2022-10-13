package coallnspection.mapper;

import coallnspection.pojo.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员表的基本操作接口
 */
@Repository
public interface ManagerMapper {

    //进行管理员增加操作
    public int addManager(Manager manager);

    //进行管理员删除操作
    public int deleteManager(String username);

    //进行管理员查询操作
    public List<Manager> selectAllManager();

    //查询单个管理员
    public Manager selectManager(Manager manager);

}
