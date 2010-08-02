/*
   WE CAN USE THE WAY USED IN stringReader.java TO CATCH THE EXCEPTION OR
   THIS try-catch WAY CAN ALSO BE USED.
   INSTEAD IOException WE CAN WRITE Exception TOO, AS ALL EXCEPTION CLASSES extends    Exception CLASS.
*/

import java.io.*;
import java.util.*;
class iOException{
public static void main(String args[]){
try{
System.out.print("Enter Your Name: ");
InputStreamReader Text = new InputStreamReader(System.in);
BufferedReader BTF = new BufferedReader(Text);
String Name = BTF.readLine();
System.out.print("Enter Your Age: ");
int Age = Integer.parseInt(BTF.readLine());
System.out.println("Your Name is:\n\t"+Name);
System.out.println("Your Age is:\n\t"+Age);
}
catch(IOException e){
System.out.println("IOException found: "+e.getMessage());
}
}
}
