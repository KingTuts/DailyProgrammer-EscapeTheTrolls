import java.io.IOException;
import java.nio.file.Files;
// import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Helper
 */
public final class Helper {
    private Helper() {
    }

    /**
     * Assumes the string works and everything
    */
    public static String ReadTextFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));        
    }
}