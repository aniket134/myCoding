import java.io.*;
import java.util.*;
class MyException extends Exception{    //INSTEAD OF Exception, Throwable CAN BE USED
MyException(){
super("MyException found!!");
}
}
class ownException{
public static void main(String args[]){
System.out.print("Enter your name: ");
InputStreamReader i = new InputStreamReader(System.in);
BufferedReader b = new BufferedReader(i);
try{
String name = b.readLine();
if (name!=null)throw new MyException();
}
catch(MyException e){
System.out.println(e.getMessage());   //getMessage() SHOWS THE STRING SEND IN SUPER
}
catch(IOException e){
System.out.println(e.getMessage());
}
}
}