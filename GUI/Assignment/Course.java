import java.io.Serializable;

public class Course implements Serializable {
    private String courseName;
    private String courseCode;
    private int credits;

    public Course(String courseName, String courseCode, int credits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return courseName + " (" + courseCode + ") - " + credits + " Credits";
    }
}
