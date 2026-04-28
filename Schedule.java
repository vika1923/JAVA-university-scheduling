class Schedule extends Booking implements GetItems, SetItems {
    private String course;
    private Classroom classroom;
    private String semester;
    
    public Schedule(String course, String instructor, Classroom classroom, String time) {
        super(time, instructor, classroom != null ? classroom.getRoomNumber() : "", 0);
        this.course = course;
        this.classroom = classroom;
        this.semester = "";
    }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getInstructor() { return host; }
    public void setInstructor(String instructor) {
        this.host = instructor;
    }

    public Classroom getClassroom() { return classroom; }
    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
        this.location = classroom != null ? classroom.getRoomNumber() : "";
    }

    public String getTime() { return date; }
    public void setTime(String time) {
        this.date = time;
    }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public String getName() {
        return "Shedule name is: " + course;
    }
}
