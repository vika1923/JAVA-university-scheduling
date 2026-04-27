import java.util.LinkedList;

class RegisteredCourses{
    private LinkedList<Course> courses;

    public RegisteredCourses() {
        this.courses = new LinkedList<Course>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public boolean containsCourse(Course course) {
        return courses.contains(course);
    }

    public Course getFirstCourse() {
        return courses.getFirst();
    }

    public int size() {
        return courses.size();
    }
}

class Course{
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

    public String getCode() {
        return code;
    }

    public String getDepartment() {
        return department;
    }
}