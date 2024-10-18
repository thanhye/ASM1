import java.util.*;

public class StudentManagementSystem {
    private Stack<Student> studentStack;
    private Queue<Student> studentQueue;
    private List<Student> studentList;

    // Constructor
    public StudentManagementSystem() {
        studentStack = new Stack<>();
        studentQueue = new LinkedList<>();
        studentList = new ArrayList<>();
    }

    // Add student
    public void addStudent(int id, String name, double point) {
        Student student = new Student(id, name, point);
        studentStack.push(student);  // Using Stack
        studentQueue.add(student);   // Using Queue
        studentList.add(student);    // Using List
    }

    // Edit student
    public void editStudent(int id, String name, double point) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                student.setName(name);
                student.setMarks(point);
                break;
            }
        }
    }

    // Delete student
    public void deleteStudent(int id) {
        studentList.removeIf(student -> student.getId() == id);
        studentQueue.removeIf(student -> student.getId() == id);
        studentStack.removeIf(student -> student.getId() == id);
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

    // Sort students by marks
    public void sortStudentsByMarks() {
        studentList.sort(Comparator.comparingDouble(Student::getMarks).reversed());
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        // Adding students
        sms.addStudent(1, "Ddạt", 7);
        sms.addStudent(2, "Lực", 8);
        sms.addStudent(3, "Yên", 5.2);

        // Display all students
        System.out.println("All students:");
        sms.displayAllStudents();

        // Sort by marks and display again
        System.out.println("\nSorted by marks:");
        sms.sortStudentsByMarks();
        sms.displayAllStudents();

        // Search for a student by ID
        System.out.println("\nSearching for student with ID 2:");
        Student found = sms.searchStudentById(2);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Student not found");
        }

        // Edit student
        System.out.println("\nEditing student with ID 3:");
        sms.editStudent(3, "Ý Yên", 10);
        sms.displayAllStudents();

        // Delete student
        System.out.println("\nDeleting student with ID 1:");
        sms.deleteStudent(1);
        sms.displayAllStudents();
    }
}