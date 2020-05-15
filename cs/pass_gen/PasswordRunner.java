import java.util.*;
public class PasswordRunner
{
	public static void main (String[] args)
	{
		Password obj = new Password();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of your desired password. It has to be between 5 and 32 characters: ");
		obj.setWordLength(sc.nextInt());
		
		obj.setPassword(obj.generatePassword(obj.getWordLength()));
		System.out.println(obj.getPassword());

	}
}
