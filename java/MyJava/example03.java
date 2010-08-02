import java.io.*;
class example03
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader in;
		in=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your name: ");
		String name = in.readLine();
		System.out.println("Your name is "+name);
		int age = Integer.parseInt(name);
		System.out.println("Your age is: "+age);
	}
}
