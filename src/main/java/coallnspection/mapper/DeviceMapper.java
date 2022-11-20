package coallnspection.mapper;

import coallnspection.pojo.Device;

import java.util.List;

/**
 * device表的操作类
 */
public interface DeviceMapper {

    /**
     * 查询所有的设备使用信息
     * @return
     */
    public List<Device> selectAll();

    /**
     * 增加设备使用信息
     * @param device
     * @return
     */
    public int addDevice(Device device);

    /**
     * 删除设备使用信息
     * @param id
     * @return
     */
    public int deleteDevice(int id);

    /**
     * 更新设备实用信息
     * @param device
     * @return
     */
    public int updateDevice(Device device);
}
