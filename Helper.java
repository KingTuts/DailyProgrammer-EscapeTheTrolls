import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

/**
 * Helper
 */
public final class Helper {
    private Helper() {
    }

    /**
     * Assumes the string works and everything
     * 
     * Based on http://javarevisited.blogspot.co.uk/2015/02/how-to-read-file-in-one-line-java-8.html
    */
    public static String ReadTextFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }


    public Position CalcNewPosition(Position oldPosition, Direction direction){
        int x = oldPosition.X();
        int y = oldPosition.Y();

        switch (direction) { //top-left corner is 0,0. Y increases as you go down, x increases as you go right
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
             break;
        }

        return new Position(x, y);
    }

    public enum Direction{
        UP,DOWN,LEFT,RIGHT
    }
}