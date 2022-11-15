package coallnspection.service.serviceImpl;

import coallnspection.mapper.ManagerMapper;
import coallnspection.pojo.Manager;
import coallnspection.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    @Override
    public boolean addManager(Manager manager) {
        //进行管理员增加
        int i = managerMapper.addManager(manager);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteManager(Manager manager) {
        //进行管理员删除
        int i = managerMapper.deleteManager(manager.getUsername());
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Manager> checkManagers() {
        //进行管理员查询
        List<Manager> managers = managerMapper.selectAllManager();
        return managers;
    }

    @Override
    public Manager checkManager(Manager manager) {
        Manager manager1 = managerMapper.selectManager(manager);
        return manager1;
    }

    @Override
    public List<Manager> checkUsername(Manager manager) {
        List<Manager> managers = managerMapper.checkUsername(manager);
        return managers;
    }

    @Override
    public boolean updateManager(Manager manager) {
        //先进行删除，再增加
        int i = managerMapper.deleteManager(manager.getUsername());
        int i1 = managerMapper.addManager(manager);
        if(i1 > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePassword(String username, String password) {
        boolean b = managerMapper.updatePassword(username, password);
        return b;
    }


}
