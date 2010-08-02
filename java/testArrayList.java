import java.util.ArrayList;
public class testArrayList{
	public static void main(String args[]){
		System.out.println("Hello There");
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("yes");
		strings.add("no");
		strings.add("maybe");
		ArrayList<String> strings2 = new ArrayList<String>();
		strings2.add("yes");
		strings2.add("maybe");
		strings2.add("no");
		System.out.println(strings);
		System.out.println(strings.equals(strings2));
		System.out.println(strings.containsAll(strings2));

	}
}
