import java.util.LinkedList;
import java.util.Queue;
public class QueueExample {
    public static void main(String[] args) {
                // Tạo một hàng đợi
                Queue<String> queue = new LinkedList<>();

                // Add element to queue
                queue.add("A");
                queue.add("B");
                queue.add("C");
                // Display the element at the head of the queue without removing it
                System.out.println("First element: " + queue.peek());

                System.out.println("Delete element: " + queue.poll());

                System.out.println("Queue after deletion: " + queue);
    }
}