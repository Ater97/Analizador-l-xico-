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
NewLines        ={Newline}+
WhiteSpace      = [\s\t\r\v\f]

Point           = \.|\?|:|\\

Punctuation     ={Point}|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket}
Constant        ={Booleans}|{Integers}|{Double}|{String}
/*("$"?[0-9]*[a-zA-Z0-9]*)|("=!=")*/

CommentError    = (\/\*)(.)
Errors          = (("\/\*")(\n)*)|(\/\*\n)|(\/\*)({WhiteSpace}|{Newline})*

%{
    public String lexeme;
    public int line;
%}

%%

{reserved_words}    {lexeme = yytext(); line = yyline;return RESERVED_WORD;}
{Constant}          {lexeme = yytext(); line = yyline;return CONSTANT;}
{Identifier}        {lexeme = yytext(); line = yyline;return IDENTIFIER;}

{Comment}           {lexeme = yytext(); line = yyline;return COMMENT;}


{NewLines}          {lexeme = yytext(); line = yyline;return NEWLINES;}
{Newline}           {lexeme = yytext(); line = yyline;return NEWLINE;}
{WhiteSpace}        {lexeme = yytext(); line = yyline;return WHITESPACE;}

{Punctuation}       {lexeme = yytext(); line = yyline;return PUNCTUATION;} 
{Comparison_op}     {lexeme = yytext(); line = yyline;return COMPARISON_OPERATOR;}
{Arithmetic_Op}     {lexeme = yytext(); line = yyline;return ARITHMETIC_OPERATOR;}
{Logical_Op}        {lexeme = yytext(); line = yyline;return LOGICAL_OPERATOR;}

{CommentError}      {lexeme = yytext();line = yyline; return COMMENT_ERROR;}
{Errors}            {lexeme = yytext(); line = yyline; return ERROR;}
.                   {lexeme = yytext(); line = yyline;return ERROR;}