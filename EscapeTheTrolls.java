import java.io.IOException;

/**
 * EscapeTheTrolls
 */
public class EscapeTheTrolls {

    public static void main(String[] args) {
        final String mapPathString = "res/maps/map.txt";
        GameMap gameMap;
        
        try {
            gameMap = new GameMap(mapPathString);
            System.out.println(gameMap.getMapString());
        } catch (IOException e) {
            System.out.println("Issue with map string:\n\t" + mapPathString);
        }

        
    }

}