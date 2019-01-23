package benhamida_tp;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class mimd_1_1 extends tp{
	public mimd_1_1(int tab[][]) {
		t=tab;
	}




	


int[][] t;



public void run(){
	
     
	
	int[][] res_imp = new int[n][2];

	int x=1;
	
System.out.println("je suis le processus P_MIMD(1) et je suis encours d'execution");
for (int i=0;i<(tp.n)/2;i++){
	if (t[i][0]==5){
		res_imp[x][0]=i;
		res_imp[x][1]=t[i][1];
		System.out.println("message important trouvé avec referance : "+res_imp[x][1]+" et avec indice de lettre : "+res_imp[x][0]);
		x=x+1;
		
		
	}
	
}
	

state_mm=state_mm+1;	

}




}
