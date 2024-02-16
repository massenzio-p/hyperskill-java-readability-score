package readability.score;

import readability.FileStats;

import java.util.HashMap;
import java.util.Map;

class FleschKincaidAnalyzer implements ScoreAnalyzer {

    public static final double FIRST_MAGIC_CONSTANT = 0.39D;
    public static final double SECOND_MAGIC_CONSTANT = 11.8;
    public static final double THIRD_MAGIC_CONSTANT = 15.59;


    @Override
    public Map<ScoreAlg, Double> analyze(FileStats fileStats) {
        double words = fileStats.getWords().size();
        double sentences = fileStats.getSentancesCount();
        double syllables = fileStats.getSyllablesCount();

        double firstTerm = FIRST_MAGIC_CONSTANT * words / sentences;
        double secondTerm = SECOND_MAGIC_CONSTANT * syllables / words;

        var map = new HashMap<ScoreAlg, Double>();
        map.put(ScoreAlg.FK, firstTerm + secondTerm - THIRD_MAGIC_CONSTANT);
        return map;
    }
}
