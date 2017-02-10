package guessinggame;
import java.util.*;
public class GameConsole {
	/**
	* The play method plays a game using input from a user.
	* @param The game is guessing the number.
	* @return And the number is secret.
	*/
	public int play(GuessingGame game){
		Scanner input = new Scanner(System.in);
		System.out.println("Guessing Game\nI'm thinking of number between 1 and 20!!");
		int answer = 0 ;
		boolean isCorrect = false ;
		do{
			System.out.print("Your guess?\n");
			answer = input.nextInt();
			
			isCorrect = game.guess(answer);
			System.out.print(game.getHint());
			
		}while (isCorrect != true);

		return answer ;
	}
	
}
