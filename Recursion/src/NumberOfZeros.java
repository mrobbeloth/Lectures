import java.util.Scanner;

public class NumberOfZeros {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Number: ");
        long value = Long.parseLong(kb.nextLine());
        System.out.println("Number of Zeros: " + countNumberOfZeros(value));
    }

    private static int countNumberOfZeros(long value) {
        if (value == 0) {
            return 0; // base case, not a real zero in number
        }else if (value % 10 == 0) { // reduction step, case 1
            return 1 + countNumberOfZeros(value / 10);
        }
        else { // reduction step case 2
            return 0 + countNumberOfZeros(value / 10);
        }
    }
}


