class Thread01 extends Thread
{
	public void run()
	{
		for(int i=0; i<15;i++)
		{
			System.out.println((i+1)+". Inside Thread01.");
		}
	}
}
class Thread02 extends Thread
{
	public void run()
	{
		for(int i=0; i<15;i++)
		{
			System.out.println((i+1)+". Inside Thread02.");
		}
	}
}
class Thread03 extends Thread
{
	public void run()
	{
		for(int i=0; i<15;i++)
		{
			System.out.println((i+1)+". Inside Thread03.");
		}
	}
}
class threading01
{
	public static void main(String args[])
	{
		Thread01 t1 = new Thread01();
		Thread02 t2 = new Thread02();
		Thread03 t3 = new Thread03();
		t1.start();
		t2.start();
		t3.start();
	}
}