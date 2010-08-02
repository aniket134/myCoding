/*
When a simple type is passed to a method, it is done by use of call-by-value. Objects are
passed by use of call-by-reference.
*/
class Test
{
	int a;
	Test(int i)
	{
		a=i;
	}
	public void cbValue(int a)
	{
		a*=2;
	}
	public void cbRef(Test o)
	{
		o.a *=2;
	}
}
class passByTest
{
	public static void main(String args[])
	{
		Test t = new Test(3);
		int d=2;
		t.cbValue(d);
		System.out.println("The value of d is: "+d);
		t.cbRef(t);
		System.out.println("The value of a is: "+t.a);
	}
}