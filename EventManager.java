import java.util.List;
import java.util.ArrayList;

public class EventManager {
    private List<Event> events;

    public EventManager() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }
    
    public List<Event> getEvents() {
        return events;
    }
    
    public Event getEventByName(String name) {
        return events.stream().filter(event -> event.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Event> getEventByDate(String date) {
        return events.stream().filter(event -> event.getDate().equals(date)).collect(java.util.stream.Collectors.toList());
    }

    public List<Event> getEventByLocation(String location) {
        return events.stream().filter(event -> event.getLocation().equals(location)).collect(java.util.stream.Collectors.toList());
    }

    public List<Event> getEventByOrganizer(String organizer) {
        return events.stream().filter(event -> event.getOrganizer().equals(organizer)).collect(java.util.stream.Collectors.toList());
    }
}
