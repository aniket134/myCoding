class scopeTest
{
	public static void main(String args[])
	{
	try
	{
		int x = 44;
		System.out.println("Value of x before the block: "+x);
		{
			x=66;
			System.out.println("Value of x inside block: "+x);
		}
			System.out.println("Value of x outside block: "+x);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	}
}