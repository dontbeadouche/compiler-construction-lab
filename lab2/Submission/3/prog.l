%{
	#include<stdio.h>
%}
digit [0-9]
digits {digit}+
fraction ("."{digits})?
exponent (E[+-]?{digits})?
number {digits}{fraction}{exponent}
%%
{number} { printf("Number Recognized : %s\n", yytext);}
.* { printf("Not Recognized : %s\n", yytext);}
%%
	main(int argc, char **argv){
		yylex();
	}
