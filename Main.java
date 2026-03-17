public class Main {
  public static void main(String[] args) {
    EventManager manager = new EventManager();

    Event event1 = new Event("Java Workshop", "2025-02-10", "Room 101", "CS Dept", 30);
    Event event2 = new Event("Career Fair", "2025-02-15", "Main Hall", "Career Center", 200);

    manager.addEvent(event1);
    manager.addEvent(event2);

    System.out.println("Events count: " + manager.getEvents().size());

    Event found = manager.getEventByName("Java Workshop");
    if (found != null) {
      System.out.println("Found: " + found.getName() + " at " + found.getLocation() + ", " + found.getAttendees() + " attendees");
    }

    manager.removeEvent(event1);
    System.out.println("After remove, events count: " + manager.getEvents().size());


   StudentManagement sm = new StudentManagement();

        sm.addStudent(new Student(1, "Khondamir", "Software Engineering"));
        sm.addStudent(new Student(2, "Bahodir", "Artificial Intelligence"));

        sm.listStudents();

        sm.updateStudent(1, "Viktoriya", "Cyber Security");

        sm.findStudent("Cyber");

        sm.removeStudent(2);

        System.out.println("After remove:");
        sm.listStudents();

    // Instructor Management demo
    System.out.println("\n--- Instructor Management ---");
    InstructorManagement im = new InstructorManagement();

    im.addInstructor(new Instructor(101, "Dr. Shirin Noekhah", "Introduction to Data Structures and Algorithm Design and Analysis of Data Structure & Algorithm"));
    im.addInstructor(new Instructor(102, "Ms. Ellie Scheaffer", "English Composition"));

    System.out.println("All instructors:");
    im.listInstructors();

    im.updateInstructor(101, "Dr. Shirin Noekhah", "Introduction to Data Structures and Algorithm Design and Analysis of Data Structure & Algorithm");

    System.out.println("\nFind by name 'Scheaffer':");
    im.findInstructor("Scheaffer");
    System.out.println("\nFind by department 'English Composition':");
    im.findInstructor("English Composition");
    System.out.println("\nFind by employee ID '102':");
    im.findInstructor("102");

    im.removeInstructor(102);
    System.out.println("\nAfter remove, all instructors:");
    im.listInstructors();
  }
}
