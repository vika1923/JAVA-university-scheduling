public class Classroom {
    private String roomNumber;
    private String building;
    private int capacity;
    private boolean hasProjector;

    public Classroom(String roomNumber, String building, int capacity, boolean hasProjector) {
        this.roomNumber = roomNumber;
        this.building = building;
        this.capacity = capacity;
        this.hasProjector = hasProjector;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean hasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }
}