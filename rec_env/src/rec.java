
public  class rec extends Thread{
	int inf;

	synchronized void syn() throws InterruptedException{
		
	
	if (fax.tr1 && fax.tr2 && fax.tr3){
	wait();
	notifyAll();
	}
		
	}
	
	public void run (){
		
		for(int i=0; i<4;i++){
			try {
				syn();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(" je suis le recepteur et je m appele : clien");

		inf = fax.t1;
		System.out.println(" reception du message n 01 qui contien l'information :"+ inf);
		fax.tr1=true;
		inf = fax.t2;
		System.out.println(" reception du message n 02 qui contien l'information :"+ inf);
		fax.tr2=true;
		inf = fax.t3;
		System.out.println(" reception du message n 03 qui contien l'information :"+ inf);
		fax.tr3=true;
		}
		
	}
	
}
