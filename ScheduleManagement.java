import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ScheduleManagement {
    private List<Schedule> schedules;
    private Stack<ScheduleAction> actionStack;

    public ScheduleManagement() {
        this.schedules = new ArrayList<Schedule>();
        this.actionStack = new Stack<ScheduleAction>();
    }

    public void createSchedule(String course, String instructor, Classroom classroom, String time, String semester) {
       Schedule newSchedule = new Schedule(course, instructor, classroom, time, semester);
       schedules.add(newSchedule);
       actionStack.push(new ScheduleAction("CREATE", newSchedule));
       System.out.println("New schedule created: " + newSchedule.getCourse() + " at " + newSchedule.getClassroom() + ", " + newSchedule.getTime());
    }

    public void updateSchedule(String course, String instructor, Classroom classroom, String time) {
        Schedule found = findSchedule("course", course);
        if (found != null) {
            actionStack.push(new ScheduleAction("UPDATE", found));

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
            actionStack.push(new ScheduleAction("CANCEL", schedule));
            System.out.println("Schedule cancelled: " + schedule.getCourse() + " at " + schedule.getClassroom() + ", " + schedule.getTime());
        }
    }

    public Schedule[] getSchedules() {
        return schedules.toArray(new Schedule[0]);
    }

    public Schedule findSchedule(String field, String name) {
        for (int i = 0; i < schedules.size(); i++) {
            Schedule s = schedules.get(i);
            if (field.equals("course") && s.getCourse().equals(name)) {
                return s;
            } else if (field.equals("instructor") && s.getInstructor().equals(name)) {
                return s;
            } else if (field.equals("classroom") && s.getClassroom().getRoomNumber().equals(name)) {
                return s;
            } else if (field.equals("time") && s.getTime().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public void undoLastAction() {
        if (actionStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        ScheduleAction action = actionStack.pop();
        String type = action.getType();
        Schedule s = action.getSchedule();

        if (type.equals("CREATE")) {
            schedules.remove(s);
            System.out.println("Undid CREATE: removed schedule for '" + s.getCourse() + "'.");
        } else if (type.equals("UPDATE")) {
            s.setCourse(action.getOldCourse());
            s.setInstructor(action.getOldInstructor());
            s.setClassroom(action.getOldClassroom());
            s.setTime(action.getOldTime());
            System.out.println("Undid UPDATE: restored schedule for '" + s.getCourse() + "'.");
        } else if (type.equals("CANCEL")) {
            schedules.add(s);
            System.out.println("Undid CANCEL: added back schedule for '" + s.getCourse() + "'.");
        }
    }

    public ScheduleAction peekLastAction() {
        if (actionStack.isEmpty()) {
            return null;
        }
        return actionStack.peek();
    }

    public boolean isActionStackEmpty() {
        return actionStack.isEmpty();
    }

    public int undoCount() {
        return actionStack.size();
    }
}
