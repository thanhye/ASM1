public class StackFrames {
    public static void main(String[] args) {
        int number = 5; // Change this value to test with other numbers
        int result = StackFrames(number);
        System.out.println("StackFrames of " + number + " is: " + result);
    }

    public static int StackFrames(int n) {
        if (n == 0) {
            return 1; // Base case
        } else {
            return n * StackFrames(n - 1); // Recursive call
        }
    }
}

