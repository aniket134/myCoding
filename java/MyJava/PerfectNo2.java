class PerfectNo2{
	public static void main(String args[]){
	for(int a=1;a<40;a++){
		int[] b=new int[a/2];
		int count=0;
		for(int i=1;i<=a/2;i++){
			if(a%i == 0){
				b[count++]=i;
			}
		}
		for(int i=0;i<count;i++){
			for(int j=i+1;j<count;j++){
				int temp=b[j];
				if((temp+b[i])==a){
					System.out.println(a+" is a Perfect  Number.");
				}
			}
		}
	}
	}
}