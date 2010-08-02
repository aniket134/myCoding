class testDouble{
	public static void main(String args[]){
		double a = 2.2;
		double b = 2.1;
		double c = 3.4;
		double d = 4.5;
		float e = (float)(a*b); //	FLOAT GIVES 2 POINT PRECISION
		double f = a*b+c*d;
		double g = (double)(a*b+c*d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
	}
}