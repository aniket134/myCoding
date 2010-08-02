/*
   To make this example compile, you need to make two changes. First, you need to
   declare that throwing( ) throws MyException02. Second, main( ) must define
   a try/catch statement that catches this exception.
*/
class ExceptionEg{
static void throwing() throws MyException02{
System.out.println("Inside throwing().");
throw new MyException02();
}
}
class MyException02 extends Exception{
MyException02(){
super("Inside MyException02.");
}
}
class exceptionEx{
public static void main(String args[]) {
try{
ExceptionEg.throwing();
}
catch(MyException02 mye){
System.out.println(mye.getMessage());
}
catch(Exception e){
System.out.println(e);
}
}
}