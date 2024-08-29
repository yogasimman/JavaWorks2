import java.io.Serializable;
import java.util.Arrays;

public class GradeBook implements Serializable {
    private Course course;
    private int[] grades;

    public GradeBook(Course course, int[] grades) {
        this.course = course;
        this.grades = grades.clone();
    }

    public Course getCourse() {
        return course;
    }

    public void processGrades(GradingStrategy strategy) {
        strategy.processGrades(grades);
    }

    public int[] getGrades() {
        return grades;
    }

    public double getAverage() {
        return Arrays.stream(grades).average().orElse(0.0);
    }
}
