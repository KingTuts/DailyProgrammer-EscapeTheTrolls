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


    public enum Direction{
        UP,DOWN,LEFT,RIGHT
    }
}