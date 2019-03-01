
/* 

   TP de progammation numero 9.
   26 avril 2007.

   Exercice sur les tableaux dynamiques.

   En-tête tab.h correspondant au fichier tab.c à programmer.

 */


/* Type des tableaux grossissant */
struct tab {
  char* mem; /* bloc de mémoire alloué par malloc */
  int   max; /* taille allouée pour mem */
  int   nb;  /* nombre de char effectivement utilisés dans mem */
};


struct tab* cree_tab();

void        detruit_tab(struct tab* t);

void        ajoute_char(struct tab* t, char c);

void        ajoute_string(struct tab* t, char* s);

void        vide_tab(struct tab* t);

void        affiche_tab(struct tab* t);
