import java.util.Scanner;

public class NotRecursive {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Start countdown from: ");
        int value = Integer.parseInt(kb.nextLine());
        for(int i = value; i > 0; i--) {
            System.out.print(i + ", ");
        }
        System.out.println("0");
        System.out.println("**** Blast off! ****");
    }
}
