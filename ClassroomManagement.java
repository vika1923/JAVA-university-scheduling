import java.util.ArrayList;
import java.util.List;

public class ClassroomManagement {
    private List<Classroom> classrooms;

    public ClassroomManagement() {
        this.classrooms = new ArrayList<Classroom>();
    }

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
        System.out.println("Classroom added: " + classroom.getRoomNumber() + " in " + classroom.getBuilding());
    }

    public void updateClassroom(String oldRoomNumber, String newRoomNumber, String newBuilding, Integer newCapacity) {
        for (int i = 0; i < classrooms.size(); i++) {
            Classroom c = classrooms.get(i);
            if (c.getRoomNumber().equals(oldRoomNumber)) {
                if (newRoomNumber != null && !newRoomNumber.isEmpty()) c.setRoomNumber(newRoomNumber);
                if (newBuilding != null && !newBuilding.isEmpty()) c.setBuilding(newBuilding);
                if (newCapacity != null) c.setCapacity(newCapacity);
                System.out.println("Classroom updated.");
                return;
            }
        }
        System.out.println("Classroom not found.");
    }

    public void removeClassroom(String roomNumber) {
        for (int i = 0; i < classrooms.size(); i++) {
            if (classrooms.get(i).getRoomNumber().equals(roomNumber)) {
                classrooms.remove(i);
                System.out.println("Classroom removed.");
                return;
            }
        }
        System.out.println("Classroom not found.");
    }

    public List<Classroom> getAllClassrooms() {
        return classrooms;
    }

    public List<Classroom> findClassroom(String keyword) {
        List<Classroom> result = new ArrayList<Classroom>();
        for (int i = 0; i < classrooms.size(); i++) {
            Classroom c = classrooms.get(i);
            if (c.getRoomNumber().equalsIgnoreCase(keyword) ||
                c.getBuilding().equalsIgnoreCase(keyword) ||
                String.valueOf(c.getCapacity()).equals(keyword)) {
                result.add(c);
            }
        }
        return result;
    }
}
