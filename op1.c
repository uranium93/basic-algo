main(void){
int op,a,b,res;
printf("Entrer le premier nombre a: ");
scanf("%d",&a);
 printf("Entrer le dexieme nombre b: ");
 scanf("%d",&b);
 printf("le choix des operations\n");
 printf("1. multiplication\n");
 printf("2. addition\n");
 printf("3. soustraction\n");
 printf("4. division\n");
printf("choisir  une operation: ");
	scanf("%d",&op);
	switch(op)
	{
		case 1:
                        res=a*b;
			printf("%d x %d = %d\n",a,b,res);
			break;
		case 2:
                        res=a+b;
			printf("%d + %d = %d\n",a,b,res);
			break;
		case 3:
			res=a-b;
			printf("%d - %d = %d\n",a,b,res);
			break;
		case 4:
			res=a/b;
			printf("%d / %d = %d\n",a,b,res);
			break;
		defalut:
			printf("Opération n'existe pas\n");
	}
        system ("PAUSE");
}

