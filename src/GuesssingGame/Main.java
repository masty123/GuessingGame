package GuesssingGame;
import java.util.*;

/**
 * The Main class creates objects and launches the game.
 * @author  Theeruth Borisuth
 *
 */
public class Main {
	public static void main(String []args)
	{
		GuessingGame game = new GuessingGame(20);
		GameConsole ui = new GameConsole();
		ui.play(game);
	}
}
