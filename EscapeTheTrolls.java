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

    public static SpriteController[] generateSpriteControllers(int numTrolls, Position startPosition, GameMap gameMap,
            TextSpriteChars textSpriteChars) {
        SpriteController[] sControllers = new SpriteController[1]; // + numTrolls

        sControllers[0] = new SpriteControllerPlayer(new TextSpritePlayer(startPosition, gameMap, textSpriteChars));

        return sControllers;
    }

    public static void main(String[] args) {
        final int numTrolls = 0;
        final String mapPathString = "res/maps/map.txt";

        TextSpriteChars textSpriteChars;
        Position startPositionPlayer;
        GameMap gameMap;
        TextDisplay display;
        SpriteController[] sControllers;

        try {
            textSpriteChars = new TextSpriteChars('^', 'v', '<', '>');
            startPositionPlayer = new Position(1, 1);
            gameMap = new GameMap(mapPathString);
            display = new TextDisplay();

            sControllers = generateSpriteControllers(numTrolls, startPositionPlayer, gameMap, textSpriteChars);

            GameRunner(display, gameMap, sControllers);

        } catch (IOException e) {
            System.err.println("Issue with map string:\n\t" + mapPathString);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}