/*
 * Noah Bereketab and Eli Weitzman
 * HangMan
 * 5/30/2017
 * JDK Version 1.8.0
 */

package playHangMan;

//Imports for HangMan class
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.*;

public class HangMan extends JComponent {
    //Instatiating frame object and creating content
    JFrame frame = new JFrame("Hang Man");
    Container content = frame.getContentPane();
    public static HangMan drawing = new HangMan();

    public static void main(String[] args) {
        //Calling method PlayHangMan.code()
        PlayHangMan.intro();
        //Calling method Guessing.guess(args)
        Guessing.guess(args);

    }

    public void setUp() {
        //Setting up frame and content for the GUI
        frame.repaint();
        content.setBackground(Color.LIGHT_GRAY);
        content.add(this);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        //If the counter for incorrect guesses is >= 1 then print head
        if (PlayHangMan.counter >= 1) {
            g.setColor(Color.WHITE);
            g.fillOval(400, 100, 100, 100);//Head
            g.setColor(Color.BLACK);
            g.drawOval(400, 100, 100, 100);//Head
            repaint();
        }//If the counter for incorrect guesses is >= 2 then print neck
        if (PlayHangMan.counter >= 2) {
            g.setColor(Color.WHITE);
            g.fillRect(445, 200, 10, 100);//Neck
            g.setColor(Color.BLACK);
            g.drawRect(445, 200, 10, 100);//Neck
            repaint();
        }//If the counter for incorrect guesses is >= 3 then print body
        if (PlayHangMan.counter >= 3) {
            g.setColor(Color.WHITE);
            g.fillRect(445, 300, 10, 150);//Body
            g.setColor(Color.BLACK);
            g.drawRect(445, 300, 10, 150);
            repaint();
        }//If the counter for incorrect guesses is >= 4 then print right arm
        if (PlayHangMan.counter >= 4) {
            g.setColor(Color.BLACK);
            g.drawLine(445, 300, 300, 100);//Right arm
            repaint();
        }//If the counter for incorrect guesses is >= 5 then print left arm
        if (PlayHangMan.counter >= 5) {
            g.setColor(Color.BLACK);
            g.drawLine(455, 300, 600, 100);//Left arm
            repaint();
        }//If the counter for incorrect guesses is >= 6 then print right leg
        if (PlayHangMan.counter >= 6) {
            g.setColor(Color.BLACK);
            g.drawLine(455, 450, 500, 600);//Right leg
            repaint();
        }//If the counter for incorrect guesses is >= 7 then print left leg
        if (PlayHangMan.counter >= 7) {
            g.setColor(Color.BLACK);
            g.drawLine(445, 450, 400, 600);//Left leg
            repaint();
        }//If the counter for incorrect guesses is >= 8 then print mouth
        if (PlayHangMan.counter >= 8) {
            g.setColor(Color.BLACK);
            g.fillArc(430, 150, 40, 40, 180, 180);//Mouth
            repaint();
        }//If the counter for incorrect guesses is >= 9 then print left eye
        if (PlayHangMan.counter >= 9) {
            g.setColor(Color.BLACK);
            g.fillOval(425, 140, 15, 15);//Left eye
            repaint();
        }//If the counter for incorrect guesses is >= 10 then print right eye
        if (PlayHangMan.counter >= 10) {
            g.setColor(Color.BLACK);
            g.fillOval(460, 140, 15, 15);//Right eye
            repaint();
        }//If the counter for incorrect guesses is == 10 then user loses
        if (PlayHangMan.counter == 10) {
            g.setColor(Color.RED);
            g.setFont(new Font("Consolas", Font.BOLD, 40));
            g.drawString("You LOST!", 100, 500);

        }

    }
}
