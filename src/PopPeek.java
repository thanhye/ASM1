import java.util.Stack;

public class PopPeek {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Popped element: " + stack.pop()); // Outputs 20

        Stack<Integer> stack1 = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Top element: " + stack.peek()); // Outputs 20
    }
}