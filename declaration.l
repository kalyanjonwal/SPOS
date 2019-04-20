%{
#include <stdio.h>
#include "y.tab.h"

%}

DIGIT [0-9]
REAL {DIGIT}+[.]{DIGIT}*
LETTER [a-zA-Z]
ASSIGN =

%%
[ \n\t]+ ;
int {printf("%s\t==> Datatype \n",yytext); return(INT);}
float {printf("%s\t==> Datatype \n",yytext); return(FLOAT);}
char {printf("%s\t==> Datatype \n",yytext); return(CHAR);}
boolean {printf("%s\t==> Datatype \n",yytext); return(BL);}
true|false {printf("%s\t==> Boolean Val\n",yytext); return BLVAL;}
['][^\t\n]['] {printf("%s\t==> Char val\n",yytext); return CHVAL;}
[a-zA-Z]+[a-zA-Z0-9_]* {printf("%s\t==> ID \n",yytext); return ID;}
{REAL} {printf("%s\t==>real number \n",yytext); return REAL;}
{DIGIT}+ {printf("%s\t ==> number \n",yytext); return NUM;}
"," {printf("%s\t ==>COMMA",yytext); return COMMA;}
";" {printf("%s\t ==> SC",yytext); return SC;}
{ASSIGN} {printf("%s\t ==>ASSIGN",yytext); return AS;}
\n return NL;
. ;

%%
int yywrap()
{
return 1;
}

