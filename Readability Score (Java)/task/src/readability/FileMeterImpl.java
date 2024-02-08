package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileMeterImpl implements FileMeter {
    private final File file;

    public FileMeterImpl(File file) {
        this.file = file;
    }

    @Override
    public FileStats calculateStats() {
        try (var fileScanner = new Scanner(file).useDelimiter("\\s+")) {
            int sentences = 0;
            int chars = 0;

            List<String> words = fileScanner.tokens()
                    .collect(Collectors.toList());

            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                chars += word.length();
                if (word.matches("\\w+[.!?]") || i == words.size() - 1) {
                    sentences++;
                }
            }

            return new FileStats(words, sentences, chars);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Something went wrong");
        }
    }
}
