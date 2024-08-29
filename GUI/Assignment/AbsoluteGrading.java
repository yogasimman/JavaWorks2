import java.util.*;
public class AbsoluteGrading implements GradingStrategy {
    @Override
    public void processGrades(int[] grades) {
        System.out.println("Absolute Grading:");
        for (int grade : grades) {
            String absoluteGrade = convertGradeToLetter(grade);
            System.out.printf("Grade: %d -> Absolute Grade: %s%n", grade, absoluteGrade);
        }
    }

    private String convertGradeToLetter(int grade) {
        if (grade >= 90) return "A";
        if (grade >= 80) return "B";
        if (grade >= 70) return "C";
        if (grade >= 60) return "D";
        return "F";
    }
}
