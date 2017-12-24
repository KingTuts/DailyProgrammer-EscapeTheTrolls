/**
 * PlayerTextSprite implements Te
 */
public class PlayerTextSprite implements TextSprite {
    private char upChar, downChar, leftChar, rightChar;
    private Helper.Direction direction;
    private Position position;

    public PlayerTextSprite(Position startPosition, char upChar, char downChar, char leftChar, char rightChar) {
        this.position = startPosition;

        this.upChar = upChar;
        this.downChar = downChar;
        this.leftChar = leftChar;
        this.rightChar = rightChar;

        this.direction = Direction.UP;
    }

    @Override
    public Position GetPosition() {
        return this.position;
    }

    @Override
    public Helper.Direction Direction() {
        return this.direction;
    }

    @Override
    public void SetDirection(Helper.Direction direction) {
        this.direction = direction;
    }

    @Override
    public void Advance() {
        
    }

    @Override
    public char AsChar() {
        return 0;
    }


}