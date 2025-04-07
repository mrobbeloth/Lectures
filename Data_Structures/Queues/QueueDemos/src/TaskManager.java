import java.util.PriorityQueue;

public class TaskManager {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(10);

        // Add tasks to the queue, higher # is higher priority, see Task, compareTo
        taskQueue.add(new Task("Fix bugs", 2));
        taskQueue.add(new Task("Write documentation", 1));
        taskQueue.add(new Task("Implement feature X", 5));
        taskQueue.add(new Task("Code review", 3));

        // Process tasks based on priority
        while (!taskQueue.isEmpty()) {
            System.out.println("Processing: " + taskQueue.poll());
        }
    }
}