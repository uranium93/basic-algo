package benhamida_tp;




public class sisd extends tp{

	
	
	
	public sisd(int [][]tab) {
		t=tab;
	}




	

int[][] t;



public void run(){
	

	
	
    
  
System.out.println("je suis le processus P_SISD et je suis encours d'execution");
for (int i=0;i<tp.n;i++){
	if (t[i][0]==5){
		
		System.out.println("message important trouvé avec referance : "+t[i][1]+" et avec indice de lettre : "+t[i][0]);
	
		
		
	}

//for(int j=0;j<tp.n;j++){
	if (t[i][0]==8){
		
		
		System.out.println("message secret trouvé avec referance "+t[i][1]+" et avec indice de lettre : "+t[i][0]);
		
	}
	
//}

}

state_ss=1;	


	
}

}
