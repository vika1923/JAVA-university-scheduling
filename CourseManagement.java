import java.util.ArrayList;
import java.util.List;

public class CourseManagement {
    private List<Course> courses;

    public CourseManagement() {
        this.courses = new ArrayList<Course>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added: " + course.getName());
    }

    public void updateCourse(int id, String newName, String newCode, String newDepartment) {
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course.getId() == id) {
                if (newName != null && !newName.isEmpty()) course.setName(newName);
                if (newCode != null && !newCode.isEmpty()) course.setCode(newCode);
                if (newDepartment != null && !newDepartment.isEmpty()) course.setDepartment(newDepartment);
                System.out.println("Course updated: " + course.getName());
                return;
            }
        }
        System.out.println("Course not found.");
    }

    public void removeCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.remove(i);
                System.out.println("Course removed.");
                return;
            }
        }
        System.out.println("Course not found.");
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public List<Course> findCourse(String keyword) {
        List<Course> result = new ArrayList<Course>();
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            if (c.getName().equalsIgnoreCase(keyword) ||
                c.getCode().equalsIgnoreCase(keyword) ||
                c.getDepartment().equalsIgnoreCase(keyword)) {
                result.add(c);
            }
        }
        return result;
    }
}
