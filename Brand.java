package Project;

public class Brand {
    private Integer ID;
    private String  name;
    private String status;

    public Brand() {
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public Brand(Integer ID, String name, String status) {
        this.ID = ID;
        this.name = name;
        this.status = status;
    }

    public Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
