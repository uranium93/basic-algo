long fact (short nombre) {

	short indice;
	long factorielle = 1; // pour stocker le resultat

	if (nombre == 0) // cas particulier ou il n'y a rien a calculer
		return 1;

	for(indice = nombre ; indice > 0; indice--)
		factorielle = factorielle * indice;

	return factorielle;
}

int main(void)
{
int nombre_lu;

	printf("De quel nombre souhaitez-vous la factorielle ? ");
	if(scanf("%d", &nombre_lu) != 1){
	    printf("erreur de saisie\n");
	    exit(1);
	}
	while (nombre_lu != -1)
	{
	    printf("Factorielle (%d) = %ld\n", nombre_lu, fact(nombre_lu));
	    printf("De quel nombre souhaitez-vous la factorielle ? ");
            if(scanf("%d", &nombre_lu) != 1){
	      printf("erreur de saisie\n");
	      exit(1);
	    }
	}

  return 0;
}
