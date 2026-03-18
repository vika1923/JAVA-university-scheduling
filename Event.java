public class Event extends Booking {
    private String date;
    private String location;
    private String organizer;
    private int attendees;

    public Event(String name, String date, String location, String organizer, int attendees) {
        super(name);
        this.date = date;
        this.location = location;
        this.organizer = organizer;
        this.attendees = attendees;
    }

    @Override
    public String getName() {
        return "Booking name is: " + name;
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