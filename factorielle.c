int factorielle( int a){
    int fac=1;
    int i;
if (a <=1 )
return 1;
for (i=a;i>0;i--)

    fac=fac*i;
    return fac;
}
void main () {
int nb, fact, res;
nb = 1;
printf("ENTRER UN NOMBRE :");
scanf("%d", &nb);
res=nb;
fact=factorielle(nb);
printf("La FACTORIELLE DE  %d est : %d", res, fact);
}


