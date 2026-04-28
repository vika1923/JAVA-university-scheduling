import java.util.LinkedList;

public class RegisteredCourses{
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