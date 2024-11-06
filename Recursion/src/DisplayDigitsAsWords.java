/* Java Listing 11.2: Recursive method for displayAsWords
 * The method receives a non-negative integer as a parameter,
 * and prints its sequence of digits spelled out as words.
 * TO DO: complete the method for displayAsWords
 */

import java.util.Scanner;

public class DisplayDigitsAsWords {
    public static void main(String[] args) {
         System.out.print("Enter an integer:");
         Scanner keyboard = new Scanner(System.in);
         int number = keyboard.nextInt( );
         System.out.println("The digits in that number are:");
         displayAsWords(number);
         System.out.println( );
    }

    // Precondition: number >= 0
    // Displays the sequence of digits in number as words.
    public static void displayAsWords(int number) {
        if (number < 10) {
            String digitStr = getWordFromDigit(number);
            System.out.print(digitStr + " ");
        }
        else {
        
            displayAsWords(number / 10);
            System.out.print(getWordFromDigit(number % 10) + " ");
        }
    }
	
    // Precondition: 0 <= digit <= 9
    // Returns the word for the argument digit.
    private static String getWordFromDigit(int digit) {
        String result = null;
        switch (digit) { // newer Java releases case 0 -> result = "zero"
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
                System.out.println("Fatal Error: invalid digit.");
                System.exit(0);
        }
        return result;
    }
}