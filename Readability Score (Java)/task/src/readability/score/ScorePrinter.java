package readability.score;

import java.util.Map;

public interface ScorePrinter {

    void printScores(Map<ScoreAlg, Double> scores);
}
