import java.util.Scanner;

public class StudentExample {
    private int studentId;
    private String name;
    private float marks;

    public StudentExample(int studentId, String name, float marks) {
        this.studentId = studentId;
        this.name = name;
        setMarks(marks);
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public float getMarks() { return marks; }

    public void setMarks(float marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }
        this.marks = marks;
    }
}

class StudentInput {
    public static Student inputStudentData() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student Marks: ");
            float marks = Float.parseFloat(scanner.nextLine());
            return new Student(studentId, name, marks);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numeric values for ID and Marks.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
        return null;
    }
}

class TestStudentInput {
    public static void main(String[] args) {
        Student student = StudentInput.inputStudentData();
        if (student != null) {
            System.out.println("Student added: " + student.getName());
        }
        testInvalidInputs();
    }

    private static void testInvalidInputs() {
        System.out.println("Testing with invalid ID:");
        simulateInvalidInput("1", "Dat", "95"); // Invalid ID
        System.out.println("Testing with invalid Marks:");
        simulateInvalidInput("1", "Dat", "150"); // Invalid Marks
    }

    private static void simulateInvalidInput(String id, String name, String marks) {
        try {
            int studentId = Integer.parseInt(id);
            float studentMarks = Float.parseFloat(marks);
            Student student = new Student(studentId, name, studentMarks);
            System.out.println("Student added: " + student.getName());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numeric values for ID and Marks.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}