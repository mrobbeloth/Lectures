void main() {
    Scanner kb = new Scanner(System.in);
    IO.print("Starting number: ");
    int start = Integer.parseInt(kb.nextLine());
    showSequence(start);
    IO.println("(" + steps(start) + " steps)");
}

private static void showSequence(int n) {
    IO.print(n + " ");
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
