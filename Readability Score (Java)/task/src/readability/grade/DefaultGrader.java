package readability.grade;

public class DefaultGrader implements Grader {

    int[] GRADE_AGES = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 22, 25};

    @Override
    public int getGrade(double score) {
        return GRADE_AGES[(int) Math.ceil(score) - 1];
    }
}
