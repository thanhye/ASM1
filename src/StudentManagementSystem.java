import java.util.*;

public class StudentManagementSystem {
    private Stack<Student> studentList;  // Use Stack
    private Stack<Student> originalList;  // Store the original list

    public StudentManagementSystem() {
        studentList = new Stack<>();  // Initialize Stack
    }

    // Add student with error handling
    public void addStudent(int id, String name, double marks) {
        if (searchStudentById(id) != null) {
            System.out.println("Error: Student with ID " + id + " already exists.");
            return;
        }
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }
        if (marks < 0 || marks > 10) {
            System.out.println("Error: Marks must be between 0 and 10.");
            return;
        }
        Student student = new Student(id, name, marks);
        studentList.push(student);  // Add to Stack
        System.out.println("Added: " + student);
    }

    // Edit student details
    public void editStudent(int id, String name, double marks) {
        Student student = searchStudentById(id);
        if (student == null) {
            System.out.println("Error: Student with ID " + id + " not found.");
            return;
        }
        student.setName(name);
        student.setMarks(marks);
        System.out.println("Updated: " + student);
    }

    // Delete student
    public void deleteStudent(int id) {
        Iterator<Student> iterator = studentList.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Deleted student with ID: " + id);
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    // Search student by ID
    public Student searchStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Generate random students
    public void generateRandomStudents(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int id = i + 1;
            String name = "Student" + id;
            double marks = random.nextDouble() * 10; // Random marks between 0 and 10
            studentList.push(new Student(id, name, marks));
        }
        System.out.println("Generated " + count + " random students.");
    }
    // Bubble Sort by marks with runtime measurement and revert functionality
    public void bubbleSortStudentsByMarks() {

        Stack<Student> tempStack = new Stack<>();  // Stack tạm thời để giúp sắp xếp
        while (!studentList.isEmpty()) {
            tempStack.push(studentList.pop());
        }

        int n = tempStack.size();
        long startTime = System.nanoTime(); // Start timer

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Student current = tempStack.pop();
                Student next = tempStack.pop();
                if (current.getMarks() > next.getMarks()) {
                    tempStack.push(next);
                    tempStack.push(current);
                } else {
                    tempStack.push(current);
                    tempStack.push(next);
                }
            }
        }

        long endTime = System.nanoTime(); // End timer

        while (!tempStack.isEmpty()) {
            studentList.push(tempStack.pop());
        }
        System.out.println("Students sorted using Bubble Sort.");
        System.out.println("Bubble Sort runtime: " + (endTime - startTime) + " nanoseconds.");
    }

    // Merge Sort by marks with runtime measurement
    public void mergeSortStudentsByMarks() {
        long startTime = System.nanoTime(); // Start timer

        studentList = mergeSort(studentList);


        long endTime = System.nanoTime(); // End timer
        System.out.println("Students sorted using Merge Sort.");
        System.out.println("Merge Sort runtime: " + (endTime - startTime) + " nanoseconds.");
    }
    private Stack<Student> mergeSort(Stack<Student> stack) {
        if (stack.size() <= 1) {
            return stack;
        }
        Stack<Student> left = new Stack<>();
        Stack<Student> right = new Stack<>();
        int mid = stack.size() / 2;
        for (int i = 0; i < mid; i++) {
            left.push(stack.pop());
        }
        while (!stack.isEmpty()) {
            right.push(stack.pop());
        }
        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }
    private Stack<Student> merge(Stack<Student> left, Stack<Student> right) {
        Stack<Student> merged = new Stack<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.peek().getMarks() <= right.peek().getMarks()) {
                merged.push(left.pop());
            } else {
                merged.push(right.pop());
            }
        }
        while (!left.isEmpty()) {
            merged.push(left.pop());
        }
        while (!right.isEmpty()) {
            merged.push(right.pop());
        }
        return merged;
    }

    // Display all students with ranking
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : studentList) {
            String classification = classifyStudent(student.getMarks());
            System.out.println(student + " - Classification: " + classification);
        }
    }

    // Classification method
    private String classifyStudent(double marks) {
        if (marks < 5) {
            return "Fail";
        } else if (marks < 8) {
            return "Good";
        } else {
            return "Very Good";
        }
    }

    // Clone the current student list to revert after sorting
    private void cloneOriginalList() {
        originalList = (Stack<Student>) studentList.clone();
    }

    // Revert the student list to the original state
    private void revertToOriginalList() {
        studentList = (Stack<Student>) originalList.clone();
        System.out.println("Reverted to original student list.");
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Generate Random Students");
            System.out.println("6. Bubble Sort Students by Marks");
            System.out.println("7. Merge Sort Students by Marks");
            System.out.println("8. Display All Students");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    sms.addStudent(id, name, marks);
                    break;
                case 2:
                    System.out.print("Enter ID to Edit: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    marks = scanner.nextDouble();
                    sms.editStudent(id, name, marks);
                    break;
                case 3:
                    System.out.print("Enter ID to Delete: ");
                    id = scanner.nextInt();
                    sms.deleteStudent(id);
                    break;
                case 4:
                    System.out.print("Enter ID to Search: ");
                    id = scanner.nextInt();
                    Student student = sms.searchStudentById(id);
                    if (student != null) {
                        System.out.println("Found: " + student);
                    } else {
                        System.out.println("Student with ID " + id + " not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter number of students to generate: ");
                    int count = scanner.nextInt();
                    sms.generateRandomStudents(count);
                    break;
                case 6:
                    sms.bubbleSortStudentsByMarks();
                    break;
                case 7:
                    sms.mergeSortStudentsByMarks();
                    break;
                case 8:
                    sms.displayAllStudents();
                    break;
                case 9:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + String.format("%.1f", marks) +
                '}';
    }
}
