package ha;


import java.util.concurrent.*; 
interface ProdConsInterface { 
public void Deposer(int m) throws InterruptedException ; 
public int Prelever() throws InterruptedException ;
} 
class ProdConsSem implements ProdConsInterface { 
Semaphore SVide, SPlein; 
int tampon[]; 
int queue,tete, N; 
ProdConsSem (int taille) { 
N=taille ; 
tampon = new int [N] ; 
SVide=new Semaphore (N, true); 
SPlein=new Semaphore(0,true);  }
public void Deposer (int m) throws InterruptedException { 
SVide.acquire(); 
tampon[queue] =m ; 
queue = (queue +1)% N; 
System.out.println(Thread.currentThread().getName() + 
" vient de produire " + m) ; 
SPlein.release();  } 
public int Prelever () throws InterruptedException { 
SPlein.acquire(); 
int m= tampon[tete]; 
tete = (tete + 1)% N; 
System.out.println(Thread.currentThread().getName() + 
" vient de consommer " + m) ; 
SVide.release(); 
return m ; } 
} 
// fin de ProdConsSem

class Producteur extends Thread { 
ProdConsSem Sem; 
Producteur ( ProdConsSem Sem ) { this.Sem=Sem;} 
public void run() { 
try { while (true) { 
int m= (int)(1000*Math.random()); 
Sem.Deposer(m) ; 
Thread.sleep((int)(1000*Math.random())); } 
} catch(InterruptedException e) {} 
}// fin run 
} // fin de la classe Producteur

class Consommateur extends Thread { 
ProdConsSem Sem; 
Consommateur (ProdConsSem Sem) { 
this.Sem=Sem; } 
public void run() { 
try { 
while (true) { 
int m = Sem.Prelever() ; 
Thread.sleep((int)(1000*Math.random())); } 
} catch(InterruptedException e) {} 
} // fin run 
} // fin de la classe Consommateur
//La classe main : à exécuter avec un argument = taille du tampon 
class ProdConsMain { 
public static void main (String argv[]) { 
int N=5; 
ProdConsSem pc = new ProdConsSem(N) ; 
Producteur producteur = new Producteur (pc) ; 
Consommateur consommateur = new Consommateur (pc) ; 
producteur.setName("Producteur") ; 
producteur.start() ; 
consommateur.setName("Consommateur") ; 
consommateur.start() ;} 
}
