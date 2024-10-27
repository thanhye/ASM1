public class LinkedListExample {
    static class Node { // Make Node static
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public class LinkedListStack {
        private Node top;

        public LinkedListStack() {
            top = null; // Stack is initially empty
        }

        public boolean isEmpty() {
            return top == null; // Returns true if stack is empty
        }

        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top; // Point new node to the current top
            top = newNode; // Update top to the new node
        }

        public int pop() {
            if (!isEmpty()) {
                int value = top.data; // Get the top value
                top = top.next; // Move top to the next node
                return value; // Return the popped value
            } else {
                System.out.println("Stack is empty");
                return -1; // Return -1 if stack is empty
            }
        }

        public int peek() {
            if (!isEmpty()) {
                return top.data; // Return the top value without removing it
            } else {
                System.out.println("Stack is empty");
                return -1; // Return -1 if stack is empty
            }
        }
    }

    public static void main(String[] args) {
        LinkedListExample example = new LinkedListExample(); // Create an instance of LinkedListExample
        LinkedListStack stack = example.new LinkedListStack(); // Create an instance of LinkedListStack
        stack.push(10);
        stack.push(20);
        System.out.println("Top element: " + stack.peek()); // Outputs 20
        System.out.println("Popped element: " + stack.pop()); // Outputs 20
        System.out.println("Is stack empty? " + stack.isEmpty()); // Outputs false
    }
}