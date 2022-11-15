package coallnspection.mapper;

import coallnspection.pojo.Manager;
import org.apache.ibatis.annotations.Param;
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

    //查看管理员用户名是否存在
    public List<Manager> checkUsername(Manager manager);

    //修改管理员密码
    public boolean updatePassword(@Param("username") String username, @Param("password") String password);
}
