public class CustomLinkedList{
    private Node head;

    private class Node {
        Event event;
        Node next;

        Node(Event event) {
            this.event = event;
            this.next = null;
        }
    }

    public void addEvent(Event event) {
        Node newNode = new Node(event);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Event findEventByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.event.getName().equals(name)) {
                return current.event;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteEvent(Event event) {
        if (head == null) {
            return;
        }

        if (head.event.equals(event)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.event.equals(event)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}