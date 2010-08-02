import JavaPackage.Exthreading02;
class Thread04 extends Exthreading02 implements Runnable
{
	public void run()
	{
		Exthreading02.showsomething();
	}
}
class threading02
{
	public static void main(String args[])
	{
		Thread t4 = new Thread(new Thread04());
		Thread01 t1 = new Thread01();
		Thread02 t2 = new Thread02();
		Thread03 t3 = new Thread03();
		t4.start();
		t1.start();
		t2.start();
		t3.start();
	}
}