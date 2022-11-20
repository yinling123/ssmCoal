package coallnspection.pojo;

import java.sql.Timestamp;

/**
 * 设备使用的实体类
 */

public class Device {

    private int id;
    private String name;
    private String area;
    private Timestamp startTime;

    public Device() {
    }

    public Device(String name, String area, Timestamp startTime) {
        this.name = name;
        this.area = area;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
