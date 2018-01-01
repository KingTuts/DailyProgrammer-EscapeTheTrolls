import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * SpriteControllerPlayer implements SpriteController
 */
public class SpriteControllerPlayer implements SpriteController {
    private TextSprite sprite;
    private KeyPressedEmitter kpEmitter;
    private List<TextSpriteActions> actionQueue;

    public SpriteControllerPlayer(TextSprite sprite, KeyPressedEmitter kpEmitter) {
        this.sprite = sprite;
        this.kpEmitter = kpEmitter;
        this.actionQueue = new ArrayList<TextSpriteActions>();


        // Register key bindings
        this.kpEmitter.RegisterKeyBinding(keyStroke, keyString, func);

    }

    @Override
    public void TakeTurn() {
        // TODO: Add blocking key listeners here
    }

    @Override
    public TextSprite Sprite() {
        return this.sprite;
    }



    private enum TextSpriteActions {
        TURN_UP, TURN_DOWN, TURN_LEFT, TURN_RIGHT, MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT
    }
}