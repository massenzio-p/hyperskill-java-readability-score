package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            String stringToEvaluate = scanner.nextLine();

            if (stringToEvaluate.length() > 100) {
                System.out.print("HARD");
            } else {
                System.out.println("EASY");
            }
        }
    }
}
