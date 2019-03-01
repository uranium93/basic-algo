int main ()
{
	long a = 0;
	long b = 0;
	long resultat = 0;

	/* \t équivaut à une tabulation */
	printf("Ce programme multiplier 2 nombres entiers !!!\n");
	printf("Entrez le premier nombre svp : ");
	scanf("%ld", &a);
	printf("Deuxieme nombre svp : ");
	scanf("%ld", &b);
	resultat = a * b;
	printf("\nResultat : %ld", resultat);
	return 0;

}

