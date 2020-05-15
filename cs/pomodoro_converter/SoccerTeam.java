public class SoccerTeam
{
	private int wins;
	private int losses;
	private int ties;
	public static int GAMES_PLAYED;
	public static int TOTAL_GOALS;
	public SoccerTeam(int initWins, int initLosses, int initTies)
	{
		wins = initWins;
		losses = initLosses;
		ties = initTies;
	}
	public static void setGamesPlayed(int newGamesPlayed)
	{
		GAMES_PLAYED = newGamesPlayed;
	}
	public static void setTotalGoals(int newTotalGoals)
	{
		TOTAL_GOALS = newTotalGoals;
	}

	public int getWins()
	{
		return wins;
	}	
	
	public int getLosses()
	{
		return losses;
	}
	
	public int getTies()
	{
		return ties;
	}
	
	public void played(SoccerTeam other, int myScore, int otherScore)
	{
		if (myScore > otherScore)
		{
			wins++;
			other.losses++;
		}
		else if (myScore < otherScore)
		{
			losses++;
			other.wins++;
		}
		else
		{
			ties++;
			other.ties++;
		}
		GAMES_PLAYED++;
		TOTAL_GOALS += myScore + otherScore;
	}
	
	public int points()
	{
		int total = this.wins * 3 + this.ties * 1;
		return total;
	}
	
	public void reset()
	{
		wins = 0;
		losses = 0;
		ties = 0;
	}

	public static void startTournament()
	{
		setGamesPlayed(0);
		setTotalGoals(0);
	}
}

