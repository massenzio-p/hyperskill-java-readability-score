package readability.score;

import readability.FileStats;

import java.util.HashMap;
import java.util.Map;

public class SmogAnalyzer implements ScoreAnalyzer {

    public static final double FIRST_MAGIC_CONSTANT = 1.043D;
    public static final double SECOND_MAGIC_CONSTANT = 30D;
    public static final double THIRD_MAGIC_CONSTANT = 3.1291D;

    @Override
    public Map<ScoreAlg, Double> analyze(FileStats fileStats) {
        double polysyllables = fileStats.getPolysyllables();
        double sentences = fileStats.getSentancesCount();

        double secondTerm = Math.sqrt(polysyllables * SECOND_MAGIC_CONSTANT / sentences);

        var map = new HashMap<ScoreAlg, Double>();
        map.put(ScoreAlg.SMOG, FIRST_MAGIC_CONSTANT * secondTerm + THIRD_MAGIC_CONSTANT);
        return map;
    }
}
