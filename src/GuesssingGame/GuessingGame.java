package GuesssingGame;
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
	public GuessingGame(int upperbound)
	
	{//this is a constructor
		this.upperBound = upperbound ;
		secret = getRandomNumber(this.upperBound);
	}
	/**
	 * Create a random number between 1 and limit
	 * @param limit is the upper limit for random number
	 * @return a random number between 1 and limit (inclusive)
	 */
	private int getRandomNumber(int limit) 
	{
		long seed = System.currentTimeMillis( );
		Random rand = new Random( seed );
		return rand.nextInt(limit) + 1;
	}
	
	public void setHint(String hint)
	{
		this.hint = hint ;
	}
	
	public boolean guess(int number)
	{	
		
		if (number == secret)
		{
			
			return true;
		}
			
		return false ;
	}
	/**
	* Return a hint based on the most recent guess.
	* @return hint based on most recent guess
	*/
	public String getHint(int number)
	{
		if (guess(number)== true)
		{	
			hint = "Right!, The secret number is %d\nYou used %d guesses";
			return String.format(hint, secret,counter);
		}
		else if (guess(number)==false)
		{
			if (number > secret)
			{	counter++ ;
				hint = "Sorry, too large\n";
				return hint;
			}
			else if (number < secret)
			{	counter++ ;
				hint = "Sorry, too small\n";
				return hint;
			}
		}
		return "Sorry, try again";
	}
}
