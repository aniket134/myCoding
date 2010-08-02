import java.io.*; import java.util.*;
class fileReader{
public static void main(String args[]) throws IOException{
FileReader test = new FileReader("testFileReader.txt");
BufferedReader TXT = new BufferedReader(test);
String content = TXT.readLine();
while(content!=null){
System.out.println(content);
content = TXT.readLine();
}
test.close();

test = new FileReader("testFileReader.txt");
TXT = new BufferedReader(test);
String content2 = TXT.readLine();
content2 +=TXT.readLine();
StringTokenizer ST = new StringTokenizer(content2,"#");
while(ST.hasMoreTokens()){
System.out.println(ST.nextToken());
}
}
}