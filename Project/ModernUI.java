import javax.swing.*;
import java.awt.*;

public class ModernUI extends JFrame {

    public ModernUI() {
        setTitle("Modern UI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with background color
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(33, 43, 54)); // Dark background
        mainPanel.setLayout(new BorderLayout());

        // Time label
        JLabel timeLabel = new JLabel("15:13", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        timeLabel.setForeground(Color.WHITE);

        // Date label
        JLabel dateLabel = new JLabel("Friday, Apr 01", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dateLabel.setForeground(Color.LIGHT_GRAY);

        JPanel timePanel = new JPanel();
        timePanel.setOpaque(false);
        timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.Y_AXIS));
        timePanel.add(timeLabel);
        timePanel.add(dateLabel);

        mainPanel.add(timePanel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 20, 20));
        buttonPanel.setOpaque(false);

        // Creating buttons with labels below
        buttonPanel.add(createButtonPanel("New Meeting", "path_to_orange_icon", Color.ORANGE));
        buttonPanel.add(createButtonPanel("Join", "path_to_blue_icon", Color.BLUE));
        buttonPanel.add(createButtonPanel("Schedule", "path_to_blue_icon", Color.BLUE));
        buttonPanel.add(createButtonPanel("Share Screen", "path_to_orange_icon", Color.ORANGE));

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private JPanel createButtonPanel(String labelText, String iconPath, Color buttonColor) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        // Creating custom button
        JButton button = new RoundedButton(buttonColor, iconPath);
        button.setPreferredSize(new Dimension(100, 100)); // Adjust size as needed

        // Creating label below the button
        JLabel label = new JLabel(labelText, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(button, BorderLayout.CENTER);
        panel.add(label, BorderLayout.SOUTH);

        return panel;
    }

    class RoundedButton extends JButton {

        private Color buttonColor;

        public RoundedButton(Color color, String iconPath) {
            super(new ImageIcon(iconPath)); // Set icon
            this.buttonColor = color;
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw the rounded button background
            g2.setColor(buttonColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ModernUI ui = new ModernUI();
            ui.setVisible(true);
        });
    }
}
