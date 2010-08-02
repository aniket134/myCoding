class Thread07 implements Runnable
{
	Thread t;
	Thread07(int a)
	{
		t = new Thread(this);
		t.setPriority(a);
		t.start();
	}
	public void run()
	{
		while(true)
		{
			count++;
		}
	}
	int count=0;
}
class Thread08 implements Runnable
{
	Thread tt;
	Thread08(int a)
	{
		tt = new Thread(this);
		tt.setPriority(a);
		tt.start();
	}
	public void run()
	{
		while(true)
		{
			counting++;
		}
	}
	int counting=0;
}
		
class threading05
{
	public static void main(String args[])
	{
	Thread07 p = new Thread07(Thread.MAX_PRIORITY);
	Thread08 pp = new Thread08(Thread.MIN_PRIORITY);
	try
	{
		Thread.sleep(1000);
	}
	catch(InterruptedException e)
	{
		System.out.println("");
	}
	pp.tt.stop();
	p.t.stop();
	try
	{
		p.t.join();
		pp.tt.join();
	}
	catch(InterruptedException e)
	{
		System.out.println("");
	}

	System.out.println(p.count);
	System.out.println(pp.counting);
	}
}