import java.util.Scanner;
public class PomodoroConverter
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int num = (int) (time / 0.5);
		int remainder = num % 5;
		
		if (num >= 5)
		{
			while(num % 5 != 0)
			{
				num--;
			}
			int evenPomodoro = (int) (num * 0.8);
			int totalPomodoro = evenPomodoro + remainder;
			System.out.println(totalPomodoro);
		}
		else
			System.out.println(num);
	}
}
