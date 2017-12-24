/**
 *  TextSpriteChars
 */
public class  TextSpriteChars {
    private char up, down, left, right;

    public  TextSpriteChars(char up, char down, char left, char right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public char Up() {
        return this.up;
    }

    public char Down() {
        return this.down;
    }

    public char Left(){
        return this.left;
    }

    public char Right(){
        return this.right;
    }

    public char Char(Helper.Direction direction){

        switch (direction) {
            case UP:
                return up;
            case DOWN:
                return down;
            case LEFT:
                return left;
            case RIGHT:
                return right;
            default:
                return up;
        }
    }

}