import javax.swing.*;
import java.awt.*;

public class Shape {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setSize(400, 400);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a custom JPanel with overridden paintComponent method
        JPanel pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw a rectangle at (0, 0) with width 150 and height 150
                g.drawRect(0, 0, 150, 150);
            }
        };

        fr.add(pan);
        fr.setVisible(true);
    }
}
