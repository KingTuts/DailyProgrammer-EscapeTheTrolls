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

    public static Position CalcNewPosition(Position oldPosition, Direction direction) {
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

    public static boolean PositionIn2DArray(char[][] array2D, Position position) {
        int row = position.Y();
        int col = position.X();

        if (row < 0) {
            return false;
        }
        if (row >= array2D.length) {
            return false;
        }

        if (col < 0) {
            return false;
        }
        if (col >= array2D[0].length) {
            return false;
        }

        return true;
    }

    public static String JoinArr(char[] arr, String joinStr) {
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < arr.length - 1; i++) {
            b.append(arr[i] + joinStr);
        }
        b.append(arr[arr.length - 1]);

        return b.toString();
    }

    public static String JoinArr(String[] arr, String joinStr) {
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < arr.length - 1; i++) {
            b.append(arr[i] + joinStr);
        }
        b.append(arr[arr.length - 1]);

        return b.toString();
    }

    public static String CharArr2DToString(char[][] charArr2D, String colJoinStr, String rowJoinStr) {
        String[] rows = new String[charArr2D.length];

        for (int row = 0; row < rows.length; row++) {
            rows[row] = JoinArr(charArr2D[row], colJoinStr);
        }

        return JoinArr(rows, rowJoinStr);
    }

    /**
     * Will modify charArr2D
     * Assumes pos.Y() is row and pos.X() is column in 2D array.
     */

    public static char[][] OverwriteCharArray2D(char[][] charArr2D, Position pos, char c) throws Exception {
        if (PositionIn2DArray(charArr2D, pos)) {
            throw new Exception("pos out of bounds for charArr2D");
        }

        charArr2D[pos.Y()][pos.X()] = c;

        return charArr2D;
    }

    /**
     * Assumes rows are split by \n and columns are split by nothing
     */
    public static char[][] StringToChar2D(String s) {
        char[][] charArr2D;
        String[] sArr = s.split("\n");
        charArr2D = new char[sArr.length][1];

        for (int i = 0; i < sArr.length; i++) {
            charArr2D[i] = sArr[i].toCharArray();
        }

        return charArr2D;
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}