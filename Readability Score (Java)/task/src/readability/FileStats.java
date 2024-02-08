package readability;

import java.util.Collection;

public class FileStats {
    private final Collection<String> words;
    private final int sentancesCount;
    private final int charsCount;

    public FileStats(Collection<String> words, int sentences, int chars) {
        this.words = words;
        this.sentancesCount = sentences;
        this.charsCount = chars;
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
}
