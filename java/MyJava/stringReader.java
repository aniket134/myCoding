import java.io.*;
import java.util.*;
class stringReader
{
	public static void main(String args[]) throws IOException
	{
		System.out.print("Enter Your Name: ");
		InputStreamReader Text = new InputStreamReader(System.in);
		BufferedReader BTF = new BufferedReader(Text);
		String Name = BTF.readLine();
		System.out.print("Enter Your Age: ");
		int Age = Integer.parseInt(BTF.readLine());
		System.out.println("Your Name is:\n\t"+Name);
		System.out.println("Your Age is:\n\t"+Age);
	}
}
