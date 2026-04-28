import java.util.ArrayList;

public class StudentManagement {

    private ArrayList<Student> students = new ArrayList<Student>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void updateStudent(int id, String newName, String newMajor) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
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
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return;
            }
        }
    }

    public void listStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    public void findStudent(String keyword) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getName().equalsIgnoreCase(keyword)
                    || s.getMajor().equalsIgnoreCase(keyword)
                    || String.valueOf(s.getId()).equals(keyword)) {

                System.out.println("Found: " + s);
            }
        }
    }
}