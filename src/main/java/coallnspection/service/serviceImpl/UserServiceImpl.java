package coallnspection.service.serviceImpl;

import coallnspection.mapper.UserMapper;
import coallnspection.pojo.User;
import coallnspection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean signUp(User user) {
        //进行用户增加
        int i = userMapper.addUser(user);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean signIn(User user) {
        //进行用户登录
        User user1 = userMapper.selectUser(user);
        if(user1 != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        //用户名判断
        User user = userMapper.selectUsername(username);
        if(user == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        //进行用户删除
        int i = userMapper.deleteUser(user.getUsername());
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePassword(User user) {
        //进行密码更新
        int i = userMapper.updatePassword(user.getUsername(), user.getPassword());
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<User> checkUsers() {
        //列举出所有元素
        List<User> users = userMapper.selectAllUsers();
        return users;
    }
}
