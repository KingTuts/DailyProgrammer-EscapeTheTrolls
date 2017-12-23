import java.io.IOException;

/**
 * EscapeTheTrolls
 */
public class EscapeTheTrolls {
    public String FullClassName() {
        return this.getClass().getCanonicalName();
    }

   
    public static void main(String[] args) {
        final String mapPathString = "res/maps/map.txt";
        GameMap gameMap;
        TextDisplay display = new TextDisplay();

        
        try {
            gameMap = new GameMap(mapPathString);
            display.DisplayText(gameMap.MapString());
        } catch (IOException e) {
            System.out.println("Issue with map string:\n\t" + mapPathString);
        }

        
    }

}