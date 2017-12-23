import java.io.IOException;

/**
 * GameMap
 */
public class GameMap {
    private String mapString;

    public GameMap(String mapFilePath) throws IOException {
        this.mapString = GetMapString(mapFilePath);
    }

    public String getMapString() {
        return this.mapString;
    }

    private static String GetMapString(String mapPath) throws IOException {
        return Helper.ReadTextFile(mapPath);
    }

}
