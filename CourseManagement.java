import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseManagement {
    private List<Course> courses;

    public CourseManagement() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added: " + course.getName());
    }

    public void updateCourse(int id, String newName, String newCode, String newDepartment) {
        for (Course course : courses) {
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
        courses.removeIf(course -> course.getId() == id);
        System.out.println("Course removed.");
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public List<Course> findCourse(String keyword) {
        return courses.stream()
                .filter(c -> c.getName().equalsIgnoreCase(keyword) || 
                             c.getCode().equalsIgnoreCase(keyword) || 
                             c.getDepartment().equalsIgnoreCase(keyword))
                .collect(Collectors.toList());
    }
}
