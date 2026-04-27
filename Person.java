public abstract class Person {

    public abstract int getId();
    public abstract String getName();

    public String getDescription() {
        return "Person: " + getId() + " | " + getName();
    }
}
