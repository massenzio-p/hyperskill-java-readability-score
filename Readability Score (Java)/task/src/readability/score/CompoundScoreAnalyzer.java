package readability.score;

import readability.FileStats;

import java.util.*;

class CompoundScoreAnalyzer implements ScoreAnalyzer {

    private final ScoreAnalyzerFactory factory;

    public CompoundScoreAnalyzer(ScoreAnalyzerFactory factory) {
        this.factory = factory;
    }

    @Override
    public Map<ScoreAlg, Double> analyze(FileStats fileStats) {
        Collection<ScoreAlg> algs = new ArrayList<>(Arrays.asList(ScoreAlg.values()));
        algs.remove(ScoreAlg.ALL);
        Map<ScoreAlg, Double> map = new HashMap<>();

        for (var alg : algs) {
            ScoreAnalyzer analyzer = this.factory.getScoreAnalyzer(alg);
            map.put(alg, analyzer.analyze(fileStats).getOrDefault(alg, null));
        }

        return map;
    }
}
