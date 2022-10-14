package coallnspection.mapper;

import coallnspection.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表的相关操作
 */

public interface UserMapper {

    //添加用户
    public int addUser(User user);

    //根据用户名删除用户
    public int deleteUser(String username);

    //修改用户密码
    public int updatePassword(@Param("username") String username, @Param("password") String password);

    //查询所有用户
    public List<User> selectAllUsers();

    //根据账号和密码查询单个用户(验证登录)
    public User selectUser(User user);

    //根据用户名查询单个用户(判断用户名是否存在)
    public User selectUsername(String username);

}
