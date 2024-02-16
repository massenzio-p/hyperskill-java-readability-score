package readability.score;

class DefaultScoreAnalyzerFactory implements ScoreAnalyzerFactory {

    private static ScoreAnalyzerFactory instance;

    private DefaultScoreAnalyzerFactory() {}

    static ScoreAnalyzerFactory getInstance() {
        if (instance == null) {
            instance = new DefaultScoreAnalyzerFactory();
        }
        return instance;
    }

    @Override
    public ScoreAnalyzer getScoreAnalyzer(ScoreAlg alg) {
        return switch (alg) {
            case CL -> new ColemanLiauAnalyzer();
            case FK -> new FleschKincaidAnalyzer();
            case ARI -> new AutomatedReadabilityAnalyzer();
            case SMOG -> new SmogAnalyzer();
            default -> new CompoundScoreAnalyzer(this);
        };
    }
}
