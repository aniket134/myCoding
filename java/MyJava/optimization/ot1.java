
import java.util.*;
public class ot1{

	int maxmin=0;
	public ot1(){}
	float[] getOptimum(String obj, String one, String two){
		float[] a = new float[2];
		a = getIntersection(one,two);
		float[] b = new float[2];
		float[] c = new float[2];
		float[] e = new float[2];
		float[] f = new float[2];
		b = getXIntercept(one);
		if(b[0]!=0){
			b[0]=b[1];
			b[1]=0;
		}
		else{
			b[0]=b[1]=0;
		}
		c = getXIntercept(two);
		if(c[0]!=0){
			c[0]=b[1];
			c[1]=0;
		}
		else{
			c[0]=c[1]=0;
		}
		e = getYIntercept(one);
		if(e[0]!=0){
			e[0]=0;
		}
		else{
			e[0]=e[1]=0;
		}
		f = getYIntercept(two);
		if(f[0]!=0){
			f[0]=0;
		}
		else{
			f[0]=f[1]=0;
		}
		float d [] = new float[5];
		d[0] = getFuncValue(a,obj);	
		d[1] = getFuncValue(b,obj);
		d[2] = getFuncValue(c,obj);
		d[3] = getFuncValue(e,obj);
		d[4] = getFuncValue(f,obj);
		float[] value = new float[3];
		if(getMaxMin()==0){
			value = getMax(d);
		}
		else{
			value = getMin(d);
		}
		if(value[1]==0){
			value[1]=a[0];
			value[2]=a[1];
		}
		else if(value[1]==1){
			value[1]=b[0];
			value[2]=b[1];
		}
		else if(value[1]==2){
			value[1]=c[0];
			value[2]=c[1];
		}
		else if(value[1]==3){
			value[1]=e[0];
			value[2]=e[1];
		}
		else if(value[1]==4){
			value[1]=f[0];
			value[2]=f[1];
		}
		else{
			System.out.println("No optimum value");
			value[1]=0;
			value[2]=0;
			
		}
		System.out.println("success");
		return value;
	}
	
	float[] getMax(float[] a){
			float b=a[0];
			int pos=0;
			for(int i=0;i<a.length;i++){
				if(b<a[i]){
					b=a[i];
					pos=i;
				}
			}
			a[0]=b;
			a[1]=pos;
			System.out.println("Got max: "+b+" at position: "+pos);
			return a;
		}
	float[] getMin(float[] a){
			float b=a[0];
			int pos=0;
			for(int i=0;i<a.length;i++){
				if(b>a[i]){
					b=a[i];
					pos=i;
				}
			}
			a[0]=b;
			a[1]=pos;
			return a;
		}

	float getFuncValue(float[] point,String obj){
		float[] dd = new float[2];
		dd[0]=point[0];
		dd[1]=point[1];
		float a = getCoeff(obj,1);
		float b = getCoeff(obj,2);
		float c = getCoeff(obj,3);
		return (a*dd[0]+b*dd[1]+c);
	}

	float getCoeff(String one,int pos){
		StringTokenizer tokens = new StringTokenizer(one,",");
		int i=1;
		float x=0;
		try{
		while(tokens.hasMoreTokens()){
			if(i==pos){
				x = Float.parseFloat(tokens.nextToken());
			}
			i++;
			String temp = tokens.nextToken();
		}
		
		}
		catch(NoSuchElementException e){
			
		}
		return x;
	}
	
	
	float[] getIntersection(String one, String two){
 		float a1=getCoeff(one,1);
	 	float b1=getCoeff(one,2);
 		float c1=getCoeff(one,3);
	 	float a2=getCoeff(two,1);
 		float b2=getCoeff(two,2);
	 	float c2=getCoeff(two,3);
		float d [] = new float[3];
		d[0]=0;
		d[1]=1;
		d[2]=1;
 		if (a1/b1 == a2/b2){
 		    	System.out.println("Two lines are parellel.\n");
			d[0]=0;
			return d;
 		}    
	 	float m = (b1*c2 - b2*c1);
 		float n = (c1*a2 - c2*a1);
	 	float o = a1*b2 - a2*b1;
 		if(m==0 || n==0){
     			System.out.println("Two lines are one and the same.\n");
			d[0]=0;
			return d;
	  	}   	
		d[0]=0;
  		m = m/o;
	 	n = n/o;
	  	d[0] = 1;
   		d[1] = m;
		d[2] = n;
	 	return d;
	}    
	float[] getXIntercept(String one){
		float d [] = new float[2];
		d[0]=0;
		float a = getCoeff(one,1);
		float c = getCoeff(one,3);
		if(a!=0){
			d[0]=1;
			d[1] = (float)-c/a;		
		}
		return d;
	}
	float[] getYIntercept(String one){
		float d [] = new float[2];
		d[0]=0;
		float b = getCoeff(one,2);
		float c = getCoeff(one,3);
		if(b!=0){
			d[0]=1;
			d[1] = (float)-c/b;			
		}
		return d;
	}
	void setMaxMin(int maxmin){
		this.maxmin = maxmin;
	}
	int getMaxMin(){
		return maxmin;
	}
}
