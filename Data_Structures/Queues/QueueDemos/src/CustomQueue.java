import java.util.*;

public class CustomQueue<E> extends AbstractQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean offer(E e) {
        if (e == null) {
            return false; // Null elements are not allowed in a queue
        }
        list.add(e); // Add element to the end of the queue
        return true;
    }

    @Override
    public E poll() {
        return list.isEmpty() ? null : list.removeFirst(); // Remove and return the first element
    }

    @Override
    public E peek() {
        return list.isEmpty() ? null : list.getFirst(); // Return the first element without removing it
    }

    public static void main(String[] args) {
        CustomQueue<Integer> queue = new CustomQueue<>();

        // Add elements to the queue
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Initial queue: " + queue);

        // Peek at the first element
        System.out.println("Peek: " + queue.peek());

        // Remove elements from the queue
        System.out.println("Poll: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // Iterate over the queue
        for (Integer element : queue) {
            System.out.println("Element: " + element);
        }
    }

    @Override
    public String toString() {
        return list.toString(); // For easy visualization of the queue contents
    }
}
