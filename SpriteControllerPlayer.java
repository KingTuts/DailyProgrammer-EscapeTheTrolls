/**
 * SpriteControllerPlayer implements SpriteController
 */
public class SpriteControllerPlayer implements SpriteController {
    private TextSprite sprite;

    public SpriteControllerPlayer(TextSprite sprite){
        this.sprite = sprite;
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