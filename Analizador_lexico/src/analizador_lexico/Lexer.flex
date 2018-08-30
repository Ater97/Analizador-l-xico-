package analizador_lexico;

import static analizador_lexico.Token.*;
%%
%class Lexer
%type Token
%line
%column
/*%ignorecase*/


/*Reserved words*/
reserved_words  =void|int|double|bool|string|class|interface|null|this|extends|implements|for|while|if|else|return|break|New|NewArray

/*Operators*/
Comparison_op   = "<"|">"|"<="|">="|"=="|"!="|"==="|"<>"|"<=>"|"??"
/*Arithmetic*/
Arithmetic_Op   = \+|\-|\*|\/|\%|\*\*|"="
/*Logic*/
Logical_Op      = ["and"|"or"|"xor"|"!"|"&&"|\|\|]+

/*Types*/
Booleans        =true|false
Decimal         = [1-9][0-9]*|0
Hexadecimal     = 0[xX][0-9a-fA-F]+
Octal           = 0[0-7]+
Binary          = 0[bB][01]+
Integers        = [+-]?{Decimal}|[+-]?{Hexadecimal}|[+-]?{Octal}|[+-]?{Binary}
Double          = [+-]?([1-9][0-9]*|0)(\.)[0-9]*

/*String          = ('([^(')(\n)(\\')])*')|(\"([^(\")(\n)(\\\")])*\")*/
/*String          =('(.)*')|(\"(.)*\")*/    

/*Vars*/
Basic           = [a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*
var_id          = "$"{Basic}
                                                      
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

Comment         =((\/\/)(.)*)|("\/\*"~"\*\/")|[0-9]*"pt"|(\/\*)(.)*(\*\/)|"/*"([^\*]|\*[^/])"*/"|"/*"(.)"*/"

Newline         = \n
WhiteSpace      = [\s\t\r\v\f]

Point           = \.|\?|:|\\

Punctuation     ={Point}|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket}|[]
Constant        ={Booleans}|{Integers}|{Double}|{String}
/*("$"?[0-9]*[a-zA-Z0-9]*)|("=!=")*/

CommentError    = (\/\*)(.)
Errors          = (("\/\*")(\n)*)|(\/\*\n)|(\/\*)({WhiteSpace}|{Newline})*

%{
    public String lexeme;
%}

%%

{reserved_words}    {lexeme = yytext(); return RESERVED_WORD;}
{Constant}          {lexeme = yytext(); return CONSTANT;}
{Identifier}        {lexeme = yytext(); return IDENTIFIER;}

{Comment}           {lexeme = yytext(); return COMMENT;}


{Newline}           {lexeme = yytext(); return NEWLINE;}
{WhiteSpace}        {lexeme = yytext(); return WHITESPACE;}

{Punctuation}       {lexeme = yytext(); return PUNCTUATION;} 
{Comparison_op}     {lexeme = yytext(); return COMPARISON_OPERATOR;}
{Arithmetic_Op}     {lexeme = yytext(); return ARITHMETIC_OPERATOR;}
{Logical_Op}        {lexeme = yytext(); return LOGICAL_OPERATOR;}

{CommentError}      {lexeme = yytext(); return COMMENT_ERROR;}
{Errors}            {lexeme = yytext(); return ERROR;}
.                   {lexeme = yytext(); return ERROR;}