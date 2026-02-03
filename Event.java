public class Event {
    private String name;
    private String date;
    private String location;
    private String organizer;
    private int attendees;

    public Event(String name, String date, String location, String organizer, int attendees) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.organizer = organizer;
        this.attendees = attendees;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
    
    public String getLocation() {
        return location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public int getAttendees() {
        return attendees;
    }
}