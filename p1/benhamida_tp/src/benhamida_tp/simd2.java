package benhamida_tp;

import java.util.concurrent.ForkJoinPool;

public class simd2 extends tp{

	public simd2(int[][]tab) {
		
		t=tab;
	}




	int [][] t;

	



	public void run(){
		ForkJoinPool pool = new ForkJoinPool();
		int x=1;
		int y=1;
		int[][]res_imp =new int[n][2];
		int[][]res_sec =new int[n][2];
		System.out.println("je suis le processus P_SIMD(2) et je suis encours d'execution");
	for (int i=0;i<(tp.n)/2;i++){
		if (t[i][0]==5){
			res_imp[x][0]=i;
			res_imp[x][1]=t[i][1];
			System.out.println("message important trouvé avec referance "+res_imp[x][1]+" et avec indice de lettre : "+res_imp[x][0]+" ");
			x=x+1;
		}
	}
	for (int i=0;i<(tp.n)/2;i++){	if (t[i][0]==8){
			res_sec[y][1]=t[i][1];
			res_sec[y][0]=i;
			
			System.out.println("message secret trouvé avec referance "+res_sec[y][1]+" et avec indice de lettre : "+res_sec[y][0]+" ");
			y=y+1;
		}
		
	}
	
	state_sm=state_sm+1;
		
	}




	
	
	
	
}
