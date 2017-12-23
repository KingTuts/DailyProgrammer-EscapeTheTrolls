import java.io.IOException;

/**
 * GameMap
 */
public class GameMap {
    private String mapString;
    final private int ColummWidth = 4;
    final private String newln = "\n";

    public GameMap(String mapFilePath) throws IOException {
        this.mapString = GetMapString(mapFilePath);
    }
    /**
     * Returns string representation of map
     */
    public String MapString() {
        return this.mapString;
    }

    private static String GetMapString(String mapPath) throws IOException {
        return Helper.ReadTextFile(mapPath);
    }

    public int Rows() {
       return 0; 
    }
    
    public enum BlockType{
        WALL, CORRIDOR
    }
}
