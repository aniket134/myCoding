import java.util.*;
class example14{
public String toString(){
System.out.println("We are now inside toStringMethodTest Class.");
return "";}
}

/*
   toString() SHOULD RETURN A STRING OBJECT 
   IT IS USED TO PRINT AN ONSTANCE OF CLASS DIRCTLY
   System.out.println(OBJECTNAME) 
*/

class toStringMethodTest{
public static void main(String args[]){
Calendar cal =  Calendar.getInstance();

/* WE CAN SIMPLY OUTPUT System.out.println(cal) */

String data = cal.toString();
StringTokenizer indData = new StringTokenizer(data,",[]");
while(indData.hasMoreTokens()){
System.out.println(indData.nextToken());
}
System.out.println(new toStringMethodTest());
}
}