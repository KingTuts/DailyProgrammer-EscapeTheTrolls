import EscapeTheTrolls.VictoryCondition;

/**
 * SpriteController
 */
public interface SpriteController {
    
    /**
     * Blocking Action. Controller will run sprite's turn
     */
    public void TakeTurn();

    public TextSprite Sprite();

    public VictoryState GetVictoryState();
}