import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

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
        int col = oldPosition.Col();
        int row = oldPosition.Row();

        switch (direction) { //top-left corner is 0,0. Y increases as you go down, x increases as you go right
        case UP:
            row--;
            break;
        case DOWN:
            row++;
            break;
        case LEFT:
            col--;
            break;
        case RIGHT:
            col++;
            break;
        }

        return new Position(col, row);
    }

    public static boolean PositionIn2DArray(char[][] array2D, Position position) {

        if (position.Row() < 0) {
            return false;
        }
        if (position.Row() >= array2D.length) {
            return false;
        }

        if (position.Col() < 0) {
            return false;
        }
        if (position.Col() >= array2D[0].length) {
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
        if (!(PositionIn2DArray(charArr2D, pos))) {
            throw new Exception("pos out of bounds for charArr2D");
        }

        char[][] newCharArr2D = CopyCharArr2D(charArr2D);


        newCharArr2D[pos.Row()][pos.Col()] = c;

        return newCharArr2D;
    }

    public static char[][] CopyCharArr2D(char[][] charArr2D) {
        char[][] newCharArr2D;

        newCharArr2D = StringToChar2D(CharArr2DToString(charArr2D, "", "\n"));

        return newCharArr2D;
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

    public static String FilterFromString(String s, String toFilter) {
        return StringArrayJoin(s.split(toFilter));
    }

    public static String StringArrayJoin(String[] arr){
        StringBuilder sb = new StringBuilder();
        
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public static boolean IsNull(Object o) {
        return o == null;
    }
}