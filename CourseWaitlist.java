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

    // Adds a student to the back of the waitlist when the course is full
    public void enqueue(Student student) {
        waitlist.add(student);
        System.out.println(student.getName() + " has been added to the waitlist for " + courseName + ".");
    }

    // Removes and registers the student at the front of the waitlist when a spot opens
    public Student dequeue() {
        if (waitlist.isEmpty()) {
            System.out.println("Waitlist for " + courseName + " is empty. No students to register.");
            return null;
        }
        Student student = waitlist.poll();
        System.out.println(student.getName() + " has been removed from the waitlist and registered for " + courseName + ".");
        return student;
    }

    // Returns the student at the front of the waitlist without removing them
    public Student peek() {
        if (waitlist.isEmpty()) {
            System.out.println("Waitlist for " + courseName + " is empty.");
            return null;
        }
        return waitlist.peek();
    }

    // Returns true if no students are waiting
    public boolean isEmpty() {
        return waitlist.isEmpty();
    }

    // Returns how many students are currently waiting
    public int size() {
        return waitlist.size();
    }
}
