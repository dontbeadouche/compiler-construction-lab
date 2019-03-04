%{
	#include<stdio.h>
%}
%token NUMBER PLUS MINUS MUL DIV SEMICOLON
%%

lines : lines expr SEMICOLON 
			{
				printf("The prefix expression result = %d\n", $2);
			}
			| /*epsilon*/ 
			{
			}
		;
expr : PLUS expr expr { $$ = $2 + $3; }
		| MINUS expr expr { $$ = $2 - $3; }
		| MUL expr expr { $$ = $2 * $3; }
		| DIV expr expr { $$ = $2 / $3; }
		| NUMBER { $$ = $1; }
	;
%%
int yyerror(char *msg){
	printf("error in input %s\n", msg);
	return 0;
}

int main(){
	yyparse();
}