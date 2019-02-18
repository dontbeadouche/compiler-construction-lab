%{
	#include<stdio.h>
%}
lower [a-z]
upper [A-Z]
%%
{lower} { printf("%c", *yytext-32);}
{upper} { printf("%c", *yytext+32);}

%%
int main(int argc, char **argv){	
	yylex();
} 