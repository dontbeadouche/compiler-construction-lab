%{
#include <stdio.h>
#include "y.tab.h"
int yylval;
%}
delim [ \t\n]
ws {delim}+
digit	[0-9]
number {digit}+
letter [a-zA-Z]
letter_ [letter_]
id {letter_}({letter_}|{digit})*
%%
{ws}	{}
"+"	{return PLUS;}
"-"	{return MINUS;}
"*"	{return MUL;}
"/"	{return DIV;}
{id} 	{ return ID;}
";" {return SEMICOLON;}
{number} {yylval = atoi(yytext); return NUMBER;}
. { printf ("yylex:error:%s:\n", yytext);}
%%
