import java.io.IOException;

/**
 * GameMap
 */
public class GameMap {
    private String mapString;
<<<<<<< HEAD
    final private int ColummWidth = 4;
    final private String newln = "\n";
=======
    public static final char corridorChar = ' ';
    public static final char wallChar = '#';
    private char[][] map;
>>>>>>> Generate-GameMap-Array

    public GameMap(String mapFilePath) throws IOException, Exception {
        this.mapString = GetMapString(mapFilePath);
        this.map = GenerateMap(this.mapString);
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

    private static String GetMapString(String mapPath) throws IOException {
        return Helper.ReadTextFile(mapPath);
    }

<<<<<<< HEAD
    public int Rows() {
       return 0; 
    }
    
    public enum BlockType{
        WALL, CORRIDOR
    }
=======
    private static char[][] GenerateMap(String mapString) throws Exception {

        String[] rowStrings = mapString.split("\n");

        char[][] map = new char[rowStrings.length][(rowStrings[0]).length()];

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                switch (rowStrings[row].charAt(col)) {
                case wallChar:
                    map[row][col] = wallChar;
                    break;
                case corridorChar:
                    map[row][col] = wallChar;
                    break;
                default:
                    throw new Exception("Invalid map char:" + rowStrings[row].charAt(col) + "\n\tValid map chars: "
                            + wallChar + ", " + corridorChar);
                }
            }
        }

        return map;
    }

    public enum BlockType {
        WALL, CORRIDOR
    }

>>>>>>> Generate-GameMap-Array
}
