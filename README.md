### REQUIREMENTS

1. Events management
- The program shall allow creating events.
- The program shall allow deleting events.
- The program shall return all scheduled events.
- The program shall find an event by name, date, location, or organizer

2. Course Management
- The program shall allow adding courses.
- The program shall allow updating course information.
- The program shall allow removing courses.
- The program shall return all available courses.
- The program shall find a course by course name, course code, or department.

3. Student Management
- The program shall allow adding students.
- The program shall allow updating student information.
- The program shall allow removing students.
- The program shall return all registered students.
- The program shall find a student by name, student ID, or major.

4. Instructor Management
- The program shall allow adding instructors.
- The program shall allow updating instructor information.
- The program shall allow removing instructors.
- The program shall return all instructors.
- The program shall find an instructor by name, department, or employee ID.

5. Schedule Management
- The program shall allow creating class schedules.
- The program shall allow updating class schedules.
- The program shall allow canceling scheduled classes.
- The program shall return all class schedules.
- The program shall find a schedule by course, instructor, classroom, or time.

6. Classroom Management
- The program shall allow adding classrooms.
- The program shall allow updating classroom information.
- The program shall allow removing classrooms.
- The program shall return all classrooms.
- The program shall find a classroom by room number, building, or capacity.

7. Stack Scenario: Undo/Redo Actions in Schedule Management
- The program shall push a new scheduling action onto the stack when performed.
- The program shall pop and execute the inverse of the most recent scheduling action.
- The program shall peek to view the last action performed without undoing it.
- The program shall check if the stack is empty to determine if undo actions are available.
- The program shall return the size of the stack representing the number of recent actions that can be undone.

8. Queue Scenario: Student Waitlist for a Full Course
- The program shall enqueue a student to the waitlist when they request entry into a full course.
- The program shall dequeue and register the student at the front of the waitlist once a spot opens.
- The program shall peek at the student currently at the front of the waitlist without removing them.
- The program shall check if the waitlist is empty.
- The program shall return the size of the waitlist to show how many students are waiting.

9. DeQueue Scenario: Processing Classroom Maintenance Requests
- The program shall add an urgent maintenance request to the first position of the queue (addFirst).
- The program shall add a standard maintenance request to the last position of the queue (addLast).
- The program shall remove the first maintenance ticket to process the highest priority request (removeFirst).
- The program shall peek at the first ticket to view its details without removing it (peekFirst).
- The program shall check if there are any pending maintenance tickets (isEmpty).

10. LinkedList (Using Ready Package) Scenario: Managing a Student's Registered Courses
- The program shall add a newly registered course to the student's schedule.
- The program shall remove a specific course from the student's schedule.
- The program shall check if the student's schedule contains a specific course.
- The program shall get the first course from the student's registered schedule.
- The program shall return the size representing the total number of registered courses.

11. LinkedList (Manual Coding from Scratch) Scenario: Chronological History of Campus Events
- The program shall add an event to the end of the timeline by linking a new node.
- The program shall search for an event by traversing the linked list node by node to locate an event by name.
- The program shall delete a specific event by pointing the previous node directly to the next node.