public class rang extends Thread {

    int n,i;
    int a[][];
    
    rang(int position,int tab[][]) {
      n = position;
      a=tab;
    }

    public void run() {
      int i,j;
       while(tp_sousi.tr==false) {
    	   
       };
      for (i=1;i<=3;i++) {
        j = (int) (n-Math.pow(2,i-1));
        if (j>=0) { 
          while (a[j][i-1]==0) {} ; 
          a[n][i] = a[n][i-1]+a[j][i-1] ; 
          } else {
        a[n][i] = a[n][i-1] ;
      };
    };
  }
    
    }