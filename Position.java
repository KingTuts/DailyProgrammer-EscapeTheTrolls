/**
 * Position
 */
public class Position {
    private int x;
    private int y;
    
    public Position(int col, int row){
        this.x = col;
        this.y = row;
    }

    public int Col() {
        return this.x;
    }

    public int Row() {
        return this.y;
    }


    public static boolean SamePosition(Position posA, Position posB) {
        if (posA.Col() != posB.Col()) {
            return false;
        }

        if (posA.Row() != posB.Row()) {
            return false;
        }
        
        return true;
    }
}