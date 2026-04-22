import java.util.Scanner;

public class Main {
    private static EventManager eventManager = new EventManager();
    private static ScheduleManagement scheduleManagement = new ScheduleManagement();
    private static StudentManagement studentManagement = new StudentManagement();
    private static InstructorManagement instructorManagement = new InstructorManagement();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- University Scheduling System ---");
            System.out.println("1. Event Management");
            System.out.println("2. Schedule Management");
            System.out.println("3. Student Management");
            System.out.println("4. Instructor Management");
            System.out.println("5. Exit");
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
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();
                    System.out.print("Enter instructor: ");
                    String instructor = scanner.nextLine();
                    System.out.print("Enter weeks (int): ");
                    int weeks = 1;
                    try {
                        weeks = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Defaulting to 1.");
                    }
                    System.out.print("Enter time: ");
                    String time = scanner.nextLine();
                    scheduleManagement.createSchedule(course, instructor, weeks, time);
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
                    System.out.print("Enter new weeks (int): ");
                    int newWeeks = 1;
                    try {
                        newWeeks = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Defaulting to 1.");
                    }
                    System.out.print("Enter new time: ");
                    String newTime = scanner.nextLine();
                    scheduleManagement.updateSchedule(updateCourse, newInst, newWeeks, newTime);
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
}
