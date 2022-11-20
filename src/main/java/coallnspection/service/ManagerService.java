package coallnspection.service;

import coallnspection.pojo.Manager;

import java.util.List;

/**
 * 针对manager表的相关操作
 */
public interface ManagerService {

    /**
     * 增加管理员
     * @return 增加成功，返回true
     */
    public boolean addManager(Manager manager);

    /**
     * 删除管理员
     * @param manager
     * @return 删除成功，返回true
     */
    public boolean deleteManager(Manager manager);

    /**
     * 查看所有管理员
     * @return 返回管理员列表
     */
    public List<Manager> checkManagers();

    /**
     * 查看单个管理员
     */
    public Manager checkManager(Manager manager);

    /**
     * 查询用户名是否存在
     * @param manager
     * @return
     */
    public Manager checkUsername(String manager);

    /**
     * 进行用户更新
     * @param manager
     * @return
     */
    public boolean updateManager(Manager manager);

    public boolean updatePassword(String username, String oldPassword, String newPassword);
}
