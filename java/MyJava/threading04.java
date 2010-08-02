class Thread06 implements Runnable
{
	Thread06(String str)
	{
		t = new Thread(this,str);
	}
	Thread t;
	void Start()
	{
		t.start();
	}
	public void run()
	{
		for(int i=0;i<15;i++)
		{
			try
			{
				t.sleep(500);
				System.out.println((i+1)+"Inside Thread06.");
			}
			catch(InterruptedException e)
			{
				System.out.println("Thread06 interrupted.\n\t"+e.getMessage());
			}
		}
	}
}
class threading04
{
	public static void main(String args[])
	{
		Thread04 tt = new Thread04();
		Thread t4 = new Thread(tt);
		Thread03 t3 = new Thread03();
		Thread02 t2 = new Thread02();
		Thread01 t1 = new Thread01();
		Thread05 t5 = new Thread05("nameOfThread05");
		Thread06 t6 = new Thread06("nameOfThread06");
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		System.out.println(t3.isAlive());
		System.out.println(t4.isAlive());
		System.out.println(t5.isAlive());
		System.out.println(t6.t.isAlive());
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Main thread interrupted\n\t."+e.getMessage());
		}		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.Start();
		t6.Start();
		try
		{
			System.out.println("Now we wait for \"t6\" to end (as it takes the most amount of time).");
			t6.t.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("Main thread interrupted\n\t."+e.getMessage());
		}	
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		System.out.println(t3.isAlive());
		System.out.println(t4.isAlive());
		System.out.println(t5.isAlive());
		System.out.println(t6.t.isAlive());
	}	
}