import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This program opens a window with the text centered in the middle that counts the number of times the mouse presses the screen, countes them with a reset button on the panel.
 * 
 * @author Lexi Randt, Michael Ojo
 * 
 * @version Spring 2025
 */


public class MousePressCounter {
    private int pressCount = 0; // Instance variable to track mouse presses
    private JLabel countLabel;  // Label to display the count

    public MousePressCounter() {
        // Create the main frame
        JFrame frame = new JFrame("Mouse Press Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a panel for displaying the count
        JPanel displayPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                String text = "Mouse press count: " + pressCount;
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(text)) / 2;
                int y = (getHeight() + fm.getAscent()) / 2;
                g.drawString(text, x, y);
            }
        };
        displayPanel.setBackground(Color.WHITE);

        // Add a mouse listener to update the count
        displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressCount++;
                displayPanel.repaint();
            }
        });

        // Create a reset button
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            pressCount = 0;
            displayPanel.repaint();
        });

        // Create a panel for the reset button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);

        // Add panels to frame
        frame.add(displayPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Show the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MousePressCounter::new);
    }
}
