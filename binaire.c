#include <stdlib.h>
#include <stdio.h>
#define N 32
int main (int argc, char *argv[])
{
int x,a,i,j;
int t[N];
a = atoi(argv[1]);
x = a;
i = 0;
do
{
t[i] = a % 2;
a = a/2;
i++;
}
while (a != 0);
printf("%d = ",x);
for (j = i-1; j>=0; j--)
printf("%d",t[j]);
printf("\n");
return 0;
}
