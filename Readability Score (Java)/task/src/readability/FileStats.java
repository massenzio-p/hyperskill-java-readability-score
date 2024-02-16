package readability;

import java.util.Collection;

public class FileStats {
    private final Collection<String> words;
    private final int sentancesCount;
    private final int charsCount;
    private final int syllables;
    private final int polysyllables;

    public FileStats(Collection<String> words,
                     int sentences,
                     int chars,
                     int syllables,
                     int polysyllables) {
        this.words = words;
        this.sentancesCount = sentences;
        this.charsCount = chars;
        this.syllables = syllables;
        this.polysyllables = polysyllables;
    }

    public Collection<String> getWords() {
        return words;
    }

    public int getSentancesCount() {
        return sentancesCount;
    }

    public int getCharsCount() {
        return charsCount;
    }

    public int getSyllablesCount() {
        return syllables;
    }

    public int getPolysyllables() {
        return polysyllables;
    }
}
