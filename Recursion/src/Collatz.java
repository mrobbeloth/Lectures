import java.util.Scanner;

public class Collatz {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Starting number: ");
        int start = Integer.parseInt(kb.nextLine());
        showSequence(start);
        System.out.println("("+steps(start)+" steps)");
    }

    private static void showSequence(int n) {
        System.out.print(n + " ");
        if (n == 1) {
            return;
        }
        if (n % 2 == 0) {
            showSequence(n / 2);
        } else {
            showSequence(n * 3 + 1);
        }
    }

    /**
     * Count steps to reach 1 in Collatz sequence
     * @param n Starting number
     * @return Number of steps to reach 1
     */
    public static int steps(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + steps(n / 2);
        } else {
            return 1 + steps(n * 3 + 1);
        }
    }
}
