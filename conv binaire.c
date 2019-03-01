 void convertir(int X ){

     int i=0,j,k  ;
    int T[30];
    while(X != 0)
    {
      T[i]=(X%2);
      i++;
        X=X/2;

    }
    for(j=0 ; j<i/2 ; j++){
        k=T[j];
        T[j]=T[i-j-1] ;
        T[i-j-1] = k;
    }
      for(j=0 ; j<i ; j++){
            printf("%d" , T[j]);
            }


}

void main(){

int n;
printf("ENTRER UN NOMBRE ENTIER POSITIVE NON NUL n=  ");
 scanf("%d",&n);
 convertir(n);
}
