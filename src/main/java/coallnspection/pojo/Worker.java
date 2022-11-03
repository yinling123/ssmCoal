package coallnspection.pojo;

public class Worker {

    private int id;
    private String name;
    private String job;
    private String phone;

    public Worker() {
    }

    public Worker(String name, String job, String phone) {
        this.name = name;
        this.job = job;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
