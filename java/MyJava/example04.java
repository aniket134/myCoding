import java.io.*;
class example04
{
	public static void main(String args[])throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your last name: ");
		String LastName = in.readLine();
		System.out.print("Enter your first name: ");
		String FirstName = in.readLine();
		System.out.println("Hello, "+FirstName+" "+LastName);
	}
}
