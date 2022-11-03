package coallnspection.pojo;

import java.sql.Timestamp;

/**
 * 验证码对象
 */

@SuppressWarnings("all")
public class Code {

    String id;
    String phone;
    String code;

    public Code() {
    }

    Timestamp createtime;
    Timestamp endtime;

    public Code(String phone, String code, Timestamp createtime, Timestamp endtime) {
        this.phone = phone;
        this.code = code;
        this.createtime = createtime;
        this.endtime = endtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "Code{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", createtime=" + createtime +
                ", endtime=" + endtime +
                '}';
    }
}
