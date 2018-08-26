package analizador_lexico;

import static analizador_lexico.Token.*;
%%
%class Lexer
%type Token
%line
%column
%ignorecase

/*letters */
a = [aA]
b = [bB]
c = [cC]
d = [dD]
e = [eE]
f = [fF]
g = [gG]
h = [hH]
i = [iI]
j = [jJ]
k = [kK]
l = [lL]
m = [mM]
n = [nN]
o = [oO]
p = [pP]
q = [qQ]
r = [rR]
s = [sS]
t = [tT]
u = [uU]
v = [vV]
w = [wW]
x = [xX]
y = [yY]
z = [zZ]

/*Reserved words*/
/*reserved_words  = __halt_compiler|abstract|and|array|as|callable|catch|class|clone|const|declare|default|do|empty|enddeclare|endfor|endforeach|endswitch|endwhile|eval|exit|extends|final|global|implements|instanceof|insteadof|interface|isset|list|namespace|new|print|private|protected|public|require|static|throw|trait|try|unset|use|var*/
reserved_words  = void|int|double|bool|string|class|interface|null|this|extends|implements|for|while|if|else|return|break|New|NewArray

/*Operators*/
Comparison_op   = "<"|">"|"<="|">="|"=="|"!="|"==="|"<>"|"<=>"|"??"
/*Arithmetic*/
Arithmetic_Op   = \+|\-|\*|\/|\%|\*\*|"="
/*Logic*/
Logical_Op      = ["and"|"or"|"xor"|"!"|"&&"|\|\|]+

/*Types*/
/*Logic*/
Booleans        = {t}{r}{u}{e}|{f}{a}{l}{s}{e}
/*Integers*/
Decimal         = [1-9][0-9]*|0
Hexadecimal     = 0[xX][0-9a-fA-F]+
Octal           = 0[0-7]+
Binary          = 0[bB][01]+
Integers        = [+-]?{Decimal}|[+-]?{Hexadecimal}|[+-]?{Octal}|[+-]?{Binary}
Double          = [+-]?([1-9][0-9]*|0)(\.)[0-9]*
/*Strings*/
/*String          = ('([^(')(\n)(\\')])*')|(\"([^(\")(\n)(\\\")])*\")*/
String          =('(.)*')|(\"(.)*\")

/*Vars*/
Basic           = [a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*
var_id          = "$"{Basic}
                                                      
/*Control structures*/
/*control_struct  = ({i}{f}|{e}{l}{s}{e}|{e}{l}{s}{e}{i}{f}|{e}{n}{d}{i}{f}|{w}{h}{i}{l}{e}|{d}{o}|{f}{o}{r}|{f}{o}{r}{e}{a}{c}{h}|{b}{r}{e}{a}{k}|{s}{w}{i}{t}{c}{h}|{c}{a}{s}{e}|{c}{o}{n}{t}{i}{n}{u}{e}|{r}{e}{t}{u}{r}{n}|{i}{n}{c}{l}{u}{d}{e}|{g}{o}{t}{o}|require_once|include_once|{f}{u}{n}{c}{t}{i}{o}{n}|{e}{c}{h}{o}|{d}{i}{e})*/
Semicolon       = ;
Comma           = ,
Parenthesis     = \(|\)
Brace           = \[|\]
Bracket         = [\{|\}]*
String          =('(.|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket})*')|(\"(.|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket})*\")


/*Functions*/
Function = function
/*Floating point numbers*/
Lnum            = [0-9]+ 
Dnum            = ([0-9]*[\.]{Lnum}) | ({Lnum}[\.][0-9]*)
Exponent_Dnum   = [+-]?(({Lnum} | {Dnum}) [eE][+-]? {Lnum})



Identifier      = ((_)*)?[a-zA-Z][a-zA-Z0-9_]*

Comment         =((\/\/)(.)*)|("\/\*"~"\*\/")|[0-9]*"pt"

Newline         = \n
WhiteSpace      = [\s\t\r\v\f]

Point           = \.|\?|:|\\|\"

Constant        = {Booleans}|{Integers}|{Double}|{String}
Errors          = ("$"?[0-9]*[a-zA-Z0-9]*)|(("\/\*")(\n)*)|("=!=")|(\/\*\n)
%{
    public String lexeme;
%}

%%
/*{control_struct}    {lexeme = yytext(); return CONTROL_STRUCTURE;}*/

{Comment}           {lexeme = yytext(); return COMMENT;}
{Constant}          {lexeme = yytext(); return CONSTANT;}

{Newline}           {lexeme = yytext(); return NEWLINE;}
{WhiteSpace}        {lexeme = yytext(); return WHITESPACE;}
{Bracket}           {lexeme = yytext(); return BRACKET;}

{Parenthesis}       {lexeme = yytext(); return PARENTHESIS;}
{Brace}             {lexeme = yytext(); return BRACE;}
{reserved_words}    {lexeme = yytext(); return RESERVED_WORD;}


{Comparison_op}     {lexeme = yytext(); return COMPARISON_OPERATOR;}
{Arithmetic_Op}     {lexeme = yytext(); return ARITHMETIC_OPERATOR;}
{Logical_Op}        {lexeme = yytext(); return LOGICAL_OPERATOR;}


{Exponent_Dnum}     {lexeme = yytext(); return FLOATING_POINT_NUM;}

{Identifier}        {lexeme = yytext(); return IDENTIFIER;}

{var_id }           {lexeme = yytext(); return VARIABLE_ID;}

{Semicolon}         {lexeme = yytext(); return SEMICOLON;}
{Comma}             {lexeme = yytext(); return COMMA;}
{Point}             {lexeme = yytext(); return POINT;}

{Errors}            {lexeme = yytext(); return ERROR;}
.                   {lexeme = yytext(); return ERROR;}
