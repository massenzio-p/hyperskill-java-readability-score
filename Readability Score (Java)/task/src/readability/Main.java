package readability;

import readability.grade.DefaultGrader;
import readability.grade.Grader;
import readability.meter.FileMeter;
import readability.meter.FileMeterImpl;
import readability.score.DefaultScorePrinter;
import readability.score.ScoreAlg;
import readability.score.ScoreAnalyzerFactory;
import readability.score.ScorePrinter;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File(args[0]);
//        File file = new File("in.txt");

        FileMeter fileMeter = new FileMeterImpl(file);
        FileStats fileStats = fileMeter.calculateStats();

        System.out.println("The text is:");
        System.out.println(String.join(" ", fileStats.getWords()));

        System.out.printf("""
                        %nWords: %d
                        Sentences: %d
                        Characters: %d
                        Syllables: %d
                        Polysyllables: %d%n""",
                fileStats.getWords().size(),
                fileStats.getSentancesCount(),
                fileStats.getCharsCount(),
                fileStats.getSyllablesCount(),
                fileStats.getPolysyllables());

        ScoreAnalyzerFactory factory = ScoreAnalyzerFactory.getInstance();
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        try (var scanner = new Scanner(System.in)) {
            String alg = scanner.nextLine();
            ScoreAlg scoreAlg = ScoreAlg.valueOf(alg.toUpperCase());


            Map<ScoreAlg, Double> scoreResult = factory.getScoreAnalyzer(scoreAlg).analyze(fileStats);
            Grader grader = new DefaultGrader();
            ScorePrinter scorePrinter = new DefaultScorePrinter(grader);
            System.out.println();
            scorePrinter.printScores(scoreResult);

            double avgAge = (double) (scoreResult.values().stream()
                    .map(grader::getGrade)
                    .reduce(Integer::sum).get()) / scoreResult.size();

            System.out.printf("%nThis text should be understood in average by %.2f-year-olds.", avgAge);
        }
    }
}
