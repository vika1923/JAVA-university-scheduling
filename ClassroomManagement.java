import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassroomManagement {
    private List<Classroom> classrooms;

    public ClassroomManagement() {
        this.classrooms = new ArrayList<>();
    }

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
        System.out.println("Classroom added: " + classroom.getRoomNumber() + " in " + classroom.getBuilding());
    }

    public void updateClassroom(String oldRoomNumber, String newRoomNumber, String newBuilding, Integer newCapacity) {
        for (Classroom c : classrooms) {
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
        classrooms.removeIf(c -> c.getRoomNumber().equals(roomNumber));
        System.out.println("Classroom removed.");
    }

    public List<Classroom> getAllClassrooms() {
        return classrooms;
    }

    public List<Classroom> findClassroom(String keyword) {
        return classrooms.stream()
                .filter(c -> c.getRoomNumber().equalsIgnoreCase(keyword) || 
                             c.getBuilding().equalsIgnoreCase(keyword) || 
                             String.valueOf(c.getCapacity()).equals(keyword))
                .collect(Collectors.toList());
    }
}
