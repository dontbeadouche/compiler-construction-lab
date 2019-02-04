
%{
	#include<stdio.h>
	#include<string.h>
%}
%option yylineno
keyword (if|else|while|do|for|switch|include|case|break|continue|int|float|char)
letter [A-Za-z]
digit [0-9]
digits {digit}+
id {letter}({letter}|{digit})*
char "'"."'"
str \".*\"
fraction ("."{digits})?
exponent ([Ee][+-]?{digits})?
int [+-]?{digits}
float {int}{fraction}{exponent}
operator ("<"|">"|"++"|"--"|"+"|"-"|"*"|"%"|"/")
whitespace [\t\n" "]
%%
{keyword} {printf("%30s %30s %30d\n", yytext, "keyword", yylineno);}
{int} {printf("%30s %30s %30d\n", yytext, "int", yylineno);}
{float} {printf("%30s %30s %30d\n", yytext, "float", yylineno);}
{char} {printf("%30s %30s %30d\n", yytext, "char", yylineno);}
{str} {printf("%30s %30s %30d\n", yytext, "string", yylineno);}
{operator} {printf("%30s %30s %30d\n", yytext, "operator", yylineno);}
{id} {printf("%30s %30s %30d\n", yytext, "identifier", yylineno);}
{whitespace} {}
. {}
%%
	main(int argc, char **argv)
	{
		printf("\n%30s %30s %30s\n\n", "lexeme", "type/pattern", "line no");
		yylex();
		
	}




