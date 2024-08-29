import java.io.Serializable;

public class CourseInstructor extends Personal implements Serializable {
    private Course course;

    public CourseInstructor(String name, Course course) {
        super(name);
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public void displayDetails() {
        System.out.println("Instructor Name: " + getName());
        System.out.println("Course: " + course);
    }
}
