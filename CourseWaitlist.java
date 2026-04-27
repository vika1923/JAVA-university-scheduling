import java.util.LinkedList;
import java.util.Queue;

public class CourseWaitlist {
    private String courseName;
    private Queue<Student> waitlist;

    public CourseWaitlist(String courseName) {
        this.courseName = courseName;
        this.waitlist = new LinkedList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enqueue(Student student) {
        waitlist.add(student);
        System.out.println(student.getName() + " has been added to the waitlist for " + courseName + ".");
    }

    public Student dequeue() {
        if (waitlist.isEmpty()) {
            System.out.println("Waitlist for " + courseName + " is empty. No students to register.");
            return null;
        }
        Student student = waitlist.poll();
        System.out.println(student.getName() + " has been removed from the waitlist and registered for " + courseName + ".");
        return student;
    }

    public Student peek() {
        if (waitlist.isEmpty()) {
            System.out.println("Waitlist for " + courseName + " is empty.");
            return null;
        }
        return waitlist.peek();
    }

    public boolean isEmpty() {
        return waitlist.isEmpty();
    }

    public int size() {
        return waitlist.size();
    }
}
