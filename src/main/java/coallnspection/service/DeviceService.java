package coallnspection.service;

import coallnspection.pojo.Device;

import java.util.List;

/**
 * device表的服务操作
 */

public interface DeviceService {

    /**
     * 查询所有的服务
     * @return
     */
    public List<Device> selectAll();

    /**
     *增加设备
     * @param device
     * @return
     */
    public boolean addDevice(Device device);

    /**
     * 更新对应的device
     * @param device
     * @return
     */
    public boolean updateDevice(Device device);

    /**
     * 删除对应的device
     * @param id
     * @return
     */
    public boolean deleteDevice(int id);

}
