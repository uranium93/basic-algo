package benhamida_tp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ForkJoinPool;

import javax.swing.JOptionPane;

public class tp extends Thread{
static final int port = 9999;
public static int n=40;
public static int state_ss;
public static int state_sm;
public static int state_ms;
public static int state_mm;
public static long timesimd;
public static long timemisd;
public static long timemimd;




public static void lettre_gen(int [][] mat,int b){
	
	
	
	for (int i=0;i<b;i++){
		mat[i][0]=(int)(Math.random()*11);
		mat[i][1]=(int)(Math.random()*30000);
		
	}
}
public static void data_dis(int[][] FatherData, int[][] Son1Data, int[][] Son2Data , int b){

	
	for(int i=0 ;i<(b/2);i++){
		Son1Data[i][0]=FatherData[i][0];
		Son1Data[i][1]=FatherData[i][1];
	}
	int x=0;
	for(int j=(b/2) ;j<b;j++){
		Son2Data[x][0]=FatherData[j][0];
		Son2Data[x][1]=FatherData[j][1];
		++x;
	}
	
	
}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		ServerSocket s = new ServerSocket(port);
		 Socket soc = s.accept();
		 ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
	        out.flush();
	 
	      ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
	        
	      
	        
	       // Object objetRecu = in.readObject();
	       // int[] tableauRecu = (int[]) objetRecu;
	        
	        
	       // in.close();
	       
	       
		
	int[][]	M= new int[n][2];
	lettre_gen(M,n);
	for (int i=0;i<n;i++){ System.out.println("lettre de referance :"+M[i][1]+" et de type "+M[i][0] + "   "+i);	 }
	
	System.out.println("execution des 4 differantes architictures ");
	int[][]	Data1= new int[n/2][2];
	int[][]	Data2= new int[n/2][2];
	data_dis(M,Data1,Data2,n);
		

			
	ForkJoinPool pool = new ForkJoinPool();
	
	
		
		
		
	System.out.println("execution avec architicture Single Instruction Single DATA ");
		///sisd ss1 = new sisd(M);
		
		JOptionPane jop2 = new JOptionPane();
	    
		// SISD	
		long startTime = System.nanoTime();
		sisd ss1 = new sisd(M);
		
		ss1.start();
		while (state_ss <1){
			System.out.print("");
		}
		
		long timesisd = System.nanoTime() - startTime;	
		System.out.println("temps d'execution : "+timesisd +" NanoSeconde");
		jop2.showMessageDialog(null,"temps d'execution : "+timesisd +" NanoSeconde", "SISD", JOptionPane.INFORMATION_MESSAGE);
		// FIN SISD
		
		//SIMD
		startTime = System.nanoTime();
		System.out.println("execution avec architicture Single Instruction Multiple DATA ");
		simd1 sm1= new simd1(Data1);
		sm1.start();
		 out.writeObject(Data2);
	        out.flush(); 
	        
	        Object objetRecu_sm = in.readObject();
	        int[][] tableauRecu_sm = (int[][]) objetRecu_sm;
	        int l =tableauRecu_sm.length;
	        
	    	for (int i=0;i<l;i++){
	        System.out.println("message important trouvé avec referance "+tableauRecu_sm[i][1]+" et avec indice de lettre : "+tableauRecu_sm[i][0]+" ");
	      	}
	        
		//simd2 sm2 =new simd2(Data2);
		//pool.execute(sm1);
		//pool.execute(sm2);
		//sm2.start();
		
		while (state_sm <2){
			System.out.print("");
				}
		long timesimd = System.nanoTime() - startTime;		
		jop2.showMessageDialog(null,"temps d'execution : "+timesimd +" NanoSeconde", "SIMD", JOptionPane.INFORMATION_MESSAGE);
		//FIN SIMD
		
		//MISD
		startTime = System.nanoTime();
		System.out.println("temps d'execution : "+timesimd +" NanoSeconde");
		System.out.println("execution avec architicture multiple Instruction Single DATA ");
		misd_1 ms1 = new misd_1(M);
		ms1.start();
		
		
		//misd_2 ms2 = new misd_2(M);
		//ms2.start();
		
		
		while (state_ms <2){
			System.out.print("");
			
		}
		long timemisd = System.nanoTime() - startTime;		
		jop2.showMessageDialog(null,"temps d'execution : "+timemisd +" NanoSeconde", "MISD", JOptionPane.INFORMATION_MESSAGE);
		//FIN MISD
		
		//MIMD
		startTime = System.nanoTime();
		System.out.println("temps d'execution : "+timemisd +" NanoSeconde");
		System.out.println("execution avec architicture multiple Instruction Multiple DATA ");
		mimd_1_1 m11= new mimd_1_1(Data1);
		mimd_1_2 m12= new mimd_1_2(Data2);
		m11.start();
		m12.start();
		
		//mimd_2_1 m21= new mimd_2_1(Data1);
		//mimd_2_2 m22= new mimd_2_2(Data2);
		//m21.start();
		//m22.start();
		
		while(state_mm< 4){
			System.out.print("");
		}
		long timemimd = System.nanoTime() - startTime;		
		jop2.showMessageDialog(null,"temps d'execution : "+timemimd +" NanoSeconde", "MIMD", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("temps d'execution : "+timemimd +" NanoSeconde");
		 soc.close();
	}

}
