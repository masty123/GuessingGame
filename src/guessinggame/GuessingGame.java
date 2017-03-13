package guessinggame;
import java.util.Random;
/**
* Game of guessing a secret number.-- guess the number until you correct!!
* @author Theeruth Borisuth
*/
public class GuessingGame {
	
	//variables and stuff
	int counter = 1 ;
	int upperBound;
	int secret;
	String hint = "";
	
	/**
	 * Initialize a new game
	 * @param upperbound is the max value for the secret number(>1).
	 */
	
	//this is a constructor
	public GuessingGame(int upperbound){
		this.upperBound = upperbound ;
		secret = getRandomNumber(this.upperBound);
	}
	/**
	 * Create a random number between 1 and limit
	 * @param limit is the upper limit for random number
	 * @return a random number between 1 and limit (inclusive)
	 */
	int getRandomNumber(int limit){
		long seed = System.currentTimeMillis( );
		Random rand = new Random( seed );
		return rand.nextInt(limit) + 1;
	}
	/**
	 * Tell the player if the number is lower or higher
	 * @param hint is the string that tell the player if the number is lower or higher 
	 */
	protected void setHint(int number){
			if(secret > number){
				hint = "Sorry, your guess is too small.\n";
			}
			else{
				hint = "Sorry, you're guess is too large.\n";
			}	
		}
	/**
	 * 
	 * @param check the number that the player enter whether it's correct or not 
	 * @return return the boolean	 of the answer 
	 */
	public boolean guess(int number){	
		counter++;
		if(secret == number){
			hint = "Correct. The secret is "+number+".\nYou used "+counter+" guesses.\n";
			return true;
		}
		else{
			setHint(number);
			return false;
		}
	}
	/**
	* Return a hint based on the most recent guess.
	* @return hint based on most recent guess
	*/
	public String getHint(){
		return hint;
	}
}
