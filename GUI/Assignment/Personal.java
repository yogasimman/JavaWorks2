import java.io.Serializable;

public abstract class Personal implements Serializable {
    private String name;
    private int rollNumber;

    public Personal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public abstract void displayDetails();
}
