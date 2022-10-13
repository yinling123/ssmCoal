package coallnspection.message;

/**
 * 接收短信返回值
 */
public class MsgResult{
    //返回描述
    private String returnstatus;
    //返回状态码
    private Integer code;
    //错误消息
    private String remark;

    public String getReturnstatus() {
        return returnstatus;
    }

    public void setReturnstatus(String returnstatus) {
        this.returnstatus = returnstatus;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MsgResult{" +
                "returnstatus='" + returnstatus + '\'' +
                ", code=" + code +
                ", remark='" + remark + '\'' +
                '}';
    }
}

