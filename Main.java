import java.util.Objects;

class Student {
    private int id;
    private String name;
    private double marks;
    private String rank;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = calculateRank(marks);
    }

    // Rank Calculation
    private String calculateRank(double marks) {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    public String getRank() { return rank; }

    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) {
        this.marks = marks;
        this.rank = calculateRank(marks);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Point: " + marks + ", Rank: " + rank;
    }
}