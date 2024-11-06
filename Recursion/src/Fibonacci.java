import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Fibonacci number needed: ");
        int fibNum = Integer.parseInt(kb.nextLine());
        showAllTheNumbers(fibNum);
    }

    private static void showAllTheNumbers(int fibNum) {
        if (fibNum > 0) {
            showAllTheNumbers(fibNum-1);
        }
        System.out.print(fib(fibNum) + " ");
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n > 1) {
            return fib(n - 1) + fib (n - 2);
        }
        return 0;
    }
}
