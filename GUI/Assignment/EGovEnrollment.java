import java.io.Serializable;

public class EGovEnrollment implements EGovSystem, Serializable {

    @Override
    public void enrollStudent(Student student, Batch[] batches) {
        int rollNumber = (int) (Math.random() * 1000); // Random roll number generation
        student.setRollNumber(rollNumber);

        // Assign batch based on roll number
        if (rollNumber % 2 == 0) {
            student.setBatch(batches[1].getBatchName()); // Even roll numbers
        } else {
            student.setBatch(batches[0].getBatchName()); // Odd roll numbers
        }
    }
}
