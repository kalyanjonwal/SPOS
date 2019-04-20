%{
#include<stdio.h>
void yyerror(char*);

int yylex();
%}
%token ID SC INT CHAR FLOAT BL BLVAL CHVAL REAL AS NUM COMMA NL

%%
s:type1|type2|type3|type4
;
type1: INT varlist SC NL {printf("valid int variable declaration"); return 0;}
;
type2: FLOAT varlist2 SC NL {printf("valid float variable declaration"); return 0;}
;
type3: CHAR varlist3 SC NL {printf("valid char variable declaration"); return 0;}
;
type4: BL varlist4 SC NL {printf("valid boolean declaration"); return 0;}
;

varlist: ID | ID COMMA varlist | ID AS NUM |ID AS NUM COMMA varlist |
;
varlist2: ID | ID COMMA varlist2 | ID AS REAL | ID AS REAL COMMA varlist2 |
;
varlist3: ID | ID COMMA varlist3 | ID AS CHVAL | ID AS CHVAL COMMA varlist3 |
;
varlist4: ID | ID COMMA varlist4 | ID AS BLVAL | ID AS BLVAL COMMA varlist4 |
;

%%
void yyerror(char *s)
{
	fprintf(stderr,"ERROR %s \n",s);
}
int main()
{
	//yyin=fopen("input.txt","r");
	yyparse();
//fclose(yyin);
	return 0;

}
