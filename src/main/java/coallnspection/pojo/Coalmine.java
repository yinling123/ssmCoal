package coallnspection.pojo;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * 煤流类的基本类型
 */
@Component
public class Coalmine {

    private Integer index;
    private int area;
    private Timestamp datetime;
    private String type;
    private int length;
    private int width;

    public Coalmine(){

    }

    public Coalmine(int area, Timestamp datetime, String type, int length, int width) {
        this.area = area;
        this.datetime = datetime;
        this.type = type;
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
