
public class env extends Thread{
	int inf;
	synchronized void synn() throws InterruptedException{
		if (fax.tr1==false && fax.tr2==false && fax.tr3==false){
			wait();
			notifyAll();
			
		}
	}
	public void run (){
	
		for(int i=0; i<2;i++){
			try {
				synn();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	System.out.println(" je suis emmeteur et je m appele : entreprise");

	inf = (int) (Math.random()*101);
	System.out.println(" envoi du message n 01 qui contien l'information :"+ inf);
	fax.t1= inf;
	fax.tr1=false;
	inf = (int) (Math.random()*101);
	System.out.println(" envoi du message n 02 qui contien l'information :"+ inf);
	fax.t2= inf;
	fax.tr2=false;
	inf = (int) (Math.random()*101);
	System.out.println(" envoi du message n 03 qui contien l'information :"+ inf);
	fax.t3= inf;
	fax.tr3=false;

		}
		
}

	

	
}
