public class Instructor implements Person {

    private int employeeId;
    private String name;
    private String department;

    public Instructor(int employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    @Override
    public int getId() {
        return employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getDescription() {
        return "Instructor: " + name + " | Department: " + department;
    }

    @Override
    public String toString() {
        return employeeId + " | " + name + " | " + department;
    }
}
