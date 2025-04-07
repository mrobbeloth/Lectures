import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedTask implements Delayed {
    private long startTime;

    public DelayedTask(long delayInMillis) {
        this.startTime = System.currentTimeMillis() + delayInMillis;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS),
                other.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        Date date = new Date(startTime);
        return "Task scheduled for " + date;
    }
}

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        // Add tasks with varying delays
        queue.offer(new DelayedTask(5000)); // 5-second delay
        queue.offer(new DelayedTask(3000)); // 3-second delay
        queue.offer(new DelayedTask(10000)); // 10-second delay

        while (!queue.isEmpty()) {
            DelayedTask task = queue.poll(); // Retrieves only when delay expires
            if (task != null) {
                System.out.println("Processing: " + task);
            }
            Thread.sleep(500); // Simulate work
        }
    }
}