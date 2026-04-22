import java.util.ArrayList;

public class InstructorManagement {

    private ArrayList<Instructor> instructors = new ArrayList<>();


    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

   
    public void updateInstructor(int employeeId, String newName, String newDepartment) {
        for (Instructor i : instructors) {
            if (i.getEmployeeId() == employeeId) {
                if (newName != null && !newName.isBlank()) {
                    i.setName(newName);
                }
                if (newDepartment != null && !newDepartment.isBlank()) {
                    i.setDepartment(newDepartment);
                }

                Person p = i;
                System.out.println(p.getDescription());
                System.out.println("Instructor updated");
                return;
            }
        }
        System.out.println("Instructor not found");
    }

    public void updateInstructor(int employeeId, String newName) {
        updateInstructor(employeeId, newName, null);
    }

    public void updateInstructor(int employeeId) {
        updateInstructor(employeeId, null, null);
    }


    public void removeInstructor(int employeeId) {
        instructors.removeIf(i -> i.getEmployeeId() == employeeId);
    }

   
    public ArrayList<Instructor> getAllInstructors() {
        return instructors;
    }


    public void listInstructors() {
        for (Instructor i : instructors) {
            System.out.println(i);
        }
    }

    
    public void findInstructor(String keyword) {
        for (Instructor i : instructors) {
            if (i.getName().equalsIgnoreCase(keyword)
                    || i.getDepartment().equalsIgnoreCase(keyword)
                    || String.valueOf(i.getEmployeeId()).equals(keyword)) {
                System.out.println("Found: " + i);
            }
        }
    }
}
