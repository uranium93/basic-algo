
import java.util.concurrent.Semaphore;

public class MainClass {

	static final int threadsNum = 5;
	static Semaphore sem = new Semaphore(1);
	static listeSyncro[] threads = new listeSyncro[threadsNum];

	public static void main(String[] args) {
		for (int i = threads.length - 1; i >= 0; i--) {
			threads[i] = new listeSyncro(i);
		}
		try {
			sem.acquire(threadsNum);
		}
		catch (InterruptedException interruptedException) {
		}
		for (int i = 0; i < threads.length; i++) System.out.println("Thead " + i + " terminé, valeur finale = " + threads[i].val);
	}
}
