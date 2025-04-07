//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Queue;
import java.util.LinkedList;

public class FirstQueueExample {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Queue<String> queue = new LinkedList<String>();
        queue.add("Alabama");
        queue.add("Alaska");
        queue.add("Arizona");
        queue.add("Arkansas");
        queue.add("California");
        queue.add("Colorado");
        queue.add("Connecticut");
        queue.add("Delaware");
        queue.add("Florida");
        queue.add("Georgia");
        queue.add("Hawaii");
        queue.add("Idaho");
        queue.add("Illinois");
        queue.add("Indiana");
        queue.add("Iowa");
        queue.add("Kansas");
        queue.add("Kentucky");
        queue.add("Louisiana");
        queue.add("Maine");
        queue.add("Maryland");
        queue.add("Massachusetts");
        queue.add("Michigan");
        queue.add("Minnesota");
        queue.add("Mississippi");
        queue.add("Missouri");
        queue.add("Montana");
        queue.add("Nebraska");
        queue.add("Nevada");
        queue.add("New Hampshire");
        queue.add("New Jersey");
        queue.add("New Mexico");
        queue.add("New York");
        queue.add("North Carolina");
        queue.add("North Dakota");
        queue.add("Ohio");
        queue.add("Oklahoma");
        queue.add("Oregon");
        queue.add("Pennsylvania");
        queue.add("Rhode Island");
        queue.add("South Carolina");
        queue.add("South Dakota");
        queue.add("Tennessee");
        queue.add("Texas");
        queue.add("Utah");
        queue.add("Vermont");
        queue.add("Virginia");
        queue.add("Washington");
        queue.add("West Virginia");
        queue.add("Wisconsin");
        queue.add("Wyoming");

        System.out.println("Peek inside queue: " + queue.peek());

        // Remove elements containing North or South
        Queue statesWithNorthInIt = new LinkedList();
        while(!queue.isEmpty()) {
            String s = queue.poll();
            if (s.contains("North"))
                statesWithNorthInIt.add(s);
            else {
                System.out.println("Removing state " + s);
            }
        }

        // Process queue with states containing North in it
        while(!statesWithNorthInIt.isEmpty()) {
            System.out.println("It has North in it: " + statesWithNorthInIt.poll());
        }
    }

}