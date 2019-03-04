%{
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
%}
%token NUMBER
%token PLUS MINUS MUL DIV 
%token SEMICOLON ID
/*
  E -> E  E + |  E E *  | NUM  
*/

%%

lines  : lines expr SEMICOLON   
         { 
           printf( "The postfix expr result = %d\n", $2);
           printf( "Pl enter yet another postfix expr ending with ; or <ctrl-d> to quit : ");
         }
       | lines SEMICOLON  
       |   /*epsilon*/    { printf("Pl enter an postfix expr ending with; or <ctrl-d> to quit : ");}    
       ;
expr	: expr expr PLUS { $$ = $1 + $2; }
       | expr expr MUL { $$ = $1 * $2; } 
       | NUMBER { $$ = $1;}
	;

%%
int yyerror(char *msg)
{
  printf("error in input %s\n", msg);
  return 0;
}

int main()
{      
	yyparse();           
}
