import java.io.*;
import java.util.*;

public class Main {
    private static final String STUDENT_FILE = "students.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Student> students = loadStudents();

        while (true) {
            System.out.println("1. Enroll Student");
            System.out.println("2. Enter/Display Marks");
            System.out.println("3. Process Grades");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enrollStudent(scanner, students);
                    break;
                case 2:
                    enterOrDisplayMarks(scanner, students);
                    break;
                case 3:
                    processGrades(scanner, students);
                    break;
                case 4:
                    saveStudents(students);
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void enrollStudent(Scanner scanner, Map<Integer, Student> students) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = new Student(name);
        int rollNumber = (int) (Math.random() * 1000);
        student.setRollNumber(rollNumber);
        student.setBatch((rollNumber % 2 == 0) ? "Batch 2" : "Batch 1");
        students.put(rollNumber, student);
        System.out.println("Student enrolled successfully with Roll Number: " + rollNumber);
    }

    private static void enterOrDisplayMarks(Scanner scanner, Map<Integer, Student> students) {
        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        Student student = students.get(rollNumber);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("1. Enter Marks");
        System.out.println("2. Display Marks");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter course name: ");
                String courseName = scanner.nextLine();
                System.out.print("Enter course code: ");
                String courseCode = scanner.nextLine();
                System.out.print("Enter course credits: ");
                int credits = scanner.nextInt();
                scanner.nextLine();
                
                Course course = new Course(courseName, courseCode, credits);

                System.out.print("Enter the number of grades: ");
                int numberOfGrades = scanner.nextInt();
                int[] grades = new int[numberOfGrades];

                for (int i = 0; i < numberOfGrades; i++) {
                    System.out.print("Enter grade " + (i + 1) + ": ");
                    grades[i] = scanner.nextInt();
                }

                GradeBook gradeBook = new GradeBook(course, grades);
                student.addGradeBook(gradeBook);
                System.out.println("Marks entered successfully.");
                break;
            case 2:
                List<GradeBook> gradeBooks = student.getGradeBooks();
                if (gradeBooks.isEmpty()) {
                    System.out.println("No marks entered for this student.");
                } else {
                    for (GradeBook gb : gradeBooks) {
                        System.out.println("Course: " + gb.getCourse().getCourseName());
                        System.out.println("Grades: " + Arrays.toString(gb.getGrades()));
                        System.out.printf("Average Grade: %.2f%n", gb.getAverage());
                    }
                }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void processGrades(Scanner scanner, Map<Integer, Student> students) {
        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();

        Student student = students.get(rollNumber);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        List<GradeBook> gradeBooks = student.getGradeBooks();
        if (gradeBooks.isEmpty()) {
            System.out.println("No grades to process for this student.");
            return;
        }

        System.out.println("Choose grading strategy:");
        System.out.println("1. Relative Grading");
        System.out.println("2. Absolute Grading");
        int strategyChoice = scanner.nextInt();

        GradingStrategy strategy = (strategyChoice == 1) ? new RelativeGrading() : new AbsoluteGrading();

        for (GradeBook gradeBook : gradeBooks) {
            System.out.println("Processing grades for course: " + gradeBook.getCourse().getCourseName());
            gradeBook.processGrades(strategy);
        }
    }

    @SuppressWarnings("unchecked")
    private static Map<Integer, Student> loadStudents() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(STUDENT_FILE))) {
            return (Map<Integer, Student>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    private static void saveStudents(Map<Integer, Student> students) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE))) {
            out.writeObject(students);
        } catch (IOException e) {
            System.err.println("Error saving student data: " + e.getMessage());
        }
    }
}
