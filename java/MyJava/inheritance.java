class ABCinheritance{
	void  show(){};//MUST BE DECLARED, IN ABSTRACT CLASS & INTERFACE TOO.
}
class XYZinheritance  extends  ABCinheritance{
	void show(){System.out.println("We're in XYZinheritance.");}
}
class inheritance{
	static void ShowMe(){System.out.println("Method created inside the class the contains main()");}
	public static void main(String args[]){
		ABCinheritance  abc = new XYZinheritance();
		abc.show();
		inheritance ihtnc = new inheritance();
		ShowMe();//THIS WILL RUN WITH ihtnc.ShowMe() TOO. BUT IT IS NECESSARY TO CREATE ShowMe() STATIC TO USE IT ALONE.
	}
}

