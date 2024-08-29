import java.util.*;

public class RelativeGrading implements GradingStrategy {
    @Override
    public void processGrades(int[] grades) {
        double mean = Arrays.stream(grades).average().orElse(0.0);
        double stddev = Math.sqrt(Arrays.stream(grades)
                .mapToDouble(grade -> Math.pow(grade - mean, 2))
                .average().orElse(0.0));
        
        System.out.println("Relative Grading:");
        for (int grade : grades) {
            double zScore = (grade - mean) / stddev;
            String relativeGrade = convertZScoreToGrade(zScore);
            System.out.printf("Grade: %d -> Relative Grade: %s%n", grade, relativeGrade);
        }
    }

    private String convertZScoreToGrade(double zScore) {
        if (zScore >= 1.0) return "A";
        if (zScore >= 0.0) return "B";
        if (zScore >= -1.0) return "C";
        if (zScore >= -2.0) return "D";
        return "F";
    }
}
