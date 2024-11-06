import java.util.Scanner;

public class CountDownRecursive {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Start countdown from: ");
        int value = Integer.parseInt(kb.nextLine());
        countDownToLaunch(value);
    }

    private static void countDownToLaunch(int value) {
        if (value > 0) {
            System.out.print(value + ",");
            countDownToLaunch(--value); // why not value--?
        }
        else {
            System.out.println("0");
        }
    }
}
