import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Helper
 */
public static final class Helper {
    private Helper(){}

    /**
     * Assumes the 
    */
    public static String ReadTextFile(String filePath) {
        return new String(Files.readAllBytes(new Path(filePath)));
    }
}