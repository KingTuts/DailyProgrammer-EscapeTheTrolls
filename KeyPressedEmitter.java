import javax.swing.Action;
import javax.swing.KeyStroke;

/**
 * KeyPressedEmitter
 */
public interface KeyPressedEmitter {
    public void RegisterKeyBinding(KeyStroke keyStroke, String keyString, Action action);
}