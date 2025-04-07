import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

class LoggerService {
    private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    // Consumer thread: writes logs to the console or file
    public void startConsumer() {
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String logMessage = queue.take(); // Block if queue is empty, forever with while(true)
                    writeToFile(logMessage);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        consumer.start();
    }

    // Producer threads: generate log messages
    public void log(String message) {
        try {
            queue.put(message); // Block if queue is full
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void writeToFile(String message) {
        // Simulate writing to a file
        System.out.println("Logged: " + message);
    }

    public static void main(String[] args) {
        LoggerService logger = new LoggerService();
        logger.startConsumer();

        // Simulate producer threads, create thread in order
        for (int i = 0; i < 100; i++) {
            final int threadId = i;
            new Thread(() -> logger.log("Log from thread " + threadId)).start();
        }
        System.out.println("Done generating threads, consumer will continue to run");
    }
}