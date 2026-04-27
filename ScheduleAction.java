public class ScheduleAction {

    private String type;
    private Schedule schedule;


    private String oldCourse;
    private String oldInstructor;
    private int oldClassroom;
    private String oldTime;

    public ScheduleAction(String type, Schedule schedule) {
        this.type = type;
        this.schedule = schedule;
        this.oldCourse = schedule.getCourse();
        this.oldInstructor = schedule.getInstructor();
        this.oldClassroom = schedule.getClassroom();
        this.oldTime = schedule.getTime();
    }

    public String getType() { return type; }
    public Schedule getSchedule() { return schedule; }

    public String getOldCourse() { return oldCourse; }
    public String getOldInstructor() { return oldInstructor; }
    public int getOldClassroom() { return oldClassroom; }
    public String getOldTime() { return oldTime; }

    public String describe() {
        return type + " schedule for course '" + oldCourse + "'";
    }
}
