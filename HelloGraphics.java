import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This program opens a window with the text centered in the middle.
 * 
 * @author Lexi Randt, Michael Ojo
 * 
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {

    private  String text = "Hello, Java Graphics World!";
    private Font font = new Font("SWScrpc", Font.PLAIN, 20);

    public void setText(String text) {
        this.text = text;
        repaint();
    }

    public void setFont(Font font) {

        this.font = font;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);
        g.setFont(font);
        
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();
        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        int x = g.getFontMetrics().stringWidth(text);
        int y = g.getFontMetrics().getAscent();
        g.drawString(text, (getWidth()-x)/2, (getHeight()-y)/2);
       

        
    }

}

public class HelloGraphics implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);

        
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new HelloGraphics());
    }
}
