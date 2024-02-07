package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            String stringToEvaluate = scanner.nextLine();
            String[] words = stringToEvaluate.split(" ");
            int numberOfSentences = 0;

            for (int i = 0; i < words.length; i++) {
                if (words[i].matches("\\w+[.!?]") || i == words.length - 1) {
                    numberOfSentences++;
                }
            }

            if ((double) words.length / numberOfSentences > 10) {
                System.out.println("HARD");
            } else {
                System.out.println("EASY");
            }
        }
    }
}
