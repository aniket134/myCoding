public class Player
{
	private int lives;
	private int score;
	public Player()
	{
		lives=10;
		score=0;
	}
	public void setScore(int i)
	{
		score +=i;
	}
	public int getScore()
	{
		return score;
	}
	public void killLife()
	{
		lives--;
	}
	public int getLives()
	{
		return lives;
	}
}