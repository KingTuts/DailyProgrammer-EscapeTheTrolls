import java.io.IOException;

/**
 * EscapeTheTrolls
 */
public class EscapeTheTrolls {
    public static void GameRunner(TextDisplay display, GameMap gameMap, SpriteController[] sControllers) {
        char[][] mapWithSprites;
        while (true) {
            mapWithSprites = gameMap.Map();

            for (SpriteController sCont : sControllers) {
                sCont.TakeTurn();
                mapWithSprites = AddSpriteToMap(mapWithSprites, sCont.Sprite());
            }

            display.DisplayText(Helper.CharArr2DToString(mapWithSprites, "", "\n"));            
        }
    }
    /**
     * Will modify map
     */
    public static char[][] AddSpriteToMap(char[][] map, TextSprite sprite) {
        return Helper.OverwriteCharArray2D(map, sprite.GetPosition(), sprite.AsChar());
    }

    public static SpriteController[] generateSpriteControllers(int numTrolls) {
        SpriteController[] sControllers = new SpriteController[1];

        


        return sControllers;
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