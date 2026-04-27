public class Event extends Booking {
    private String name;

    public Event(String name, String date, String location, String organizer, int attendees) {
        super(date, organizer, location, attendees);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getOrganizer() {
        return host;
    }
}