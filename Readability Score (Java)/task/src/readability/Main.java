package readability;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
//        File file = new File("in.txt");

        FileMeter fileMeter = new FileMeterImpl(file);
        FileStats fileStats = fileMeter.calculateStats();

        System.out.println("The text is:");
        System.out.println(String.join(" ", fileStats.getWords()));

        ScoreAnalyzer scoreAnalyzer = new BasicScoreAnalyzer();
        double score = scoreAnalyzer.analyze(fileStats);
        String scoreGradeAgeRelation = ScoreAnalyzer.getScoreGradeRelation(score);

        System.out.printf("%nWords: %d%n" +
                "Sentences: %d%n" +
                "Characters: %d%n" +
                "The score is: %.2f%n" +
                "This text should be understood by %s year-olds.%n",
                fileStats.getWords().size(),
                fileStats.getSentancesCount(),
                fileStats.getCharsCount(),
                score,
                scoreGradeAgeRelation);
    }
}
