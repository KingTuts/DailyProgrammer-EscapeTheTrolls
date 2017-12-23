import java.io.IOException;

/**
 * GameMap
 */
public class GameMap {
    private String mapString;

    public  GameMap(String mapPathString) {
        this.mapString = GetMapString(mapPathString);
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
}
