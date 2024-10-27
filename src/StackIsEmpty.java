public class StackIsEmpty {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackIsEmpty(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // Stack is initially empty
    }

    public boolean isEmpty() {
        return top == -1; // Returns true if stack is empty
    }

    public boolean isFull() {
        return top == maxSize - 1; // Returns true if stack is full
    }

    public void push(int value) {
        if (!isFull()) {
            stackArray[++top] = value; // Increment top and add value
        } else {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--]; // Return top value and decrement top
        } else {
            System.out.println("Stack is empty");
            return -1; // Return -1 if stack is empty
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return stackArray[top]; // Return top value without removing it
        } else {
            System.out.println("Stack is empty");
            return -1; // Return -1 if stack is empty
        }
    }

    public static void main(String[] args) {
        StackIsEmpty stack = new StackIsEmpty(5);
        stack.push(10);
        stack.push(20);
        System.out.println("Top element: " + stack.peek()); // Outputs 20
        System.out.println("Popped element: " + stack.pop()); // Outputs 20
        System.out.println("Is stack empty? " + stack.isEmpty()); // Outputs false
        stack.pop(); // Remove the last element
        System.out.println("Is stack empty? " + stack.isEmpty()); // Outputs true
    }
}