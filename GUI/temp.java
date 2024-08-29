create java program where 
there 
is Personal Class which contains specific details like name and roll number this is inherted by student and course instructor 

student class (contains student data)
course instructor(contains course instructor data)
Take this as college IT degree students they have (different course and course instructor for two batchs (all students have same courses)

batchs (class) there is two batchs, batch 1 and batch 2 where batch 1 for roll_no of students with odd no and batch for even

every batch as different course instructor for a course (there can be teacher which teach different course to the other batch also)

before this there should be concept of enrollment this should happen in the class called e-goverence where which student has payed fee will generate roll_no and batch will be allocated 

for every course or student there is grades are stored ,these grades are sent to the gradebook class the code will be given below the values should passes through that and give the output

then somehow store the marks of students . here i want abstract classes or interface must be used somewhere  and gradebook itself make some changes for relative and absolute grading



public class GradeBook {
    private String courseName;
    private int[] grades;

    // Constructor
    public GradeBook(String courseName, int[] grades) {
        this.courseName = courseName;
        this.grades = grades.clone(); // Avoid external modifications
    }

    // Setters and Getters
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    // Method to process grades
    public void processGrades() {
        outputGrades();
        System.out.printf("%nClass average is %.2f%n", getAverage());
        System.out.printf("Lowest grade is %d%nHighest grade is %d%n", getMinimum(), getMaximum());
        outputBarChart();
    }

    // Find minimum grade
    public int getMinimum() {
        int lowGrade = grades[0];
        for (int grade : grades) {
            if (grade < lowGrade) {
                lowGrade = grade;
            }
        }
        return lowGrade;
    }

    // Find maximum grade
    public int getMaximum() {
        int highGrade = grades[0];
        for (int grade : grades) {
            if (grade > highGrade) {
                highGrade = grade;
            }
        }
        return highGrade;
    }

    // Calculate average grade
    public double getAverage() {
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / grades.length;
    }

    // Output bar chart displaying grade distribution
    public void outputBarChart() {
        System.out.println("Grade distribution:");
        int[] frequency = new int[11];

        for (int grade : grades) {
            ++frequency[grade / 10];
        }

        for (int count = 0; count < frequency.length; count++) {
            if (count == 10) {
                System.out.printf("%5d: ", 100);
            } else {
                System.out.printf("%02d-%02d: ", count * 10, count * 10 + 9);
            }

            for (int stars = 0; stars < frequency[count]; stars++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Output the contents of the grades array
    public void outputGrades() {
        System.out.printf("The grades are:%n");
        for (int student = 0; student < grades.length; student++) {
            System.out.printf("Student %2d: %3d%n", student + 1, grades[student]);
        }
    }
}
