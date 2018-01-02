import javax.swing.KeyStroke;

/**
 * KeyPressedEmitter
 */
public interface KeyPressedEmitter {
    public void RegisterKeyBinding(KeyStroke keyStroke, String keyString,  VoidFunc func);
}