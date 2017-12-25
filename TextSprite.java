/**
 * TextSprite
 */
public interface TextSprite {
    public Position GetPosition();
    public Helper.Direction Direction();
    public void SetDirection(Helper.Direction direction);
    public void Advance(Helper.Direction direction);
    public char AsChar();

    public enum Actions{
        MOVE, MOVEBLOCK
    }

}