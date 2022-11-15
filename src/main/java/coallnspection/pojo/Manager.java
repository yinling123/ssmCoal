package coallnspection.pojo;

/**
 * 管理员的对象类
 */

public class Manager {

    private String username;
    private String password;
    private String phone;
    private String company;

    public Manager() {
    }

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Manager(String username, String password, String phone, String company) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.company = company;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
