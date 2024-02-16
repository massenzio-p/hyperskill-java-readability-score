package readability.score;

import readability.FileStats;

import java.util.HashMap;
import java.util.Map;

public class ColemanLiauAnalyzer implements ScoreAnalyzer {

    public static final double FIRST_MAGIC_CONSTANT = 0.0588D;
    public static final double SECOND_MAGIC_CONSTANT = 0.296D;
    public static final double THIRD_MAGIC_CONSTANT = 15.8D;


    @Override
    public Map<ScoreAlg, Double> analyze(FileStats fileStats) {
        double words = fileStats.getWords().size();
        double letters = fileStats.getCharsCount();
        double sentences = fileStats.getSentancesCount();

        double L = letters / words * 100;
        double S = sentences / words * 100;

        double firstTerm = FIRST_MAGIC_CONSTANT * L;
        double secondTerm = SECOND_MAGIC_CONSTANT * S;

        var map = new HashMap<ScoreAlg, Double>();
        map.put(ScoreAlg.CL, firstTerm - secondTerm - THIRD_MAGIC_CONSTANT);
        return map;
    }
}
