int factorielle(int n)
{
if (n == 1) return 1;
return n*factorielle(n-1);
}
int main (int argc, char *argv[])
{
int a,b;
a = atoi(argv[1]);
b = factorielle(a);
printf("factorielle(%d) = %d\n",a,b);
return 0;
}
