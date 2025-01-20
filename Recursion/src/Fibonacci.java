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

    /**
     * Find the nth Fibonnaci number
     * @param n Fibonnaci number to find
     * @return nth Fibonnaci number
     */
    public static int fib(int n) {
        if (n == 0) {
            // first base case, no recursion
            return 0;
        }
        else if (n == 1) {
            // second base case, no recursion
            return 1;
        }
        else if (n > 1) {
            /* make the problem smaller, note we have two recursive calls
               left side first by precedence then right side, then sum
               result of two recursive calls.
               Each fib number is the sum of the previous two, but to
               get the sum we need to subtract one and then two
               0 1 1 2 3 5 8 ... n >= 2 here */
            return fib(n - 1) + fib (n - 2);
        }
        return 0;
    }
}
