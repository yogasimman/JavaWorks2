import javax.swing.*;
import java.awt.*;

public class Main_Window extends JFrame {

    public Main_Window(String Choose) {
        setTitle("Website Backup Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel(new GridBagLayout());

        if (Choose.isEmpty()) {
            setSize(600, 400);
            mainPanel.setBackground(new Color(33, 43, 54));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0)); // Add horizontal spacing between buttons
            buttonPanel.setOpaque(false);

            // Create buttons with labels
            JPanel websiteBackupButton = createButtonPanel("Website Backup", "icons/web.png", new Color(249, 118, 58), 14);
            JPanel databaseBackupButton = createButtonPanel("Database Backup", "icons/db.png", new Color(25, 115, 232), 14);

            // Add action listener to the "Website Backup" button
            JButton websiteButton = (JButton) websiteBackupButton.getComponent(0);
            websiteButton.addActionListener(e -> {
                Main_Window next = new Main_Window("website");
                next.setVisible(true);
                dispose(); // Close the current window
            });

            JButton dbButton = (JButton) databaseBackupButton.getComponent(0);
            dbButton.addActionListener(e -> {
                Main_Window next = new Main_Window("database");
                next.setVisible(true);
                dispose();
            });

            buttonPanel.add(websiteBackupButton);
            buttonPanel.add(databaseBackupButton);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            mainPanel.add(buttonPanel, gbc);  // Add the button panel to the main panel and center it

        } else if (Choose.equals("website")) {
            setSize(600, 700);
            mainPanel.setBackground(new Color(33, 43, 54));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
            buttonPanel.setOpaque(false);

            buttonPanel.add(createButtonPanel("Backup", "icons/backup.png", new Color(25, 115, 232), 17));
            buttonPanel.add(createButtonPanel("Restore", "icons/restore.png", new Color(25, 115, 232), 17));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            mainPanel.add(buttonPanel, gbc);  // Add the button panel to the main panel and center it

            // Create the text area
            JTextArea textArea = new JTextArea("Hello world for testing", 10, 40);
            textArea.setFont(new Font("Arial", Font.PLAIN, 14));
            textArea.setForeground(Color.WHITE);
            textArea.setBackground(new Color(50, 50, 50)); // Set the gray background color
            textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding inside the text area
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setEditable(false);

            // Create the scroll pane with rounded corners
            JScrollPane scrollPane = new JScrollPane(textArea) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(getViewport().getView().getBackground());
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15); // Set the border radius
                    g2.dispose();
                }
            };
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());

            gbc.gridy = 1;
            gbc.insets = new Insets(40, 0, 0, 0); // Add spacing above the text area
            mainPanel.add(scrollPane, gbc); // Add the scroll pane below the buttons
            
            // Add Go Back Button at the bottom right
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.SOUTHEAST;
            gbc.insets = new Insets(20, 20, 20, 20); // Add padding around the button
            mainPanel.add(createGoBackButtonPanel(), gbc);

        } else if (Choose.equals("database")) {
            setSize(800, 700);
            mainPanel.setBackground(new Color(33, 43, 54));

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
            buttonPanel.setOpaque(false);

            buttonPanel.add(createButtonPanel("DB Backup", "icons/backup.png", new Color(25, 115, 232), 14));
            buttonPanel.add(createButtonPanel("DB Restore", "icons/restore.png", new Color(25, 115, 232), 14));
            buttonPanel.add(createButtonPanel("Payment Backup", "icons/payment_down.png", new Color(25, 115, 232), 14));
            buttonPanel.add(createButtonPanel("Payment Restore", "icons/payment_up.png", new Color(25, 115, 232), 14));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            mainPanel.add(buttonPanel, gbc);  // Add the button panel to the main panel and center it

            // Create the text area
            JTextArea textArea = new JTextArea("Hello world for testing", 10, 55);
            textArea.setFont(new Font("Arial", Font.PLAIN, 14));
            textArea.setForeground(Color.WHITE);
            textArea.setBackground(new Color(50, 50, 50)); // Set the gray background color
            textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding inside the text area
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setEditable(false);

            // Create the scroll pane with rounded corners
            JScrollPane scrollPane = new JScrollPane(textArea) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(getViewport().getView().getBackground());
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15); // Set the border radius
                    g2.dispose();
                }
            };
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            scrollPane.setBorder(BorderFactory.createEmptyBorder());

            gbc.gridy = 1;
            gbc.insets = new Insets(40, 0, 0, 0); // Add spacing above the text area
            mainPanel.add(scrollPane, gbc); // Add the scroll pane below the buttons
            
            // Add Go Back Button at the bottom right
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.SOUTHEAST;
            gbc.insets = new Insets(20, 20, 20, 20); // Add padding around the button
            mainPanel.add(createGoBackButtonPanel(), gbc);
        }

        add(mainPanel);
    }

    private JPanel createButtonPanel(String labelText, String iconPath, Color buttonColor, int fontSize) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JButton button = new RoundedButton(buttonColor, iconPath);
        button.setPreferredSize(new Dimension(120, 120));

        JLabel label = new JLabel(labelText, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, fontSize));

        // Add padding (spacing) around the label
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Add 10px padding to the top

        panel.add(button, BorderLayout.CENTER);
        panel.add(label, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createGoBackButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setOpaque(false);

        JButton goBackButton = new GoBackButton("icons/back.png");
        goBackButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {
                Main_Window mainWindow = new Main_Window("");
                mainWindow.setVisible(true);
                dispose(); // Close the current window
            }
        });

        panel.add(goBackButton);
        return panel;
    }

    class GoBackButton extends JButton {
        public GoBackButton(String iconPath) {
            ImageIcon originalIcon = new ImageIcon(iconPath);
            Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);  // Small button size
            setIcon(new ImageIcon(scaledImage));

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
            g2.setColor(new Color(75, 75, 75)); // Dark gray color for the Go Back button
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50); // Set the preferred size for the Go Back button
        }
    }

    class RoundedButton extends JButton {
        private final Color buttonColor;

        public RoundedButton(Color color, String iconPath) {
            // Load and scale the image
            ImageIcon originalIcon = new ImageIcon(iconPath);
            Image scaledImage = originalIcon.getImage().getScaledInstance(62, 62, Image.SCALE_SMOOTH);  // Change size as needed
            setIcon(new ImageIcon(scaledImage));

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
            return new Dimension(120, 120);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main_Window ui = new Main_Window("");
            ui.setVisible(true);
        });
    }
}
