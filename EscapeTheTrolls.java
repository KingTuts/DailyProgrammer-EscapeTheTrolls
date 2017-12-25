import java.io.IOException;

/**
 * EscapeTheTrolls
 */
public class EscapeTheTrolls {
    public static void GameRunner(TextDisplay display, GameMap gameMap, SpriteController[] sControllers) {
        char[][] mapWithSprites;

        // gameWhileLoop:
        while (true) {
            // mapWithSprites = gameMap.Map();
            
            RunSpriteTurns(sControllers);
            try {
                mapWithSprites = UpdateMapWithSprites(gameMap.Map(), SpritesFromControllers(sControllers));   
            } catch (Exception e) {
                System.err.println(e.getMessage());
                break;
            }

            display.SetDisplay(Helper.CharArr2DToString(mapWithSprites, "", "\n"));            
        }
    }

    public static void RunSpriteTurns(SpriteController[] sControllers) {
        for (SpriteController sController : sControllers) {
            sController.TakeTurn();
        }
    }

    public static char[][] UpdateMapWithSprites(char[][] map, TextSprite[] sprites) throws Exception {
        for (TextSprite sprite : sprites) {
            map = AddSpriteToMap(map, sprite);
        }
        return map;
    }

    public static TextSprite[] SpritesFromControllers(SpriteController[] sControllers) {
        TextSprite[] tSprites = new TextSprite[sControllers.length];

        for(int i = 0; i < sControllers.length; i++){
            tSprites[i] = sControllers[i].Sprite();
        }

        return tSprites;
    }

    /**
     * Will modify map
     */
    public static char[][] AddSpriteToMap(char[][] map, TextSprite sprite) throws Exception {
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