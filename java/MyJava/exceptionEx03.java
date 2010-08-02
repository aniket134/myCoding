/*
   THIS VERSION HELPS US OUTPUT ONLY THE STRING AND NOT ALL THE stack trace.
*/

class exceptionEx03{
public static void main(String args[]) {
try{
ExceptionEg.throwing();
}
catch(MyException02 m){
System.out.println(m.getMessage());
}
}
}