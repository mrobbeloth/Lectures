import java.util.Scanner;

/*
Use JVM option -ea to enable assertions
 */
public class AssertionErrorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numerator (integer only please):");
        int num = sc.nextInt();
        sc.nextLine(); // clear input buffer
        System.out.print("Denominator (integer only please):");
        int den = sc.nextInt();
        sc.nextLine(); // clear input buffer
        /* Need jvm switch to turn this on, otherwise will trigger runtime error */
        assert den != 0; // divide by zero is an arithmeticexception, runtimeerror, unchecked
        System.out.println(num / den);
    }
}
