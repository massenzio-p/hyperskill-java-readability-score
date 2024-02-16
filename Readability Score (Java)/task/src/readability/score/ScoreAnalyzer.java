package readability.score;

import readability.FileStats;

import java.util.Map;

public interface ScoreAnalyzer {

    Map<ScoreAlg, Double> analyze(FileStats fileStats);
}
