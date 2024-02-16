package readability.score;

import readability.grade.Grader;

import java.util.Map;

public class DefaultScorePrinter implements ScorePrinter {

    private final Grader grader;

    public DefaultScorePrinter(Grader grader) {
        this.grader = grader;
    }

    @Override
    public void printScores(Map<ScoreAlg, Double> scores) {
        for (var score : scores.entrySet()) {
            switch (score.getKey()) {
                case ARI -> printAri(score.getValue());
                case FK -> printFK(score.getValue());
                case CL -> printCl(score.getValue());
                case SMOG -> printSmog(score.getValue());
            }
        }
    }

    private void printFK(Double value) {
        System.out.printf(
                "Flesch–Kincaid readability tests: %.2f (about %d-year-olds).%n",
                value,
                grader.getGrade(value));
    }

    private void printAri(Double value) {
        System.out.printf(
                "Automated Readability Index: %.2f (about %d-year-olds).%n",
                value,
                grader.getGrade(value));
    }

    private void printSmog(Double value) {
        System.out.printf(
                "Simple Measure of Gobbledygook: %.2f (about %d-year-olds).%n",
                value,
                grader.getGrade(value));
    }

    private void printCl(Double value) {
        System.out.printf(
                "Coleman–Liau index: %.2f (about %d-year-olds).%n",
                value,
                grader.getGrade(value));
    }
}
