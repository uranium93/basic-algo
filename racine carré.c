#include <stdio.h>
void main() {
     double A,B,M,X;
     printf("svp entrer la valeur pour calculer la racine carre .");
     scanf("%lf",&X);
  if(X==0.0) {
     X= 0.0;
  } else {
     M=1.0;

     while(X>=2.0) {
        X=0.25*X;
        M=2.0*M;
     }
     while(X<0.5) {
        X=4.0*X;
        M=0.5*M;
     }
     B=1.0-X;
     do {
        X=X*(1.0+0.5*B);
        B=0.25*(3.0+B)*B*B;
     } while(B>=1.0E-15);
     X= X*M;
  }

            printf("La racine carre est : %lf",X);

}
