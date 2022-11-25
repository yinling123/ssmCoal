package coallnspection.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

/**
 * 煤流异常信息的实体类
 */
public class CoalException {

    private int id; //编号索引

    private byte state = 1; //处理状态

    private Timestamp time; //当前异常时间

    private String context; //异常内容

    private String flag = "未解决";

    public CoalException() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(byte state) {
        this.state = state;
        if(state == 0){
            this.flag = "已经解决";
        }
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String isFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public byte getState() {
        return state;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getContext() {
        return context;
    }

    public String getFlag() {
        return flag;
    }
}
