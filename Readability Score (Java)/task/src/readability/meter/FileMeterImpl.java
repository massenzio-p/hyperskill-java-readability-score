package readability.meter;

import readability.FileStats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
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
            int syllables = 0;
            int polysyllables = 0;

            List<String> words = fileScanner.tokens()
                    .collect(Collectors.toList());

            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                // count chars
                chars += word.length();
                // count if the sentence end
                if (word.matches("\\w+[.!?]") || i == words.size() - 1) {
                    sentences++;
                }
                // count syllables
                int currWordSyllables = (int) Pattern
                        .compile("\\b[^eyuioa\\s]+[eyuioa]\\b|[eyuioa]*e(?=\\B)[eyuioa]*|\\d+[,.]\\d*|[yuioa]+")
                        .matcher(word.toLowerCase())
                        .results()
                        .count();
                syllables += currWordSyllables;
                // count polysyllables
                if (currWordSyllables > 2) {
                    polysyllables++;
                }
            }

            return new FileStats(words, sentences, chars, syllables, polysyllables);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Something went wrong");
        }
    }
}
