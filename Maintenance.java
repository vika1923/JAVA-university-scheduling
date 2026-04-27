public class MaintenanceRequest {
    private String description;
    private boolean isUrgent;

    public MaintenanceRequest(String description, boolean isUrgent) {
        this.description = description;
        this.isUrgent = isUrgent;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUrgent() {
        return isUrgent;
    }
}
public class MaintenanceDeQueue{
    private Deque<MaintenanceRequest> maintenanceRequests;

    public MaintenanceDeQueue() {
        this.maintenanceRequests = new Deque<MaintenanceRequest>()
    }

    public void addUrgent(MaintenanceRequest maintenanceRequest) {
        maintenanceRequests.addFirst(maintenanceRequest);
    }

    public void addStandart(MaintenanceRequest maintenanceRequest) {
        maintenanceRequests.addLast(maintenanceRequest);
    }

    public MaintenanceRequest remove() {
        return maintenanceRequests.removeFirst();
    }

    public MaintenanceRequest peek() {
        return maintenanceRequests.peekFirst();
    }

    public boolean isEmpty() {
        return maintenanceRequests.isEmpty();
    }

    public int size() {
        return maintenanceRequests.size();
    }
}