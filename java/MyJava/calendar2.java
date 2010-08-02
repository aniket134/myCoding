/*
CALENDAR IS AN ABSTRACT CLASS, SO WE CANNOT CREATE ITS INSTANCE USING new, ALTHOUGH A REFERENCE TO CALENDAR TYPE OBJECT CAN BE CREATED USING THE STATEMENT Calendar cal; 
BUT WE CAN CREATE ITS INSTANCE USING gatInstance() METHOD WHICH IS STATIC AND CAN BE USED ON Calendar DIRECTLY
ALL OF THE CALENDAR VARIABLES HAVE TO BE USED LIKE- Calendar.HOUR BUT THEIR VALUE WITHIN THE CALENDAR OBJECT CAN CHANGE.
*/

import java.util.*;
class calendar2{
public static void main(String args[]){
Calendar cal = Calendar.getInstance();
System.out.println(cal.get(Calendar.HOUR));
System.out.println(cal.get(Calendar.MINUTE));
System.out.println(cal.get(Calendar.SECOND));
cal.set(Calendar.HOUR,11);
cal.set(Calendar.MINUTE,12);
cal.set(Calendar.SECOND,13);
System.out.println("\n"+cal.get(Calendar.HOUR));
System.out.println(cal.get(Calendar.MINUTE));
System.out.println(cal.get(Calendar.SECOND));
Calendar cal2 = Calendar.getInstance();
cal.clear();
System.out.println("\n"+cal.get(Calendar.HOUR));
System.out.println("\n"+cal2.get(Calendar.HOUR));
System.out.println(cal2.get(Calendar.MINUTE));
System.out.println(cal2.get(Calendar.SECOND));
cal = Calendar.getInstance();
}
}