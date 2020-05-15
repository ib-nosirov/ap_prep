import java.util.*;
public class hangmanRunner
{
	public static void main(String[] args)
	{	
		hangman.setEverything();
		hangman.playGame();
		System.out.println("Your word was: " + hangman.getTargetWord());
	}
}
