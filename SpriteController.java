/**
 * SpriteController
 */
public interface SpriteController {
    
    /**
     * Blocking Action. Controller will take Sprite's turn
     */
    public void TakeTurn();

    public TextSprite Sprite();
}