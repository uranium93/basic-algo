import java.util.concurrent.Semaphore;

public class Main {

	static final int threadsNum = 6;
	static Semaphore sem = new Semaphore(1);

	public static void main(String[] args) {
		listeSyncro[] threads = new listeSyncro[threadsNum];
		threads[threads.length - 1] = new listeSyncro(0, null, threads.length - 1);
		
		//for (int i = threads.length - 2; i >= 0; i--) threads[i] = new listeSyncro(1, threads[i + 1], i);
		listeSyncro threads0=new listeSyncro(0,1);
		listeSyncro threads1=new listeSyncro(1,threads1, 2);
		listeSyncro threads2=new listeSyncro(3);
		listeSyncro threads3=new listeSyncro(4);
		listeSyncro threads4=new listeSyncro(5);

		for (int i = 0; i < threads.length; i++) threads[i].start();
		try {
			sem.acquire(threadsNum);
		}
		catch (InterruptedException interruptedException) {
		}
		for (int i = 0; i < threads.length; i++) System.out.println("Thead " + i + " terminé, valeur finale = " + threads[i].val);
	}
}
