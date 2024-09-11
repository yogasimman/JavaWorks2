import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBall extends JPanel implements ActionListener {
    private static final int BALL_SIZE = 30;
    private int x = 0, y = 0; // Ball's current position
    private int dx = 2, dy = 2; // Ball's velocity
    private Timer timer;

    public BouncingBall() {
        // Set up the Timer to call actionPerformed() every 10 milliseconds
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, BALL_SIZE, BALL_SIZE); // Draw the ball
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update the ball's position
        x += dx;
        y += dy;

        // Check for collision with the edges of the panel
        if (x < 0 || x + BALL_SIZE > getWidth()) {
            dx = -dx; // Reverse direction on X-axis
        }
        if (y < 0 || y + BALL_SIZE > getHeight()) {
            dy = -dy; // Reverse direction on Y-axis
        }

        // Repaint the panel to show the ball in the new position
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall ballPanel = new BouncingBall();
        frame.add(ballPanel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
