//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SecondQueueExample {
    public static void main(String[] args) {

        int limit = 10;
        Random rand = new Random();
        if (args.length == 1) {
            limit = Integer.parseInt(args[0]);
        }

        long start = System.nanoTime();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < limit; i++){
            queue.offer(rand.nextInt());
        }
        long end = System.nanoTime();
        long elapsedTime = end - start;

        System.out.println("Size="+String.format("%,d elements", queue.size()));
        System.out.println("Time="+String.format("%,d ns", (end-start)));

        // Convert to microseconds
        double microseconds = elapsedTime / 1_000.0;
        System.out.println("Elapsed time in microseconds: " + String.format("%,.0f us", microseconds));

        // Convert to milliseconds
        double milliseconds = elapsedTime / 1_000_000.0;
        System.out.println("Elapsed time in milliseconds: " + String.format("%,.0f ms", milliseconds));

    }

}