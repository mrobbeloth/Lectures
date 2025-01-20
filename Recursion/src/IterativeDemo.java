import java.util.Scanner;

public class IterativeDemo
{
    public static void main(String[] args) {
         System.out.println("Enter an integer:");
         Scanner keyboard = new Scanner(System.in);
         int number = keyboard.nextInt( );
         System.out.println("The digits in that number are:");
         displayAsWords(number);
         System.out.println( );
    }

    // Precondition: number >= 0
    // Displays the digits in number as words.
    public static void displayAsWords(int number) {
        int divisor = getPowerOfTen(number);
        int next = number;
        while (divisor >= 10) {
            System.out.print(getWordFromDigit(next / divisor) + " ");
            next = next % divisor;
            divisor = divisor / 10;
        }
        System.out.print(getWordFromDigit(next / divisor) + " ");
    }

    // Precondition: n >= 0. 
    // Returns the greatest power of 10, which is less than or equal n.
    private static int getPowerOfTen(int n) {
        int result = 1;
        while (n >= 10) {
           result = result * 10;
           n = n / 10;
        }	
        return result;
    }

    // Precondition: 0 <= digit <= 9
    // Returns the word for the argument digit.
    private static String getWordFromDigit(int digit) {
        String result = null;
        switch (digit) {
            case 0: result = "zero";  break;
            case 1: result = "one";   break;
            case 2: result = "two";   break;
            case 3: result = "three"; break;
            case 4: result = "four";  break;
            case 5: result = "five";  break;
            case 6: result = "six";   break;
            case 7: result = "seven"; break;
            case 8: result = "eight"; break;
            case 9: result = "nine";  break;
            default:
                System.out.println("Fatal Error.");
                System.exit(0);
        }
        return result;
    }
}