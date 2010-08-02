import java.util.*;
class date{
public static void main(String args[]){
Date date = new Date();
String dat = date.toString();
System.out.println(date);
System.out.println(dat);
Date cloneDate = (Date)(date.clone());
/*clone() RETURNS OBJECT TYPE CLASS.
THIS IS TYPE  CONVERSION INTO DATE TYPE OF OBJECT TYPE*/
}
}