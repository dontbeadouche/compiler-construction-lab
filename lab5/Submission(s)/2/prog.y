%{
	#include<stdio.h>
	int count_0 = 0, count_1 = 0;
%}
%token ZERO ONE SEMICOLON
%%

lines : lines S SEMICOLON 
		{	
			printf("accepted\n");
			printf("Count_0 = %d, Count_1 = %d\n", count_0, count_1);
			count_0 = count_1 = 0;
		}
		| /*epsilon*/ {}
		| lines error SEMICOLON 
		{ count_0 = count_1 = 0; }
		;

S : ONE A 
	{
		count_1++;
	}
	;
A : ZERO S 
	{
		count_0++;
		
 	}
	| ZERO 
	{ 
		count_0++;
	} 
	| ONE S 
	{	
		count_1++; 
		
	}
	;
%%
int yyerror(char *msg){
	printf("error in input %s\n", msg);
	return 0;
}
int main(){

	yyparse();

}