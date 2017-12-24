/**
 * PlayerTextSprite implements Te
 */
public class TextSpritePlayer implements TextSprite {
    private char upChar, downChar, leftChar, rightChar;
    private Helper.Direction direction;
    private Position position;
    private GameMap  gameMap;

    public TextSpritePlayer(Position startPosition, GameMap gameMap, char upChar, char downChar, char leftChar, char rightChar) {
        this.position = startPosition;

        this.gameMap = gameMap;

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
    public void Advance(Helper.Direction direction) {
        final String invalidMoveMsg = "Cannot move " + this.direction.toString();

        SetDirection(direction);

        Position newPosition = Helper.CalcNewPosition(this.position, this.direction);      

        try {
            if (this.gameMap.ValidSpritePosition(newPosition)) {
                this.position = newPosition;
            }else{
                System.err.println(invalidMoveMsg);
            }
        } catch (Exception e) {
            System.err.println(invalidMoveMsg);
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public char AsChar() {
        char c;

        switch (this.direction) {
            case UP:
                c = this.upChar;
                break;
            case DOWN:
                c = this.downChar;
                break;
            case LEFT:
                c = this.leftChar;
                break;
            case RIGHT:
                c = this.rightChar;
                break;
            default:
                c = this.upChar;
        }

        return c;
    }


}