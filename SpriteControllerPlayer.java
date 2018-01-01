/**
 * SpriteControllerPlayer implements SpriteController
 */
public class SpriteControllerPlayer implements SpriteController {
    private TextSprite sprite;
    private KeyPressedEmitter kpEmitter;

    public SpriteControllerPlayer(TextSprite sprite, KeyPressedEmitter kpEmitter){
        this.sprite = sprite;
        this.kpEmitter = kpEmitter;

        this.kpEmitter.RegisterKeyListener();
    }

    @Override
    public void TakeTurn() {
        // TODO: Add blocking key listeners here
    }   
    
    @Override
    public TextSprite Sprite() {
        return this.sprite;
    }
}