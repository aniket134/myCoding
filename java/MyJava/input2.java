import java.io.*;
public class input2
{
	public static void main(String args[])
	{
		try
		{
		char c = (char)System.in.read();
			while(c!='\r')
			{
				System.out.println(c);
				c = (char)System.in.read();
			}
		}
		catch(IOException e)
		{
			System.out.println("Error found");
		}
	}
}