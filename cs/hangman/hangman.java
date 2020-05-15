import java.util.*;

public class hangman
{
	private static String[] library = new String[20];
	private static String targetWord;
	private static String[] inProgressWord;
	private static int guesses;
	private static String[] guessedLetters = new String[26];
	private static int masterCounter;


	public static void setMasterCounter() //every good story needs time; but also this counter will be used to place the guessed words in the right slots
	{
		masterCounter = 0;
	}

	public static void setLibrary() //create a library of words to choose from
	{
		library[0] = "malice";
		library[1] = "president";
		library[2] = "future";
		library[3] = "past";
		library[4] = "love";
		library[5] = "hate";
		library[6] = "mania";
		library[7] = "courage";
		library[8] = "cowardice";
		library[9] = "hope";
		library[10] = "popcorn";
		library[11] = "fatality";
		library[12] = "casualty";
		library[13] = "land";
		library[14] = "writing";
		library[15] = "fisherman";
		library[16] = "trial";
		library[17] = "doing";
		library[18] = "making";
		library[19] = "camping";
	}

	public static void setGuesses()
	{
		guesses = 0;
	}

	//choose a target word from the library of words
	public static void setTargetWord()
	{
		setLibrary();
		int i = (int) (Math.random() * 20);
		targetWord = library[i];
	}
	
	// when the game ends, we'll need to tell the player what the word was. Wouldn't want to leave them in suspense
	public static String getTargetWord()
	{
		return targetWord;
	}	

	public static void setGuessedLetters()
	{
		guessedLetters = new String[26];
		
		for(int i = 0; i < 26; i++)
		{
			if (guessedLetters[i] == null)
				guessedLetters[i] = " ";
		}
	}

	//create an word in progress that displays every time you guess the word, regardless of whether a letter matches or not
	public static void setInProgressWord()
	{
		inProgressWord = new String[targetWord.length()];
		for(int i = 0; i < inProgressWord.length; i++)
		{
			if (inProgressWord[i] == null)
				inProgressWord[i] = " ";
		}	
	}
	
	//method that handles the act of guessing a word and updating any progress the player makes 
	public static void guessLetter(String letter)
	{
		int instanceCounter = 0; //counts if any letters are a match
		for(int i = 0; i < targetWord.length(); i++)
		{
			if (letter.equals(targetWord.substring(i, i + 1)))
			{
				inProgressWord[i] = letter;
				instanceCounter++;
			}
		}

		if (instanceCounter == 0)
		{
			System.out.println("there is no such letter in the word");
			guesses++;
		}
		System.out.println("here's the progress on the word");
		for(int i = 0; i < inProgressWord.length; i++) //display the word itself
		{
			System.out.print(inProgressWord[i]);
		}

		guessedLetters[masterCounter] = letter; //update the list of guessed letters
		masterCounter++; //keep the game turn clock ticking

	}

	public static void setEverything() //think of this as the reset method, but I can't call it reset because this occurs at the beginning of the game. Semantics... very important
	{
		setGuessedLetters();	
		setMasterCounter();
		setTargetWord();
                setGuesses();
                setInProgressWord();
	}
	public static void playGame() //play the game and decide when to end it. If you reach 6 guess, it's over and if you have no more empty slots, the game is also over
        {
                Scanner scan = new Scanner(System.in);
		System.out.println("you've guessed the following letters ");
		
		for(int i = 0; i < 26; i++)
		{
			System.out.println(guessedLetters[i]);
		}

		System.out.println("enter a letter: ");
		String letter = scan.nextLine();
                
		hangman.guessLetter(letter);
                
		System.out.println();
		
		if (guesses > 5)
			System.exit(0);

		for(String e : inProgressWord)
		{
			if (e.equals(" "))
			{
				playGame();
			}
		}
        }
}
