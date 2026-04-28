import java.util.List;
import java.util.ArrayList;

public class EventManager {
    private List<Event> events;

    public EventManager() {
        this.events = new ArrayList<Event>();
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
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getName().equals(name)) {
                return events.get(i);
            }
        }
        return null;
    }

    public List<Event> getEventByDate(String date) {
        List<Event> result = new ArrayList<Event>();
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getDate().equals(date)) {
                result.add(events.get(i));
            }
        }
        return result;
    }

    public List<Event> getEventByLocation(String location) {
        List<Event> result = new ArrayList<Event>();
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getLocation().equals(location)) {
                result.add(events.get(i));
            }
        }
        return result;
    }

    public List<Event> getEventByOrganizer(String organizer) {
        List<Event> result = new ArrayList<Event>();
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getHost().equals(organizer)) {
                result.add(events.get(i));
            }
        }
        return result;
    }
}
