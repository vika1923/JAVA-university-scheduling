class Schedule extends Booking implements GetItems, SetItems {
    private String course;
    private String instructor;
    private Classroom classroom;
    private String time;
    
    public Schedule(String course, String instructor, Classroom classroom, String time) {
        super(course);
        this.course = course;
        this.instructor = instructor;
        this.classroom = classroom;
        this.time = time;
    }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public Classroom getClassroom() { return classroom; }
    public void setClassroom(Classroom classroom) { this.classroom = classroom; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    @Override
    public String getName() {
        return "Shedule name is: " + course;
    }
}
