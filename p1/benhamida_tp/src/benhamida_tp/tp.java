package benhamida_tp;

import java.util.concurrent.ForkJoinPool;

import javax.swing.JOptionPane;

public class tp extends Thread{
public static int n=1000;
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
	public static void main(String[] args) {
			
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
		
		//sisd system = new sisd(M);
		long startTime = System.nanoTime();
		System.out.println("je suis le processus P_SISD et je suis encours d'execution");
		for (int i=0;i<n;i++){
			if (M[i][0]==5){
				
				System.out.println("message important trouvé avec referance : "+M[i][1]+" et avec indice de lettre : "+M[i][0]);
			
				
				
			}else if (M[i][0]==8){
				
				
				System.out.println("message secret trouvé avec referance "+M[i][1]+" et avec indice de lettre : "+M[i][0]);
				
			}

		for(int j=0;j<tp.n;j++){
			if (M[i][0]==8){
				
				
				System.out.print("");
				
			}
			
		}

		}
		//pool.execute(system);
		//ss1.start();
		//while (state_ss <1){
			//System.out.print("");
		//}
		
		long timesisd = (System.nanoTime() - startTime)/100000;	
		System.out.println("temps d'execution SISD : "+timesisd +" MilliSeconde");
		jop2.showMessageDialog(null,"temps d'execution SISD : "+timesisd +" MilliSeconde", "SISD", JOptionPane.INFORMATION_MESSAGE);
		// FIN SISD
		
		//SIMD
		startTime = System.nanoTime();
		System.out.println("execution avec architicture Single Instruction Multiple DATA ");
		simd1 sm1= new simd1(Data1);
		simd2 sm2 =new simd2(Data2);
		pool.execute(sm1);
		pool.execute(sm2);
		//sm1.start();
		//sm2.start();
		
		while (state_sm <2){
			System.out.print("");
				}
		long timesimd = (System.nanoTime() - startTime)/100000;	
		System.out.println("temps d'execution SIMD : "+timesimd +" MilliSeconde");
		jop2.showMessageDialog(null,"temps d'execution SIMD : "+timesimd +" MilliSeconde", "SIMD", JOptionPane.INFORMATION_MESSAGE);
		//FIN SIMD
		
		//MISD
		startTime = System.nanoTime();
		
		System.out.println("execution avec architicture multiple Instruction Single DATA ");
		misd_1 ms1 = new misd_1(M);
		misd_2 ms2 = new misd_2(M);
		//ms1.start();
		//ms2.start();
		pool.execute(ms1);
		pool.execute(ms2);
		while (state_ms <2){
			System.out.print("");
			
		}
		long timemisd = (System.nanoTime() - startTime)/100000;		
		System.out.println("temps d'execution MISD : "+timemisd +" MilliSeconde");
		jop2.showMessageDialog(null,"temps d'execution MISD : "+timemisd +" MilliSeconde", "MISD", JOptionPane.INFORMATION_MESSAGE);
		//FIN MISD
		
		//MIMD
		startTime = System.nanoTime();
		
		System.out.println("execution avec architicture multiple Instruction Multiple DATA ");
		mimd_1_1 m11= new mimd_1_1(Data1);
		mimd_1_2 m12= new mimd_1_2(Data2);
		mimd_2_1 m21= new mimd_2_1(Data1);
		mimd_2_2 m22= new mimd_2_2(Data2);
		//m11.start();
		//m12.start();
		//m21.start();
		//m22.start();
		pool.execute(m11);
		pool.execute(m22);
		pool.execute(m12);
		pool.execute(m21);
		while(state_mm< 4){
			System.out.print("");
		}
		long timemimd = (System.nanoTime() - startTime)/100000;		
		jop2.showMessageDialog(null,"temps d'execution MIMD : "+timemimd +" MilliSeconde", "MIMD", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("temps d'execution MIMD : "+timemimd +" MilliSeconde");

	}

}
