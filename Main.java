public class Main {
  public static void main(String[] args) {
    // -------------------- Events (Event + EventManager) --------------------
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

    // Inheritance + overriding demo: Booking reference calling overridden getName()
    Booking bookingFromEvent = event1;
    System.out.println("Booking (Event): " + bookingFromEvent.getName());

    manager.removeEvent(event1);
    System.out.println("After remove, events count: " + manager.getEvents().size());


    // -------------------- Schedule (Schedule + ScheduleManagement) --------------------
    ScheduleManagement scheduleManagement = new ScheduleManagement();
    scheduleManagement.createSchedule("CS101", "Dr. Noekhah", 12, "Mon 10:00");
    scheduleManagement.createSchedule("ENG201", "Ms. Scheaffer", 5, "Wed 14:00");

    Schedule scheduleFound = scheduleManagement.findSchedule("course", "CS101");
    if (scheduleFound != null) {
      System.out.println("Schedule found by course: " + scheduleFound.getCourse() + " | " + scheduleFound.getInstructor());

      // Inheritance + overriding demo: Booking reference calling overridden getName()
      Booking bookingFromSchedule = scheduleFound;
      System.out.println("Booking (Schedule): " + bookingFromSchedule.getName());

      scheduleManagement.updateSchedule("CS101", "Dr. Noekhah", 14, "Mon 11:00");
      scheduleManagement.cancelSchedule(scheduleFound);
    }


    // -------------------- Students (Student + StudentManagement) --------------------
    StudentManagement sm = new StudentManagement();

    Student s1 = new Student(1, "Khondamir", "Software Engineering");
    Student s2 = new Student(2, "Bahodir", "Artificial Intelligence");

    sm.addStudent(s1);
    sm.addStudent(s2);

    System.out.println("\n--- Students ---");
    sm.listStudents();

    // Interface demo: Student used as Person
    Person pStudent = s1;
    System.out.println(pStudent.getDescription());

    sm.updateStudent(1, "Viktoriya", "Cyber Security");
    sm.findStudent("Cyber Security");

    sm.removeStudent(2);

    System.out.println("After remove:");
    sm.listStudents();

    // Instructor Management demo
    System.out.println("\n--- Instructor Management ---");
    InstructorManagement im = new InstructorManagement();

    Instructor inst1 = new Instructor(101, "Dr. Shirin Noekhah", "Data Structures & Algorithms");
    Instructor inst2 = new Instructor(102, "Ms. Ellie Scheaffer", "English Composition");

    im.addInstructor(inst1);
    im.addInstructor(inst2);

    System.out.println("All instructors:");
    im.listInstructors();

    // Interface demo: Instructor used as Person
    Person pInstructor = inst1;
    System.out.println(pInstructor.getDescription());

    // Overloading demo (compile-time polymorphism)
    im.updateInstructor(101, "Dr. Shirin Noekhah", "Advanced Data Structures");
    im.updateInstructor(101, "Dr. Shirin Noekhah"); // only name provided; department stays
    im.updateInstructor(101); // no new values provided; leaves current values

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
