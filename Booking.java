public abstract class Booking {

    protected String date;
    protected String host;
    protected String location;
    protected int attendees;

    public Booking(String date, String host, String location, int attendees) {
        this.date = date;
        this.host = host;
        this.location = location;
        this.attendees = attendees;
    }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getAttendees() { return attendees; }
    public void setAttendees(int attendees) { this.attendees = attendees; }
}
