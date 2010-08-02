class testString{
public static void main(String args[]){
String s1 = "abc";
System.out.println(s1);
s1 +="def";
System.out.println(s1);
String s2 = new String("Hey, wassup?");
char[] ch = new char[s2.length()];
for(int i=0; i<s2.length();i++){
ch[i]=s2.charAt(i);
System.out.println(ch[i]);
}
String s3 = "ABCDEF";
System.out.println(s3.equals(s1));
System.out.println(s3.equalsIgnoreCase(s1));
System.out.println(s3.compareTo(s1));
System.out.println(s1.compareTo(s3));
System.out.println(s3.compareToIgnoreCase(s1));
}
}