int main ()
{
	long x = 0;
	long y = 0;
	long resultat = 0;

	/* \t équivaut à une tabulation */
	printf("Ce programme soustractionne 2 nombres entiers !!!\n");
	printf("Entrez le premier nombre svp : ");
	scanf("%ld", &x);
	printf("Deuxieme nombre svp : ");
	scanf("%ld", &y);
	resultat = x -y;
	printf("\nResultat : %ld", resultat);
	return 0;

}

