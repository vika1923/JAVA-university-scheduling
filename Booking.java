public abstract class Booking {

    protected String name;

    public Booking(String name) {
        this.name = name;
    }

    public String getName() {
        return "Booking name is: " + name;
    }
}
