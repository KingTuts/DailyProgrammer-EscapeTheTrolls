import java.io.IOException;

/**
 * GameMap
 */
public class GameMap {
    private String mapString;
    private Position targetPosition;

    public static final char corridorChar = ' ';
    public static final char wallChar = '#';
    public static final char newline = '\n';
    public static final char carriageReturn = '\r';
    public static final char targetChar = 'X';

    private char[][] map;

    public GameMap(String mapFilePath) throws IOException, Exception {
        this.mapString = FilterMapString(GetMapString(mapFilePath));
        this.map = GenerateMap(this.mapString);
        try {
            this.targetPosition = GetTargetPosition(this.map, targetChar);
        } catch (Exception e) {
            throw new Exception("Map doesn't have target", e.getCause());
        }
    }

    /**
     * Returns string representation of map
     */
    public String MapString() {
        return this.mapString;
    }

    public char[][] Map(){
        return this.map;
    }

    public int Rows(){
        return this.map.length;
    }

    public int Columns(){
        return this.map[0].length;
    }

    public boolean ValidSpritePosition(Position position) throws Exception{
        int col = position.X();
        int row = position.Y();
        
        if (col < 0 || col >= this.Columns()) {
            throw new Exception("Position out of map bounds. Position.x must be between 0 and " + this.Columns() +". Position.x = " + col);
        }
        if (row < 0 || row >= this.Rows()) {
            throw new Exception("Position out of map bounds. Position.y must be between 0 and " + this.Rows() +". Position.y = " + row);
        }

        if (this.map[row][col] == corridorChar) {
            return true;
        }

        if (this.map[row][col] == targetChar) {
            return true;
        }

        return false;
    }

    public Position TargetPosition() {
        return this.targetPosition;
    }


    private static String GetMapString(String mapPath) throws IOException {
        return Helper.ReadTextFile(mapPath);
    }

    private static String FilterMapString(String mapString) {
        return Helper.FilterFromString(mapString, Character.toString(carriageReturn));
    }

    private char[][] GenerateMap(String mapString) throws Exception {
        char[][] map = Helper.StringToChar2D(mapString);

        ValidateMapReturn vMapReturn = ValidateMap(map);
        if (!vMapReturn.IsValid()) {
            throw new Exception("Invalid char: " + vMapReturn.GetChar());
        }
        return map;
    }
    
    private ValidateMapReturn ValidateMap(char[][] map) {
        for (char[] row : map) {
            for (char c : row) {
                if(!IsValidMapChar(c)){
                    return new ValidateMapReturn(false, c);
                }
            }
        }

        return new ValidateMapReturn(true, ' ');
    }

    private static boolean IsValidMapChar(char mapChar){
        if (mapChar == corridorChar) {
            return true;
        }
        if(mapChar == wallChar){
            return true;
        }
        if (mapChar == targetChar) {
            return true;
        }

        return false;
    }

    /**
     * ValidateMapReturn
     */
    private class ValidateMapReturn {
        private boolean isValid;
        private char c;

        public ValidateMapReturn(boolean isValid, char c){
            this.isValid = isValid;
            this.c = c;
        }

        public boolean IsValid() {
            return this.isValid;
        }

        public char GetChar(){
            return this.c;
        }
    }

    private Position GetTargetPosition(char[][] map, char targetChar) throws Exception {

        for(int row = 0; row < map.length; row++){
            for(int col = 0; col < map[row].length; col++){
                if (map[row][col] == targetChar) {
                    return new Position(row, col);
                }
            }
        }

        throw new Exception("No targetChar found");
    }

    public enum BlockType {
        WALL, CORRIDOR, TARGET
    }

}
