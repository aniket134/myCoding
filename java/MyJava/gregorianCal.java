import java.util.*;
class gregorianCal{
public static void main(String args[]){
String months[]={"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
GregorianCalendar gc = new GregorianCalendar();
System.out.println(months[gc.get(Calendar.MONTH)]);
gc.set(Calendar.MONTH,0);
System.out.println(months[gc.get(Calendar.MONTH)]);
}
}