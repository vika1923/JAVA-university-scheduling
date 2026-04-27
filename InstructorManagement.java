public class InstructorManagement {

    private static final int MAX_INSTRUCTORS = 200;
    private Instructor[] instructors = new Instructor[MAX_INSTRUCTORS];
    private int instructorCount = 0;


    public void addInstructor(Instructor instructor) {
        if (instructorCount >= instructors.length) {
            System.out.println("Cannot add instructor: storage is full (" + instructors.length + ").");
            return;
        }
        instructors[instructorCount] = instructor;
        instructorCount++;
    }

   
    public void updateInstructor(int employeeId, String newName, String newDepartment) {
        for (int idx = 0; idx < instructorCount; idx++) {
            Instructor i = instructors[idx];
            if (i != null && i.getEmployeeId() == employeeId) {
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
        for (int idx = 0; idx < instructorCount; idx++) {
            Instructor i = instructors[idx];
            if (i != null && i.getEmployeeId() == employeeId) {
                for (int j = idx; j < instructorCount - 1; j++) {
                    instructors[j] = instructors[j + 1];
                }
                instructors[instructorCount - 1] = null;
                instructorCount--;
                return;
            }
        }
    }

   
    public Instructor[] getAllInstructors() {
        Instructor[] result = new Instructor[instructorCount];
        for (int idx = 0; idx < instructorCount; idx++) {
            result[idx] = instructors[idx];
        }
        return result;
    }


    public void listInstructors() {
        for (int idx = 0; idx < instructorCount; idx++) {
            System.out.println(instructors[idx]);
        }
    }

    
    public void findInstructor(String keyword) {
        for (int idx = 0; idx < instructorCount; idx++) {
            Instructor i = instructors[idx];
            if (i == null) continue;

            if (i.getName().equalsIgnoreCase(keyword)
                    || i.getDepartment().equalsIgnoreCase(keyword)
                    || String.valueOf(i.getEmployeeId()).equals(keyword)) {
                System.out.println("Found: " + i);
            }
        }
    }
}
