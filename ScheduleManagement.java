import java.util.ArrayList;
import java.util.List;


public class ScheduleManagement {
    private List<Schedule> schedules;

    public ScheduleManagement() {
        this.schedules = new ArrayList<>();
    }

    public void createSchedule(String course, String instructor, int classroom, String time) {
       Schedule newSchedule = new Schedule(course, instructor, classroom, time);
       schedules.add(newSchedule);
       System.out.println("New schedule created: " + newSchedule.getCourse() + " at " + newSchedule.getClassroom() + ", " + newSchedule.getTime());
    }

    public void updateSchedule(String course, String instructor, int classroom, String time) {
        Schedule found = findSchedule("course", course);
        if (found != null) {
            found.setCourse(course);
            found.setInstructor(instructor);
            found.setClassroom(classroom);
            found.setTime(time);
            System.out.println("Schedule updated: " + found.getCourse() + " at " + found.getClassroom() + ", " + found.getTime());
        } else {
            System.out.println("Schedule not found to update.");
        }
    }

    public void cancelSchedule(Schedule schedule) {
        if (schedules.remove(schedule)) {
            System.out.println("Schedule cancelled: " + schedule.getCourse() + " at " + schedule.getClassroom() + ", " + schedule.getTime());
        }
    }

    public Schedule[] getSchedules() {
        return schedules.toArray(new Schedule[0]);
    }

    public Schedule findSchedule(String field, String name) {
        if (field.equals("course")) {
            return schedules.stream().filter(schedule -> schedule.getCourse().equals(name)).findFirst().orElse(null);
        } else if (field.equals("instructor")) {
            return schedules.stream().filter(schedule -> schedule.getInstructor().equals(name)).findFirst().orElse(null);
        } else if (field.equals("classroom")) {
            try {
                int classRoomNo = Integer.parseInt(name);
                return schedules.stream().filter(schedule -> schedule.getClassroom() == classRoomNo).findFirst().orElse(null);
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (field.equals("time")) {
            return schedules.stream().filter(schedule -> schedule.getTime().equals(name)).findFirst().orElse(null);
        }
        return null;
    }
}
