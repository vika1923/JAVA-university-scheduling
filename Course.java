public class Course {
    private int id;
    private String name;
    private String code;
    private String department;

    public Course(int id, String name, String code, String department) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
