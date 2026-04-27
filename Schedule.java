class Schedule extends Booking implements GetItems, SetItems {
    private String course;
    private int classroom;
    private String time;
    private String semester;
    
    public Schedule(String course, String instructor, int classroom, String time) {
        super(time, instructor, String.valueOf(classroom), 0);
        this.course = course;
        this.classroom = classroom;
        this.time = time;
        this.semester = "";
    }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getInstructor() { return host; }
    public void setInstructor(String instructor) { this.host = instructor; }

    public int getClassroom() { return classroom; }
    public void setClassroom(int classroom) {
        this.classroom = classroom;
        this.location = String.valueOf(classroom);
    }

    public String getTime() { return time; }
    public void setTime(String time) {
        this.time = time;
        this.date = time;
    }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    @Override
    public String getName() {
        return "Shedule name is: " + course;
    }
}
