/*
 20 is fine 2,432,902,008,176,640,000
 21?
 22?
 100?
 1000000?
 */
public class Factorial {
    public static void main(String[] args) {
        int number = Integer.valueOf(args[0]); // Change this number to compute the factorial of a different integer
        long result = factorial(number);
        System.out.println("Factorial of " + number + " is " + result);
    }

    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
