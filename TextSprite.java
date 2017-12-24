/**
 * TextSprite
 */
public interface TextSprite {
    public int XPos();
    public int YPOs();
    public Helper.Direction Direction();
    public void SetDirection(Helper.Direction direction);
    public void Advance();

    public enum Actions{
        MOVE, MOVEBLOCK
    }

}