package src;

import java.util.Random;
import java.util.concurrent.Semaphore;

class process2 extends Thread {

	private static Random rand= new Random();
	private int id;	
	private Semaphore sem;
	public process2(int i,Semaphore s)
	{id=i;
	sem=s;
	}
	private void occuper(){
		
		try {
			sleep(rand.nextInt(1000));//attente de processus
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
			
		
		
	}
	private void critique(){
		System.out.println("Thread "+id+" entrer section critique");
		//affichage
		occuper();
		//blockage
		System.out.println("Thread "+id+" Sortir de la section critique");
		//affichage
	}
	public void run()
	{
		for( int i=0;i<2;i++)// 0 ou 1 
			{
			critique();//enter dans la section critique
		try {
			sem.acquire();// la methode acquire trouve dans la bibliotheque java des semaphores
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		critique();
		sem.release();//la methode release aussi trouve au bibliotheque des semaphores			
		
		}
	}
	
	public static void main(String[] args) 
	{ 
	final int N = 4; 
	System.out.println("Busy waiting…"); 
	//Semaphore(int permits, boolean fair) 
	Semaphore sem = new Semaphore(N, true); 
	process2[] p = new process2[N]; 
	for (int i = 0; i < N; i++) 
	{ 
	p[i] = new process2(i, sem); 
	p[i].start(); 
	}} 
	} 




