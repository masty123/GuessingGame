package GuesssingGame;
import java.util.Random;
/**
* Game of guessing a secret number.-- guess the number until you correct!!
* @author Theeruth Borisuth
*/
public class GuessingGame {
	int counter = 1 ;
	int upperBound;
	int secret;
	String hint = "";

	public GuessingGame(int upperbound)

	{
		this.upperBound = upperbound ;
		secret = getRandomNumber(this.upperBound);
	}
	
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
