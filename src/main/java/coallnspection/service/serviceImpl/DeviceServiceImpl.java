package coallnspection.service.serviceImpl;

import coallnspection.mapper.DeviceMapper;
import coallnspection.pojo.Device;
import coallnspection.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<Device> selectAll() {
        List<Device> devices = deviceMapper.selectAll();
        return devices;
    }

    @Override
    public boolean addDevice(Device device) {
        int i = deviceMapper.addDevice(device);
        if(i > 0){
            //成功添加了
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateDevice(Device device) {
        int i = deviceMapper.updateDevice(device);
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteDevice(int id) {
        int i = deviceMapper.deleteDevice(id);
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }
}
