package benhamida_tp;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class sisd extends tp{

	
	
	
	public sisd(int [][]tab) {
		t=tab;
	}




	

int[][] t;



public void run(){
	ForkJoinPool pool = new ForkJoinPool();
	

	int[][] res_imp = new int[n][2];
	int[][] res_sec = new int[n][2];
	int x=1;
	int y=1;
	
    
  
System.out.println("je suis le processus P_SISD et je suis encours d'execution");
for (int i=0;i<tp.n;i++){
	if (t[i][0]==5){
		res_imp[x][0]=i;
		res_imp[x][1]=t[i][1];
		System.out.println("message important trouv� avec referance : "+res_imp[x][1]+" et avec indice de lettre : "+res_imp[x][0]);
		x=x+1;
		
		
	}
}
for(int i=0;i<tp.n;i++){
	if (t[i][0]==8){
		res_sec[y][1]=t[i][1];
		res_sec[y][0]=i;
		
		System.out.println("message secret trouv� avec referance "+res_sec[y][1]+" et avec indice de lettre : "+res_sec[y][0]);
		y=y+1;
	}
	
}



state_ss=1;	


	
}

}