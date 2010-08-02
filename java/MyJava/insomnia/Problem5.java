import java.io.*;
import java.util.*;

class Problem5{
	public static void main(String args[]){
		int M=100;
		int N=100;
		int[][] array = new int[100][100];
		int value = 0;
		int finala = 0;
		int finalb = 0;
		int finalc = 0;
		int finald = 0;
		int finalx = 0;
		int finaly = 0;
		try{
		FileInputStream aFile = new FileInputStream("input.txt");
		BufferedReader input =  new BufferedReader(new InputStreamReader(aFile));
		try{
			String line="abc";
			int i=0;
			while((line=input.readLine()) !=null){
				StringTokenizer tokens = new StringTokenizer(line," ");
				while(tokens.hasMoreTokens()){
					if(i==0){
						try{
						N = Integer.parseInt(tokens.nextToken());
						}
						catch(Exception e){
						}
					}
					else if(i==1){
						try{
						M = Integer.parseInt(tokens.nextToken());
						}
						catch(Exception e){
						}
					}
					else{
						for(int j=0;j<M;j++){
						try{
							array[i-2][j] = Integer.parseInt(tokens.nextToken());
						}
						catch(Exception e){
						}
						}
						
					}
					i++;
				}
			}
		}
		catch(Exception e){
			System.out.println("error 1");
			System.out.println(e);
		}		

		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println("M"+M+"N"+N);
		for(int a=0;a<=M;a++){
		for(int b=1;b<M;b++){
			for(int c=1;c<N/2;c++){
			for(int d=0;d<=N;d++)
			if((((a%2==0) && (b%2==0)) || ((a%2!=0) && (b%2!=0))) && d>=c && (c-b==1 || c==b || c-b==-1) && b<a && (c+d)<=N ){
		for(int x=0;x<M-c-d+1;x++){
			for(int y = 0;y<N-a+1;y++){ 
					int t = 0;
					int aa=0;
					int bb=0;
					int cc=0;
					int dd=0;
					for( cc=0;cc<c;cc++){
						for( aa=0;aa<a;aa++){
							if((x+cc)<N && (y+aa)<M){
							t+=array[x+cc][y+aa];
									if(a==5&&b==1&&c==1&&d==1){
										System.out.println(array[x+cc][y+aa]);
									}
							}
						}
					}
					
					if(aa%2==0){
						int bbb = a/2-1;
						
						for( dd=0;dd<d;dd++){
								for( bb=0;bb<b;bb++){
									if((x+cc+dd)<N && (y+bbb+bb)<M)
									t+=array[x+cc+dd][y+bbb+bb-1];
									if(a==4&&b==2&&c==2&&d==3&&x==0&&y==1){
						//				System.out.println(array[x+cc+dd][y+bb+bbb]);
									}
								}
						}
					}
					else {
						
						int bbb = a/2;
						for( dd=0;dd<d;dd++){
								for( bb=-b/2;bb<=b/2;bb++){
									if((x+cc+dd)<N && (y+bbb+bb)<M){
									t+=array[x+cc+dd][y+bbb+bb-1];
									if(a==5&&b==1&&c==1&&d==1){
										System.out.println(array[x+cc+dd][y+bb+bbb]);
									}
									}
								}
						}
					}
					if(y==0&&x==4){
						System.out.println(t);
					}
					if(t>value){
						value=t;
						finala=a;
						finalb=b;
						finalc=c;
						finald=d;
						finalx=x;
						finaly=y;
					try{
						FileOutputStream outFile = new FileOutputStream(new File("output.txt"));
					        PrintWriter out = new PrintWriter(outFile);
						out.println(finala);
						out.println(finalb);
						out.println(finalc);
						out.println(finald);
						out.println(finaly+" "+finalx);
						out.println(value);
						out.close();
					}
					catch(Exception e){
						System.out.println(e);
					}	
					}
				else{
					continue;
				}
			}
		}
			}
			else{
				continue;
			}
		}
		}
		}
		System.out.println("Value : "+value);
		System.out.println("a: "+finala+"\tb:"+finalb+"\tc: "+finalc+"\td: "+finald);
		System.out.println("x: "+finaly+"y: "+finalx);
	}
}
