import java.util.Scanner;

public class Main {
    private static EventManager eventManager = new EventManager();
    private static ScheduleManagement scheduleManagement = new ScheduleManagement();
    private static StudentManagement studentManagement = new StudentManagement();
    private static InstructorManagement instructorManagement = new InstructorManagement();
    private static CourseWaitlist courseWaitlist = new CourseWaitlist("General");
    private static CourseManagement courseManagement = new CourseManagement();
    private static ClassroomManagement classroomManagement = new ClassroomManagement();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- University Scheduling System ---");
            System.out.println("1. Event Management");
            System.out.println("2. Schedule Management");
            System.out.println("3. Student Management");
            System.out.println("4. Instructor Management");
            System.out.println("5. Course Waitlist");
            System.out.println("6. Course Management");
            System.out.println("7. Classroom Management");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    eventMenu();
                    break;
                case "2":
                    scheduleMenu();
                    break;
                case "3":
                    studentMenu();
                    break;
                case "4":
                    instructorMenu();
                    break;
                case "5":
                    waitlistMenu();
                    break;
                case "6":
                    courseMenu();
                    break;
                case "7":
                    classroomMenu();
                    break;
                case "8":
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void eventMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Event Management ---");
            System.out.println("1. Add Event");
            System.out.println("2. List Events (Count)");
            System.out.println("3. Find Event by Name");
            System.out.println("4. Remove Event");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter date: ");
                    String date = scanner.nextLine();
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String dept = scanner.nextLine();
                    System.out.print("Enter attendees count: ");
                    int attendees = 0;
                    try {
                        attendees = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Defaulting to 0.");
                    }
                    eventManager.addEvent(new Event(name, date, location, dept, attendees));
                    System.out.println("Event added.");
                    break;
                case "2":
                    System.out.println("Events count: " + eventManager.getEvents().size());
                    break;
                case "3":
                    System.out.print("Enter event name to find: ");
                    String searchName = scanner.nextLine();
                    Event found = eventManager.getEventByName(searchName);
                    if (found != null) {
                        System.out.println("Found: " + found.getName() + " at " + found.getLocation() + ", " + found.getAttendees() + " attendees");
                    } else {
                        System.out.println("Event not found.");
                    }
                    break;
                case "4":
                    System.out.print("Enter event name to remove: ");
                    String removeName = scanner.nextLine();
                    Event toRemove = eventManager.getEventByName(removeName);
                    if (toRemove != null) {
                        eventManager.removeEvent(toRemove);
                        System.out.println("Event removed.");
                    } else {
                        System.out.println("Event not found.");
                    }
                    break;
                case "5":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void scheduleMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Schedule Management ---");
            System.out.println("1. Create Schedule");
            System.out.println("2. Find Schedule (by course)");
            System.out.println("3. Update Schedule");
            System.out.println("4. Cancel Schedule");
            System.out.println("5. Undo Last Action");
            System.out.println("6. Peek Last Action");
            System.out.println("7. Check If Undo Stack Is Empty");
            System.out.println("8. Undo Stack Size");
            System.out.println("9. Back to Main Menu");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();
                    System.out.print("Enter instructor: ");
                    String instructor = scanner.nextLine();
                    System.out.print("Enter classroom room number: ");
                    String roomNo = scanner.nextLine();
                    Classroom classroom = new Classroom(roomNo, "Unknown", 0, false);
                    System.out.print("Enter time: ");
                    String time = scanner.nextLine();
                    scheduleManagement.createSchedule(course, instructor, classroom, time);
                    System.out.println("Schedule created.");
                    break;
                case "2":
                    System.out.print("Enter course to find: ");
                    String findCourse = scanner.nextLine();
                    Schedule found = scheduleManagement.findSchedule("course", findCourse);
                    if (found != null) {
                        System.out.println("Schedule found: " + found.getCourse() + " | " + found.getInstructor());
                    } else {
                        System.out.println("Schedule not found.");
                    }
                    break;
                case "3":
                    System.out.print("Enter course to update: ");
                    String updateCourse = scanner.nextLine();
                    System.out.print("Enter new instructor: ");
                    String newInst = scanner.nextLine();
                    System.out.print("Enter new classroom room number: ");
                    String newRoomNo = scanner.nextLine();
                    Classroom newClassroom = new Classroom(newRoomNo, "Unknown", 0, false);
                    System.out.print("Enter new time: ");
                    String newTime = scanner.nextLine();
                    scheduleManagement.updateSchedule(updateCourse, newInst, newClassroom, newTime);
                    break;
                case "4":
                    System.out.print("Enter course to cancel: ");
                    String cancelCourse = scanner.nextLine();
                    Schedule toCancel = scheduleManagement.findSchedule("course", cancelCourse);
                    if (toCancel != null) {
                        scheduleManagement.cancelSchedule(toCancel);
                    } else {
                        System.out.println("Schedule not found.");
                    }
                    break;
                case "5":
                    scheduleManagement.undoLastAction();
                    break;
                case "6":
                    ScheduleAction last = scheduleManagement.peekLastAction();
                    if (last == null) {
                        System.out.println("No actions on the stack.");
                    } else {
                        System.out.println("Last action: " + last.describe());
                    }
                    break;
                case "7":
                    if (scheduleManagement.isActionStackEmpty()) {
                        System.out.println("Undo stack is empty. No undo available.");
                    } else {
                        System.out.println("Undo stack is NOT empty. Undo is available.");
                    }
                    break;
                case "8":
                    System.out.println("Undo stack size: " + scheduleManagement.undoCount());
                    break;
                case "9":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void studentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Find Student (by major)");
            System.out.println("4. Update Student");
            System.out.println("5. Remove Student");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter student ID (int): ");
                    int id = 0;
                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Defaulting to 0.");
                    }
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter major: ");
                    String major = scanner.nextLine();
                    studentManagement.addStudent(new Student(id, name, major));
                    System.out.println("Student added.");
                    break;
                case "2":
                    studentManagement.listStudents();
                    break;
                case "3":
                    System.out.print("Enter major to find: ");
                    String findMajor = scanner.nextLine();
                    studentManagement.findStudent(findMajor);
                    break;
                case "4":
                    System.out.print("Enter student ID to update (int): ");
                    int updateId = 0;
                    try {
                        updateId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Defaulting to 0.");
                    }
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new major: ");
                    String newMajor = scanner.nextLine();
                    studentManagement.updateStudent(updateId, newName, newMajor);
                    break;
                case "5":
                    System.out.print("Enter student ID to remove (int): ");
                    int removeId = 0;
                    try {
                        removeId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Defaulting to 0.");
                    }
                    studentManagement.removeStudent(removeId);
                    break;
                case "6":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void waitlistMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Course Waitlist (" + courseWaitlist.getCourseName() + ") ---");
            System.out.println("1. Set Course Name");
            System.out.println("2. Enqueue Student (Add to Waitlist)");
            System.out.println("3. Dequeue Student (Register Next in Line)");
            System.out.println("4. Peek (View Front of Waitlist)");
            System.out.println("5. Check if Waitlist is Empty");
            System.out.println("6. View Waitlist Size");
            System.out.println("7. Back to Main Menu");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    courseWaitlist = new CourseWaitlist(courseName);
                    System.out.println("Waitlist created for: " + courseName);
                    break;
                case "2":
                    System.out.print("Enter student ID (int): ");
                    int sid = 0;
                    try {
                        sid = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Defaulting to 0.");
                    }
                    System.out.print("Enter student name: ");
                    String sName = scanner.nextLine();
                    System.out.print("Enter student major: ");
                    String sMajor = scanner.nextLine();
                    courseWaitlist.enqueue(new Student(sid, sName, sMajor));
                    break;
                case "3":
                    courseWaitlist.dequeue();
                    break;
                case "4":
                    Student front = courseWaitlist.peek();
                    if (front != null) {
                        System.out.println("Front of waitlist: " + front.getDescription());
                    }
                    break;
                case "5":
                    if (courseWaitlist.isEmpty()) {
                        System.out.println("The waitlist is empty.");
                    } else {
                        System.out.println("The waitlist is NOT empty.");
                    }
                    break;
                case "6":
                    System.out.println("Students waiting: " + courseWaitlist.size());
                    break;
                case "7":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void instructorMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Instructor Management ---");
            System.out.println("1. Add Instructor");
            System.out.println("2. List Instructors");
            System.out.println("3. Find Instructor");
            System.out.println("4. Update Instructor");
            System.out.println("5. Remove Instructor");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter employee ID (int): ");
                    int id = 0;
                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Defaulting to 0.");
                    }
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String dept = scanner.nextLine();
                    instructorManagement.addInstructor(new Instructor(id, name, dept));
                    System.out.println("Instructor added.");
                    break;
                case "2":
                    instructorManagement.listInstructors();
                    break;
                case "3":
                    System.out.print("Enter search term (name/dept/id): ");
                    String term = scanner.nextLine();
                    instructorManagement.findInstructor(term);
                    break;
                case "4":
                    System.out.print("Enter employee ID to update (int): ");
                    int updateId = 0;
                    try {
                        updateId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Defaulting to 0.");
                    }
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new department: ");
                    String newDept = scanner.nextLine();
                    instructorManagement.updateInstructor(updateId, newName, newDept);
                    break;
                case "5":
                    System.out.print("Enter employee ID to remove (int): ");
                    int removeId = 0;
                    try {
                        removeId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Defaulting to 0.");
                    }
                    instructorManagement.removeInstructor(removeId);
                    break;
                case "6":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void courseMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add Course");
            System.out.println("2. List Courses");
            System.out.println("3. Find Course");
            System.out.println("4. Update Course");
            System.out.println("5. Remove Course");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter course ID (int): ");
                    int id = 0;
                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Defaulting to 0.");
                    }
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter code: ");
                    String code = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String dept = scanner.nextLine();
                    courseManagement.addCourse(new Course(id, name, code, dept));
                    break;
                case "2":
                    for (Course c : courseManagement.getAllCourses()) {
                        System.out.println("ID: " + c.getId() + " | Name: " + c.getName() + " | Code: " + c.getCode() + " | Dept: " + c.getDepartment());
                    }
                    break;
                case "3":
                    System.out.print("Enter search term (name/code/dept): ");
                    String term = scanner.nextLine();
                    for (Course c : courseManagement.findCourse(term)) {
                        System.out.println("Found: " + c.getName() + " (" + c.getCode() + ")");
                    }
                    break;
                case "4":
                    System.out.print("Enter course ID to update (int): ");
                    int updateId = 0;
                    try {
                        updateId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Defaulting to 0.");
                    }
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new code: ");
                    String newCode = scanner.nextLine();
                    System.out.print("Enter new department: ");
                    String newDept = scanner.nextLine();
                    courseManagement.updateCourse(updateId, newName, newCode, newDept);
                    break;
                case "5":
                    System.out.print("Enter course ID to remove (int): ");
                    int removeId = 0;
                    try {
                        removeId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Defaulting to 0.");
                    }
                    courseManagement.removeCourse(removeId);
                    break;
                case "6":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void classroomMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Classroom Management ---");
            System.out.println("1. Add Classroom");
            System.out.println("2. List Classrooms");
            System.out.println("3. Find Classroom");
            System.out.println("4. Update Classroom");
            System.out.println("5. Remove Classroom");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter room number: ");
                    String roomNo = scanner.nextLine();
                    System.out.print("Enter building: ");
                    String bldg = scanner.nextLine();
                    System.out.print("Enter capacity (int): ");
                    int cap = 0;
                    try {
                        cap = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid capacity. Defaulting to 0.");
                    }
                    System.out.print("Has projector (true/false): ");
                    boolean proj = Boolean.parseBoolean(scanner.nextLine());
                    classroomManagement.addClassroom(new Classroom(roomNo, bldg, cap, proj));
                    break;
                case "2":
                    for (Classroom c : classroomManagement.getAllClassrooms()) {
                        System.out.println("Room: " + c.getRoomNumber() + " | Bldg: " + c.getBuilding() + " | Cap: " + c.getCapacity() + " | Projector: " + c.hasProjector());
                    }
                    break;
                case "3":
                    System.out.print("Enter search term (room/building/capacity): ");
                    String term = scanner.nextLine();
                    for (Classroom c : classroomManagement.findClassroom(term)) {
                        System.out.println("Found: " + c.getRoomNumber() + " in " + c.getBuilding());
                    }
                    break;
                case "4":
                    System.out.print("Enter room number to update: ");
                    String updateRoom = scanner.nextLine();
                    System.out.print("Enter new room number (or empty to skip): ");
                    String newRoom = scanner.nextLine();
                    System.out.print("Enter new building (or empty to skip): ");
                    String newBldg = scanner.nextLine();
                    System.out.print("Enter new capacity (or empty to skip): ");
                    String newCapStr = scanner.nextLine();
                    Integer newCap = null;
                    if (!newCapStr.isEmpty()) {
                        try {
                            newCap = Integer.parseInt(newCapStr);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid capacity. Skipping capacity update.");
                        }
                    }
                    classroomManagement.updateClassroom(updateRoom, newRoom, newBldg, newCap);
                    break;
                case "5":
                    System.out.print("Enter room number to remove: ");
                    String removeRoom = scanner.nextLine();
                    classroomManagement.removeClassroom(removeRoom);
                    break;
                case "6":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
