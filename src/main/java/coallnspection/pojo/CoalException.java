package coallnspection.pojo;

import java.sql.Timestamp;

/**
 * 煤流异常信息的实体类
 */
public class CoalException {

    private int id; //编号索引
    private byte state; //处理状态
    private Timestamp time; //当前异常时间
    private String context; //异常内容

    public CoalException() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
