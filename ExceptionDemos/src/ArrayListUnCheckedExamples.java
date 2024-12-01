import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;


public class ArrayListUnCheckedExamples {
    private ArrayList<Integer> list;

    public void addValue(Integer value) {
        list.add(value);
    }

    public void removeValue(Integer value) {
        list.remove(value);
    }

    public void removeAllNumbers() {
        /* Remove an element, runtime exceptions don't require a try-catch block, but we can add one if needed. In
         *  the case we'll interrupt the normal flow of code, that is being stuck in an infinite loop */
        while(true) {
            try {
                list.removeFirst(); // API docs says it can throw NoSuchElementException
            } catch (NoSuchElementException NoMoreElements) {
                System.err.println("I ran out of numbers to remove");
                System.err.println("Message:" + NoMoreElements.getMessage());
                System.err.println("Cause:" + NoMoreElements.getCause());
                StackTraceElement[] theStack = NoMoreElements.getStackTrace();
                for(StackTraceElement stackTraceElement : theStack) {
                    System.err.println(stackTraceElement);
                }
                break;
            }
        }
    }

    public ArrayListUnCheckedExamples() {
        // configure with enough space to hold ten values and supply some values
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    public ArrayListUnCheckedExamples(int size) {
        // another runtime example can occur with negative values here
        try {
            list = new ArrayList<>(size); // API Docs say this constructor can through an IllegalArgumentException
        }
        catch (IllegalArgumentException iae) {
            System.err.println("You can't provide me a negative size for the array list");
            System.err.println("I'm going to use the default");
            size = 10;
            list = new ArrayList<>(size);
        }
        finally {
            for (int i = 0; i < size; i++) {
                if (list != null) {
                    list.add(i);
                }
            }
            System.out.println("Number of elements in list: " + (list != null ? list.size() : 0));
        }
    }

    public static void main(String[] args) {
        // Prepare our data structure
        ArrayListUnCheckedExamples example;
        if (args.length >= 1) {
           example = new ArrayListUnCheckedExamples(Integer.parseInt(args[0]));
        }
        else {
            example = new ArrayListUnCheckedExamples();
        }

        // Explore some operations with the data structure
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            example.addValue(rand.nextInt(10));
        }
        example.removeAllNumbers();
        System.out.println("Done with the normal program");

        ArrayListUnCheckedExamples example2 = null;
        example2.addValue(1); //NullPointerException, unchecked not caught in try-catch
    }
}