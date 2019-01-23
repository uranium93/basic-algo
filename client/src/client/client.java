package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ForkJoinPool;

public class client extends Thread{
	public static int n=40;
	static final String serverName = "localhost";
    static final int serverPort = 9999;
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		Socket socket = new Socket(serverName, serverPort);
      
 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
 
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
 
        
 
       
 
        
      
		
        Object objetRecu = in.readObject();
        int[][] t_sm = (int[][]) objetRecu;
        in.close();
        
		//simd
		ForkJoinPool pool = new ForkJoinPool();
		int x=1;
		int y=1;
		int[][]res_imp_simd =new int[n][2];
		int[][]res_sec_simd =new int[n][2];
		System.out.println("je suis le processus P_SIMD(2) et je suis encours d'execution");
	for (int i=0;i<(client.n)/2;i++){
		if (t_sm[i][0]==5){
			res_imp_simd[x][0]=i;
			res_imp_simd[x][1]=t_sm[i][1];
			x=x+1;
		}
	}
	for (int i=0;i<(n)/2;i++){	
		if (t_sm[i][0]==8){
			res_sec_simd[y][1]=t_sm[i][1];
			res_sec_simd[y][0]=i;
			y=y+1;
		}
		
	}
		
	out.writeObject(res_sec_simd);
    out.flush();

  
    out.close();
	
	
socket.close();
		
	}

}
