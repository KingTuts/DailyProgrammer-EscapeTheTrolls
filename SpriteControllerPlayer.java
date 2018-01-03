import javax.swing.KeyStroke;

import SpriteController.VictoryState;

/**
 * SpriteControllerPlayer implements SpriteController
 */
public class SpriteControllerPlayer implements SpriteController {
    private TextSprite sprite;
    private KeyPressedEmitter kpEmitter;
    private Helper.Direction direction;
    private static final long sleepTimeMillis = 50;

    public SpriteControllerPlayer(TextSprite sprite, KeyPressedEmitter kpEmitter) {
        this.sprite = sprite;
        this.kpEmitter = kpEmitter;
        this.direction = null;

        // Register key bindings
        this.kpEmitter.RegisterKeyBinding(KeyStroke.getKeyStroke("released W"), "upKey",
                () -> this.direction = Helper.Direction.UP);
        this.kpEmitter.RegisterKeyBinding(KeyStroke.getKeyStroke("released S"), "downKey",
                () -> this.direction = Helper.Direction.DOWN);
        this.kpEmitter.RegisterKeyBinding(KeyStroke.getKeyStroke("released A"), "leftKey",
                () -> this.direction = Helper.Direction.LEFT);
        this.kpEmitter.RegisterKeyBinding(KeyStroke.getKeyStroke("released D"), "rightKey",
                () -> this.direction = Helper.Direction.RIGHT);

    }

    @Override
    public void TakeTurn() {
        boolean keyPressed = false;

        while (!keyPressed) {
            keyPressed = !(Helper.IsNull(direction));
            if (keyPressed) {
                ExecuteTurn();
                this.direction = null;
            } else {
                try {
                    Thread.sleep(sleepTimeMillis);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                    System.err.println(e.getStackTrace().toString());
                }
            }

        }
    }

    private void ExecuteTurn() {
        if (this.direction == this.sprite.Direction()) {
            this.sprite.Advance(this.direction);
        } else {
            this.sprite.SetDirection(this.direction);
        }
    }

    @Override
    public TextSprite Sprite() {
        return this.sprite;
    }

    public VictoryState GetVictoryState() {
        return VictoryState.NO_VICTORY;
    }
}