
import java.util.concurrent.Semaphore;

public class listeSyncro extends Thread {

	public int val;
	public listeSyncro suivant;
	public Semaphore synch = new Semaphore(0);
	public int index;

	public listeSyncro(int index) {
		this.index = index;
		this.start();
	}

	public void run() {
		if (index == MainClass.threadsNum - 1) {
			this.val = 0;
			this.suivant = null;
		}
		else {
			this.val = 1;
			this.suivant = MainClass.threads[index + 1];
		}
		synch.release();
		while (suivant != null) {
			try {
				synch.acquire();
				if (suivant != null) suivant.synch.acquire();
			}
			catch (InterruptedException interruptedException) {
			}
			val += suivant.val;
			listeSyncro suivTemp = suivant;
			suivant = suivant.suivant;
			synch.release();
			if (suivTemp != null) suivTemp.synch.release();
		}
		MainClass.sem.release();
	}
}
