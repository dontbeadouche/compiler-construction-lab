%{
	#include<stdio.h>
	int vowels = 0, consonents = 0;
%}
vowel [aeiouAEIOU]
consonent [a-zA-Z]
%%
{vowel} {vowels++;}
{consonent} {consonents++;}
\n {}
. {}
%%
int main(int argc, char **argv){
	yylex();
	printf("\nVowel count : %d\t Consonent count : %d\n", vowels, consonents);
}