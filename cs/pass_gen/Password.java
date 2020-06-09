import java.util.*;
public class Password
{
  private char[] password;
  private int wordLength;
  public  static char[] characters = {'1', '2', '3', '4', '5', '6', '7', '8',
    '9', '0', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', 'a', 'b', 'c',
    'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
    's', 't', 'u', 'v', 'w', 'x', 'y', 'z','A', 'B', 'C', 'D', 'E', 'F', 'G',
    'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
    'W', 'X', 'Y', 'Z', '?', '>', '<', '.', ',', '+', '_', '-', '=', '[', '{',
    ']', '}', '|'};
 
  public char[] getPassword()
  {
    char[] copy = new char[this.password.length];
    System.arraycopy(this.password, 0, copy, 0, copy.length);
    return copy;
  }

  public void setPassword(char[] coded)
  {
    this.password = new char[coded.length];
    System.arraycopy(coded, 0, this.password, 0, coded.length);
  }

  public int getWordLength()
  {
    return this.wordLength;
  }
	
  public void setWordLength(int length)
  {
    if(length < 5 || length > 32)
    {
      throw new IllegalArgumentException();
    }
    this.wordLength = length;
  }
	
  public char[] generatePassword (int length)
  {
    char[] password = new char[length];

    for(int i = 0; i < length; i++)
    {
      password[i] = characters[(int) (Math.random() * characters.length)];
    }

    return password;
  }

}
