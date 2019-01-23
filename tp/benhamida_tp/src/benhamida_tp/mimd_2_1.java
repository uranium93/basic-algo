package benhamida_tp;

import java.util.concurrent.ForkJoinPool;

public class mimd_2_1 extends tp{
	public mimd_2_1(int tab[][]) {
		t=tab;
	}





int[][] t;



public void run(){
	ForkJoinPool pool = new ForkJoinPool();
	
	int[][] res_sec = new int[n][2];
	
	int y=1;
	
System.out.println("je suis le processus P_MIMD(3) et je suis encours d'execution");
for (int i=0;i<(tp.n)/2;i++){
	
	if (t[i][0]==8){
		res_sec[y][1]=t[i][1];
		res_sec[y][0]=i;
		
		System.out.println("message secret trouvé avec referance "+res_sec[y][1]+" et avec indice de lettre : "+res_sec[y][0]);
		y=y+1;
	}
	
}
	
	
state_mm=state_mm+1;	
}




}
