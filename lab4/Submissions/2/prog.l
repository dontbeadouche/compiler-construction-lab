%{
	#include<stdio.h>
	int val, even_sum = 0, odd_sum = 0;
%}
digits [+-]?[0-9]+
%%
{digits} {	val = atoi(yytext);
			if(val%2 == 0){
				even_sum += val;
				printf("\nEven : %s", yytext);
			}
			else{
				odd_sum += val;
				printf("\nOdd : %s", yytext);
			}
		}
\n {}
.* {}
%%
int main(int argc, char **argv){
	
	yylex();
	printf("\nEven sum : %d\t Odd sum : %d\n", even_sum, odd_sum);
} 
