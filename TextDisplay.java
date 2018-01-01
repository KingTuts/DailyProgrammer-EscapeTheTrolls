import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Callable;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

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

    @Override
    public void RegisterKeyBinding(KeyStroke keyStroke, String keyString, Callable<Void> func){
        this.textArea.getInputMap().put(keyStroke, keyString);
        this.textArea.getActionMap().put(keyString, new AbstractAction(){
            public static final long serialVersionUID = 1l;

            @Override
            public void actionPerformed(ActionEvent e) {
                func.call();
            }
        });
    }

}