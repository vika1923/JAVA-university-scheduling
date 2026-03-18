public interface Person {

    int getId();
    String getName();

    default String getDescription() {
        return "Person: " + getId() + " | " + getName();
    }
}
