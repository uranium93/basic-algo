import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class tp {
	
	static int res;
	static int n;
	int mz;
	static int n_o;
	static int m;
	static boolean ex=false;
	
	
	
	
	
	
	
	static int minL(int t[][], int l){
		res=t[l][0];
		for (int i=0 ; i<m;i++){
			if (res > t[l][i]){
				res=t[l][i];
			}
		}
		
	
	return res;	
	}
	int minC(int t[][], int c){
		res=t[1][c];
		for (int i=1 ; i<=n;i++){
			if (res  > t[i][c]){
				res=t[i][c];
			}
		}
		
	
	return res;	
	}
	
	public static void cherz(int a[][],int b[][]){
		int x = 0;
		for (int i=0 ; i<m;i++){
			for (int j=0;j<m;j++){
				if (a[i][j]==0){
					b[x][0]=i;
					b[x][1]=j;
					++x;
				}
				
			}
		}
		
	}
	public static boolean exis(int a[][],int x , int y){
		boolean t = false;	
		for (int i=0 ; i<n_o;i++){
			
				if (a[i][y]==x && a[i][y]>=0){
					t=true;
				}
				
				
			}
		return t;
	}
	public static boolean existe(int mat[][],int x,int y){
	boolean t = false;	
	for (int i=0 ; i<n_o;i++){
		
			if (mat[i][0]==x||mat[i][1]==y){
				t=true;
			}
			
			
		}
	return t;
	}
	static void marq_flot(int a[][],int y[][],int x[][]){
		int v=0;
		int w=0;
		for (int i=0 ; i<n_o;i++){
			
				if (existe(x,a[i][0],a[i][1])){
					y[v][0]=a[i][0];
					y[v][1]=a[i][1];
					++v;
				}else {
					x[w][0]=a[i][0];
					x[w][1]=a[i][1];
					++w;
				}
			}
		
	}
	public static void main(String[] args) throws IOException {
		
		// number of lines
		//BufferedReader reader = new BufferedReader(new FileReader("src/array.txt"));
		
		//while (reader.read() !=null) m++;
		//reader.close();
		
		
		
		//reading data 
		Scanner read = new Scanner(new File("src/array.txt"));
		
		while (read.hasNextInt()){
			read.nextInt();
			
				 m=m+1;
			
			
		}
		read.close();
		m=(int)Math.sqrt(m);		
		int[][] M = new int[m][m];
		Scanner input = new Scanner(new File("src/array.txt"));
		
				for(int i = 0; i < m; ++i)
				{
				    for(int j = 0; j <m; ++j)
				    {
				        if(input.hasNextInt())
				        {
				            M[i][j] = input.nextInt();
				        }
				    }
				}
		
				input.close();
	
	
	
	for(int i = 0; i < m; ++i)		{    for(int j = 0; j <m; ++j)   {   System.out.print(M[i][j] +" | ");  } System.out.println();	}
				
	int[][] M_o = new int[m][m];			
	
	int mz=0;
	for (int i=0;i<m;i++){
		mz=minL(M,i);
		for (int j=0;j<m;j++){
			M_o[i][j]=M[i][j]-mz;
		}
	}
	System.out.println();
	for(int i = 0; i < m; ++i)		{    for(int j = 0; j <m; ++j)   {   System.out.print(M_o[i][j] +" | ");  } System.out.println();	}
	
	for (int i=0 ; i<m;i++){
		for (int j=0;j<m;j++){
			if (M_o[i][j]==0){
				
				n_o=n_o+1;
				
			}
			
		}
	}
	System.out.println("nombre des zero :"+n_o);
	
	System.out.println("verification du float max");
	int[][] flot = new int[n_o][2];
	int[][] Y = new int[n_o][2];
	int[][] X = new int[n_o][2];
	for(int i=0;i<n_o;i++){
		Y[i][0]=-1;Y[i][1]=-1;
	}
	for(int i=0;i<n_o;i++){
		X[i][0]=-1;X[i][1]=-1;
	}
	cherz(M_o,flot);
	marq_flot(flot,Y,X);
	System.out.println("float maqrue :");
	for(int i=0;i<n_o;i++){
		System.out.println(flot[i][0]+"|"+flot[i][1]);
	}
	System.out.println("La coupe :");
	System.out.println();
	for(int i=0;i<n_o;i++){
		System.out.println(Y[i][0]+"|"+Y[i][1]);
	}
	System.out.println();
	for(int i=0;i<n_o;i++){
		System.out.println(X[i][0]+"|"+X[i][1]);
	}
	System.out.println();
		
		
		System.out.print("colomnes a barré : ");
		for(int i=0;i<n_o;i++){
		if(Y[i][1]>=0){
		System.out.print(" "+Y[i][1]+1);
		}
		
		}
		System.out.println("");
		System.out.print("lignes a barré : ");
		for(int i=0;i<n_o;i++){
			if(X[i][1]>=0){
			System.out.print(" "+X[i][0]+1);
			}
	}
		int min=10000;
		
	for(int z=0;z<n_o;z++){	//System.out.println("1");
	for(int i=0;i<m;i++){//System.out.println("2");
		for(int j=0;j<m;j++){//System.out.println("3");
			if(!exis(X,i,0)){//System.out.println("4");
				if(!exis(Y,j,1)){//System.out.println("5");
					if (M_o[i][j]<min){//System.out.println("6");
						min=M_o[i][j];
					}
					
				}	
			}
			
		}
	}
	}	
		
	for(int z=0;z<n_o;z++){	
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				if(!exis(X,i,0)){
					if(!exis(Y,j,1)){
						M_o[i][j]=M_o[i][j]-min;//System.out.println("6");
							
						
						
					}	
				}
				
			}
		}
		}	
		
	for(int z=0;z<n_o;z++){	
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				if(exis(X,i,0) && exis(Y,j,1)) {
					M_o[i][j]=M_o[i][j]+min;
				}
				
			}
		}
		}	
	System.out.println();
	System.out.println(min);
	for(int i = 0; i < m; ++i)		{    for(int j = 0; j <m; ++j)   {   System.out.print(M_o[i][j] +" | ");  } System.out.println();	}
		
	}
}
