import java.io.Serializable;

public class Batch implements Serializable {
    private String batchName;
    private CourseInstructor[] instructors;

    public Batch(String batchName, CourseInstructor[] instructors) {
        this.batchName = batchName;
        this.instructors = instructors;
    }

    public String getBatchName() {
        return batchName;
    }

    public CourseInstructor[] getInstructors() {
        return instructors;
    }
}
