import javax.swing.JFrame;

public class swing{

    public static void main(String[] args){
        
        JFrame frame = new JFrame();
        frame.setTitle("JFrame title goes here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this is to make the program to close with hitting x button 
        frame.setSize(500,300);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}