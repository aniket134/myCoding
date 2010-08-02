import java.net.*;
import java.io.*;
class networking01
{
	public static void main(String args[]) throws Exception
	{
		Socket s = new Socket("internic.net",43);
/* THIS EXAMPLE WON'T WORK BECAUSE OF THE ABOVE STATEMENT. */
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		String str = "osborne.com\n";
		byte b[] = str.getBytes();
		out.write(b);
		int c;
		while((c=in.read())!=-1)
		{
			System.out.print((char)c);
		}
		s.close();
	}
}