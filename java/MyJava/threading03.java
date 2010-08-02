class Thread05 extends Thread
{
	Thread05	(String name)
	{
		super(name);
	}
	void Start()
	{
		this.start();
	}
	public void run()
	{
		for(int i=0;i<15;i++)
		{
			System.out.println((i+1)+". Inside Thread05.");
		}
	}
}
class threading03
{	
	public static void main(String args[])
	{
		Thread05 t5 = new Thread05("nameOfThread05");
		Thread t4 = new Thread(new Thread04());
		Thread03 t3 = new Thread03();
		Thread02 t2 = new Thread02();
		Thread01 t1 = new Thread01();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.Start();
	}
}