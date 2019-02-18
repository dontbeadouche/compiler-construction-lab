%{
#include <stdio.h>
#include <stdlib.h>
%}
digit    [0-9]
digits {digit}+
%%
{digits}  return atoi(yytext);
\n {}
.* {}
%%
int main(int argc, char **argv)
{
   	int val, n = 0;
   	float sum = 0.0;
	while ( (val = yylex()) > 0 ) {
		sum += val;
		n++;
   }
   	if (n > 0){
   		float avg = sum/n;
   		printf("average = %f\n", avg);
   	}
}