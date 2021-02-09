package Project;

public class Category {
  private Integer ID;
  private String  name;
  private String status;

  public Category() {
  }

  public void setID(Integer ID) {
    this.ID = ID;
  }

  public Integer getID() {
    return ID;
  }

  public Category(Integer ID, String name) {
    this.ID = ID;
    this.name = name;
  }

  public Category(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Category{" +
            "ID=" + ID +
            ", name='" + name + '\'' +
            ", status='" + status + '\'' +
            '}';
  }

  public Category(Integer ID, String name, String status) {
    this.ID = ID;
    this.name = name;
    this.status = status;
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

