import java.net.*;
import java.io.*;
class net02
{
	public static void main(String args[]) throws Exception
	{
		InetAddress i = InetAddress.getByName("nik-PC");
		System.out.println(i);
	}
}