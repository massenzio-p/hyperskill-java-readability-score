package readability.score;

import readability.FileStats;

import java.util.HashMap;
import java.util.Map;

public class AutomatedReadabilityAnalyzer implements ScoreAnalyzer {

    public static final double FIRST_MAGIC_CONSTANT = 4.71D;
    public static final double SECOND_MAGIC_CONSTANT = 0.5D;
    public static final double THIRD_MAGIC_CONSTANT = 21.43D;

    @Override
    public Map<ScoreAlg, Double> analyze(FileStats fileStats) {
        double chars = fileStats.getCharsCount();
        double sentences = fileStats.getSentancesCount();
        double words = fileStats.getWords().size();
        double firstTerm = FIRST_MAGIC_CONSTANT * chars / words;
        double secondTerm = SECOND_MAGIC_CONSTANT * words / sentences;

        var map = new HashMap<ScoreAlg, Double>();
        map.put(ScoreAlg.ARI, firstTerm + secondTerm - THIRD_MAGIC_CONSTANT);
        return map;
    }
}
