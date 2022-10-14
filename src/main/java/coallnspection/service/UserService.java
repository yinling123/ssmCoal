package coallnspection.service;

import coallnspection.pojo.User;

import java.util.List;

/**
 * 针对用户表需要进行的一系列操作接口
 */

public interface UserService {
    /**
     * 进行用户注册判断
     * @param user
     * @return 如果注册失败，返回false
     */
    public boolean signUp(User user);

    /**
     * 进行用户登录操作
     * @param user
     * @return 如果登录成功，返回ture
     */
    public boolean signIn(User user);

    /**
     * 查询用户名是否存在重复
     * @param username
     * @return 如果重复，返回false
     */
    public boolean checkUsername(String username);

    /**
     * 进行用户删除
     * @param user
     * @return
     */
    public boolean deleteUser(User user);

    /**
     * 进行密码修改
     * @param user
     * @return 若修改成功返回true
     */
    public boolean updatePassword(User user);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> checkUsers();
}
