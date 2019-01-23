package benhamida_tp;

import java.util.concurrent.ForkJoinPool;

public class misd_1 extends tp{
	
	public misd_1(int tab[][]) {
		t=tab;
	}




	






int[][] t;



public void run(){
	ForkJoinPool pool = new ForkJoinPool();
	int[][] res_imp = new int[n][2];

	int x=1;

	
System.out.println("je suis le processus P_MISD(1) et je suis encours d'execution");
for (int i=0;i<tp.n;i++){
	if (t[i][0]==5){
		res_imp[x][0]=i;
		res_imp[x][1]=t[i][1];
		System.out.println("message important trouvé avec referance : "+res_imp[x][1]+" et avec indice de lettre : "+res_imp[x][0]);
		x=x+1;
		
		
	}
	
	state_ms=state_ms+1;
}
	

	
}

	
	
	
	
	
	
	

}
