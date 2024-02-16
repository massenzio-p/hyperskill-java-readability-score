package readability.score;

public interface ScoreAnalyzerFactory {

    ScoreAnalyzer getScoreAnalyzer(ScoreAlg alg);

    static ScoreAnalyzerFactory getInstance() {
        return DefaultScoreAnalyzerFactory.getInstance();
    }
}
