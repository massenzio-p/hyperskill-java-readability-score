package readability;

public interface ScoreAnalyzer {

    String[] GRADE_AGES = {
        "5-6", "6-7", "7-8", "8-9", "9-10", "10-11", "11-12", "12-13",
            "13-14", "14-15", "15-16", "16-17", "17-18", "18-22"
    };

    static String getScoreGradeRelation(double score) {
        return GRADE_AGES[(int) Math.ceil(score) - 1];
    }

    double analyze(FileStats fileStats);
}
