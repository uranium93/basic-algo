import java.util.* ;

public class tp_sousi {
public static boolean tr=false;
    public static void main(String[] args) {
        int[][] t = new int[8][4];
        int i,j;
        Random b = new Random();
        for (i=0;i<8;i++) {
            new rang(i,t).start() ;
        };
        for (i=0;i<8;i++) {
            t[i][0] =  b.nextInt(8)+1 ;
            for (j=1;j<4;j++) {
                t[i][j]=0;
            };
        };
        tr=true;
        for (i=0;i<8;i++) {
            new rang(i,t).start() ;
        };
                
        for (i=0;i<8;i++) {
           while (t[i][3]==0) {} ;
        };
        
        for (i=0;i<4;i++) {
            System.out.print("\n");
            for (j=0;j<8;j++) {
                System.out.print(t[j][i]+" ");
            };
        };        
        System.out.print("\n");
    }
}