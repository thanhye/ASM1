public class ArrayBased {
    private int maxSize; // Maximum size of the stack
    private int[] stackArray; // Array to hold stack elements
    private int top; // Index of the top element

    // Constructor to initialize the stack
    public ArrayBased(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is initially empty
    }

    // Push operation
    public void push(int value) {
        if (top >= maxSize - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = value; // Increment top and add value
    }

    // Pop operation
    public int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -1; // Indicate error
        }
        return stackArray[top--]; // Return value and decrement top
    }

    // Peek operation
    public int peek() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return -1; // Indicate error
        }
        return stackArray[top]; // Return top value
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top < 0;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top >= maxSize - 1;
    }

    // Main method to demonstrate stack operations
    public static void main(String[] args) {
        ArrayBased stack = new ArrayBased(5); // Create a stack of size 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element: " + stack.peek()); // Should print 30

        stack.pop();
        System.out.println("Top element after pop: " + stack.peek()); // Should print 20

        stack.push(40);
        stack.push(50);
        stack.push(60); // This should trigger Stack Overflow
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }
}