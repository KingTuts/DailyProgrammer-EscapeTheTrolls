import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * GameMap
 */
public class GameMap {
    private String mapFilePath;
    private String mapString;

    public GameMap(String mapFilePath){
        this.mapFilePath = mapFilePath;
    }

    private static String GetMapString(String mapPathString) {
        return Helper.ReadTextFile(mapPathString);
    }
}
