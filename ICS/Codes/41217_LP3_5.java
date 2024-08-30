import java.util.Arrays;
import java.util.Scanner;


public class SDESEncryption_4317 {
	

	// variable declarion

	int key[]={0,1,0,1,0,0,0,0,0,1,0};
	int pltext[]={0,0,1,1,1,0,0,1,0};
	int P10[]={3,5,2, 7,4,10, 1,9,8 ,6};
	Scanner sc=new Scanner(System.in);
	int P8[] = { 6, 3, 7, 4, 8, 5, 10, 9};
	int P4[] = { 2, 4, 3, 1};
	int IP[] = { 2, 6, 3, 1, 4, 8, 5, 7};
	int EP[] = { 4, 1, 2, 3, 2, 3, 4, 1};
	int key1[]=new int[9];
	int key2[]=new int[9];
	int S0[][] = {{ 1, 0, 3, 2},{ 3, 2, 1, 0},{ 0, 2, 1,3},{ 3, 1, 3, 2}};
	int S1[][] = {{ 0, 1, 2, 3},{ 2, 0, 1, 3},{ 3, 0, 1,2},{ 2, 1, 0, 3}};
	int IPI[] = { 4, 1, 3, 5, 7, 2, 8, 6};
	private int p4ops[];
	
	int L2[],R2[];
	   

	// Input function to input 10 bit key and 8 bit key.    
	public void inputKeyFunction()
	{
		System.out.print("enter 10 bit key");
		for(int i=1;i<=10;i++)
		key[i]=sc.nextInt();		
		
		System.out.print("enter 8 bit text");
		for(int i=1;i<=8;i++)
		pltext[i]=sc.nextInt();
		
		display_array(pltext);
	}
	public int bitToInt(int a,int b)
	{
		if(a==0 && b==0)
			return 0;
		else if(a==0 && b==1)
			return 1;
		else if(a==1 && b==0)
			return 2;
		return 3;
	}
	public int[] xor(int a[],int b[])
	{
		int y[]=new int[a.length];
		
		for(int i=1;i<a.length;i++)
			 if(a[i]==b[i])
				 y[i]=0;
			 else
				  y[i]=1;
		return y;
	}
	
	public int[] permutation(int x[], int p[], int pmax)
	{
		int y[]=new int[p.length+1];
		
		for(int i=0;i<pmax;i++)
		{
			y[i+1]=x[p[i]];
			System.out.print(y[i +1]+" ");
		}
		return y;
		
	}
	
	public int[] shiftArray(int a[],int n)
	{
		int y[]=new int[a.length];
		for(int i=1;i<a.length;i++)
		{
			if(i+n<a.length)
			   y[i]=a[i+n];
			else
			   y[i]=a[i+n-a.length+1];
		}
		return y;
	}
	public void display_array(int a[])
	{
		for(int i=1;i<a.length;i++)
			System.out.print(a[i]);
		System.out.print("\n");
	}
	public void keygeneration()
	{
		//System.out.print(P10.length);
	 int p10op[]=permutation(key,P10,P10.length);
		
	 	System.out.println("\n p-10 output  :");
		display_array(p10op);
		
		int L[]=new int[6];
		int R[]=new int[6];
		
		System.arraycopy(p10op, 1,L , 1, 5);
		System.out.print("L= ");
		display_array(L);
		System.arraycopy(p10op, 6,R , 1, 5);
		System.out.print("R= ");
		display_array(R);
		
		L=shiftArray(L,1);
		display_array(L);
		
		R=shiftArray(R,1);
		display_array(R);
		

		System.arraycopy(L, 1, key, 1, 5);
		System.arraycopy(R, 1, key, 6, 5);
	    
		  key1=permutation(key,P8,P8.length);
		 System.out.println("\n p-8 output  :");
			display_array(key1);
			
			L=shiftArray(L,2);
			display_array(L);
			
			R=shiftArray(R,2);
			display_array(R);
			
			System.arraycopy(L, 1, key, 1, 5);
			System.arraycopy(R, 1, key, 6, 5);
		    
			  key2=permutation(key,P8,P8.length);
			 System.out.println("\n p-8 output  :");
				display_array(key2);
		 
	}
	
	public void round1()
	{  
		int ipop[]=permutation(pltext,IP,IP.length);

	 	System.out.println("\n IP-8 output  :");
		display_array(ipop);
		 
		int L[]=new int[5];
		int R[]=new int[5];
		
		System.arraycopy(ipop, 1,L , 1, 4);
		System.out.print("L= ");
		display_array(L);
		System.arraycopy(ipop, 5,R , 1, 4);
		System.out.print("R= ");
		display_array(R);
		
		int epop[]=permutation(R,EP,EP.length);
		System.out.print("\n EP ooutput ");
		display_array(epop);
		
		epop=xor(key1,epop);
		display_array(epop);
		
		int L1[]=new int[5];
		int R1[]=new int[5];
		
		System.arraycopy(epop, 1,L1 , 1, 4);
		System.out.print("L1= ");
		display_array(L1);
		System.arraycopy(epop, 5,R1, 1, 4);
		System.out.print("R1= ");
		display_array(R1);
		
	 L2=gets0Box(L1);
	 System.out.print("L2= "+L2[0]+""+L2[1]);
	 R2=gets1Box(R1);
	 System.out.print("R2= "+R2[0]+""+R2[1]);
	 
	 int Sop[]=new int[5];
	 System.arraycopy(L2, 0,Sop , 1, 2);
	 System.arraycopy(R2, 0,Sop , 3, 2);
	 System.out.print("S op= ");
		display_array(Sop);
	
	p4ops = permutation(Sop,P4,P4.length);
	
	int xop[]=xor(L,p4ops);
	 System.out.print("xor op= ");
		display_array(xop);
	
		L2=xop;
		R2=R;
	 
	}
		public void round2()
	{
			 System.out.println("\n===============ROUND2==========================");	
		int temp[]=R2;
		 R2=L2;
		 L2=temp;
		 
		 System.arraycopy(L2, 1,pltext , 1, 4);
		 System.arraycopy(R2, 1,pltext , 5, 4);
		 
		 System.out.print("Plain text= ");
			display_array(pltext);
			
			
			int L[]=new int[5];
			int R[]=new int[5];
			
			System.arraycopy(pltext, 1,L , 1, 4);
			System.out.print("L= ");
			display_array(L);
			System.arraycopy(pltext, 5,R , 1, 4);
			System.out.print("R= ");
			display_array(R);
			
			int epop[]=permutation(R,EP,EP.length);
			System.out.print("\n EP ooutput ");
			display_array(epop);
			
			epop=xor(key2,epop);
			display_array(epop);
			
			int L1[]=new int[5];
			int R1[]=new int[5];
			
			System.arraycopy(epop, 1,L1 , 1, 4);
			System.out.print("L1= ");
			display_array(L1);
			System.arraycopy(epop, 5,R1, 1, 4);
			System.out.print("R1= ");
			display_array(R1);
			
		 L2=gets0Box(L1);
		 System.out.print("L2= "+L2[0]+""+L2[1]);
		 R2=gets1Box(R1);
		 System.out.print("R2= "+R2[0]+""+R2[1]);
		 
		 int Sop[]=new int[5];
		 System.arraycopy(L2, 0,Sop , 1, 2);
		 System.arraycopy(R2, 0,Sop , 3, 2);
		 System.out.print("S op= ");
			display_array(Sop);
		
		p4ops = permutation(Sop,P4,P4.length);
		 System.out.print("P4 op= ");
			display_array(p4ops);

		int xop[]=xor(L,p4ops);
		 System.out.print("xor op= ");
			display_array(xop);
		
			L2=xop;
			R2=R;
		
			 System.arraycopy(L2, 1,pltext , 1, 4);
			 System.arraycopy(R2, 1,pltext , 5, 4);
		pltext=permutation(pltext,IPI,IPI.length);	
		System.out.print("Final op= ");
			display_array(pltext);
			
	}

private int[] gets1Box(int[] l1) {
	int result[]=new int[2];
	
	int row=bitToInt(l1[1],l1[4]);
	int col=bitToInt(l1[2],l1[3]);
	int y=S1[row][col];
	 result[1] =y % 2;
	 y =y / 2;
	 result[0] =y % 2;


	return result;
	}
private int[] gets0Box(int l1[]) {
		int result[]=new int[2];
		
		int row=bitToInt(l1[1],l1[4]);
		int col=bitToInt(l1[2],l1[3]);
		int y=S0[row][col];
		
		    result[1]=y % 2;
		    y =y / 2;
		    result[0] =y % 2;
		return result;
	}
public static void main(String args[])
	{
		SDESEncryption_4317 obj=new SDESEncryption_4317();
		obj.inputKeyFunction();
		obj.keygeneration();
		obj.round1();
		obj.round2();
		
	}
}
