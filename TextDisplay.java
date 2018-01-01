import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * TextDisplay
 */
public class TextDisplay implements KeyPressedEmitter {
    private JTextArea textArea;
    private JFrame jFrame;


    public TextDisplay(String title, int rows, int cols) {
        jFrame = new JFrame(title);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setFocusable(true);


        textArea = new JTextArea(rows, cols);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        textArea.setLineWrap(false);
        textArea.setEditable(false);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);

        jFrame.add(textArea);
        jFrame.pack();

        jFrame.setVisible(true);
    }

    public void SetDisplay(String textToDisplay) {
        // System.out.println(textToDisplay);
        this.textArea.setText(textToDisplay);
    }


    public void RegisterKeyListener(KeyListener kl){
        jFrame.addKeyListener(kl);
    }


}