package readability;

public class BasicScoreAnalyzer implements ScoreAnalyzer {
    @Override
    public double analyze(FileStats fileStats) {
        double chars = fileStats.getCharsCount();
        double sentences = fileStats.getSentancesCount();
        double words = fileStats.getWords().size();

        return 4.71D * chars / words + 0.5D * words / sentences - 21.43D;
    }
}
