import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends Personal implements Serializable {
    private String batch;
    private List<GradeBook> gradeBooks = new ArrayList<>();

    public Student(String name) {
        super(name);
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBatch() {
        return batch;
    }

    public void addGradeBook(GradeBook gradeBook) {
        gradeBooks.add(gradeBook);
    }

    public List<GradeBook> getGradeBooks() {
        return gradeBooks;
    }

    @Override
    public void displayDetails() {
        System.out.println("Student Name: " + getName());
        System.out.println("Roll Number: " + getRollNumber());
        System.out.println("Batch: " + batch);
    }
}
