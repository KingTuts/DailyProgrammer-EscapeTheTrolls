import java.io.IOException;

/**
 * EscapeTheTrolls
 */
public class EscapeTheTrolls {
    public static void GameRunner(TextDisplay display, GameMap gameMap, SpriteController[] sControllers) {
        char[][] mapWithSprites;
        VictoryState state = VictoryState.NO_VICTORY;
        
        display.SetDisplay("Press one of 'WASD' to start");

        // game While Loop:
        while (state == VictoryState.NO_VICTORY) {
            RunSpriteTurns(sControllers);

            try {
                mapWithSprites = UpdateMapWithSprites(gameMap.Map(), SpritesFromControllers(sControllers));
            } catch (Exception e) {
                System.err.println(e.getMessage());
                break;
            }
            display.SetDisplay(Helper.CharArr2DToString(mapWithSprites, "", "\n"));

            state = VictoryConditionMet(sControllers);
        }

        display.SetDisplay(state.toString());
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

    /**
     * Will modify map
     */
    public static char[][] AddSpriteToMap(char[][] map, TextSprite sprite) throws Exception {
        return Helper.OverwriteCharArray2D(map, sprite.GetPosition(), sprite.AsChar());
    }

    public static TextSprite[] SpritesFromControllers(SpriteController[] sControllers) {
        TextSprite[] tSprites = new TextSprite[sControllers.length];

        for (int i = 0; i < sControllers.length; i++) {
            tSprites[i] = sControllers[i].Sprite();
        }

        return tSprites;
    }

    public static SpriteController[] generateSpriteControllers(int numTrolls, Position startPosition, GameMap gameMap,
            TextSpriteChars textSpriteChars, KeyPressedEmitter emitter) {
        SpriteController[] sControllers = new SpriteController[1]; // + numTrolls

        sControllers[0] = new SpriteControllerPlayer(new TextSpritePlayer(startPosition, gameMap, textSpriteChars),
                emitter, gameMap);

        return sControllers;
    }

    public static VictoryState VictoryConditionMet(SpriteController[] controllers) {
        for (SpriteController controller : controllers) {
            if (controller.GetVictoryState() != VictoryState.NO_VICTORY) {
                return controller.GetVictoryState();
            }
        }

        return VictoryState.NO_VICTORY;
    }

    public static void main(String[] args) {
        final int numTrolls = 0;
        final String mapPathString = "res/maps/map.txt";
        final String gameTitle = "EscapeTheTrolls";

        TextSpriteChars textSpriteChars;
        Position startPositionPlayer;
        GameMap gameMap;
        TextDisplay display;
        SpriteController[] sControllers;

        try {
            textSpriteChars = new TextSpriteChars('^', 'v', '<', '>');
            startPositionPlayer = new Position(1, 1);
            gameMap = new GameMap(mapPathString);
            display = new TextDisplay(gameTitle, gameMap.Rows(), gameMap.Columns());

            sControllers = generateSpriteControllers(numTrolls, startPositionPlayer, gameMap, textSpriteChars, display);

            GameRunner(display, gameMap, sControllers);

        } catch (IOException e) {
            System.err.println("Issue with map string: " + mapPathString);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    // public static void main(String[] args) {
    //     System.out.println("meow");
    // }

}