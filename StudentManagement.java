import java.util.ArrayList;

public class StudentManagement {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void updateStudent(int id, String newName, String newMajor) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setMajor(newMajor);
                System.out.println("Student updated");
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void removeStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    public void listStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void findStudent(String keyword) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(keyword)
                    || s.getMajor().equalsIgnoreCase(keyword)
                    || String.valueOf(s.getId()).equals(keyword)) {

                System.out.println("Found: " + s);
            }
        }
    }
}