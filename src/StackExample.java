import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Creat a Stack
        Stack<String> stack = new Stack<>();

        // Add element to Stack
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // Display the top element of the Stack without removing it
        System.out.println("Phần tử trên cùng: " + stack.peek());

        // Remove the top element of the Stack
        System.out.println("Xóa phần tử: " + stack.pop());

        // Display the remaining elements in the Stack
        System.out.println("Stack hiện tại: " + stack);
    }
}
