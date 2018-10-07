package analizador_lexico;

import java_cup.runtime.Symbol;

%%
/*%class Lexer*/
%line
%column
%cup
%cupdebug 

/*Reserved words*/
reserved_words  = void|Void|int|double|bool|string|class|interface|null|this|extends|implements|for|while|if|else|return|break|New|NewArray|Print|ReadInteger|ReadLine|Malloc 

/*Operators*/
/*  (, ), +, -, *, /, %, <, <=, >, >=, ==, !=, &&, ||, !  */

Comparison_op   = "<"|">"|"<="|">="|"=="|"!="|"||" 
 
/*  |"==="|"<>"|"<=>"|"??"   */
/*Arithmetic*/
Equal           = "="
Negation        = "!"|"-"
Arithmetic_Op   = \+|\-|\*|\/|\%|"="
/*Logic*/
Logical_Op      = ["and"|"or"|"xor"|"!"|"&&"|\|\|]+

/*Types*/
Booleans        =true|false
Decimal         = [1-9][0-9]*|0
Hexadecimal     = 0[xX][0-9a-fA-F]+
Octal           = 0[0-7]+
Binary          = 0[bB][01]+
Integers        = [+-]?{Decimal}|[+-]?{Hexadecimal}|[+-]?{Octal}|[+-]?{Binary}
Double          = [+-]?([1-9][0-9]*|0)(\.)[0-9]*|{Exponent_Dnum}|[+-]?(({Lnum}|{Dnum})\.[eE][+-]? {Lnum})

/*String          = ('([^(')(\n)(\\')])*')|(\"([^(\")(\n)(\\\")])*\")*/
/*String          =('(.)*')|(\"(.)*\")*/    

/*Vars*/
Basic           = [a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*
var_id          = "$"{Basic}
               
Point           = \.                                       
Semicolon       = ;
Comma           = ,
RightParenthesis= \)
LeftParenthesis = \(
Parenthesis     = {LeftParenthesis}|{RightParenthesis}
RightBrace      = \]
LeftBrace       = \[
Brace           = {LeftBrace}|{RightBrace}
RightBracket    = \}
LeftBracket     = \{
Bracket         = {LeftBracket}|{RightBracket}
String          =('(.|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket}|{Point})*')|(\"(.|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket})*\")


/*Functions*/
Function = function
/*Floating point numbers*/
Lnum            = [0-9]+ 
Dnum            = ([0-9]*[\.]{Lnum}) | ({Lnum}[\.][0-9]*)
Exponent_Dnum   = [+-]?(({Lnum} | {Dnum}) [eE][+-]? {Lnum})



Identifier      = ((_)*)?[a-zA-Z][a-zA-Z0-9_]*

Comment         =((\/\/)(.)*)|("\/\*"~"\*\/")|[0-9]*"pt"|(\/\*)(.)*(\*\/)|"/*"([^\*]|\*[^/])"*/"|"/*"(.)"*/"

Newline         = \n
NewLines        ={Newline}+|{Newline}({Newline}|{WhiteSpace}|" ")*
WhiteSpace      = [\s\t\r\v\f]

Point           = \.|\?|:|\\

Punctuation     ={Point}|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket}|"[]"|"{}"|"()"
Constant        ={Booleans}|{Integers}|{Double}|{String}
/*("$"?[0-9]*[a-zA-Z0-9]*)|("=!=")*/

CommentError    = (\/\*)(.)
Errors          = (("\/\*")(\n)*)|(\/\*\n)|(\/\*)({WhiteSpace}|{Newline})*

%{
    public String lexeme;
    public int line;
%}

%%

{reserved_words}    {lexeme = yytext(); line = yyline;return new Symbol(sym.reserved_word);} 
{Identifier}        {lexeme = yytext(); line = yyline;return new Symbol(sym.Identifier);} 

/*{Comment}           {lexeme = yytext(); line = yyline;return new Symbol(sym.Comment);)*/

{Integers}          {lexeme=yytext(); return new Symbol(sym.Integers);}
{Double}            {lexeme=yytext(); return new Symbol(sym.Double);}
{String}            {lexeme=yytext(); return new Symbol(sym.String);}

/*{Constant}          {lexeme = yytext(); line = yyline;return CONSTANT;}*/

{NewLines}          {lexeme = yytext(); line = yyline;return new Symbol(sym.NewLines);}
{Newline}           {lexeme = yytext(); line = yyline;return new Symbol(sym.NewLine);}
/*{WhiteSpace}        {lexeme = yytext(); line = yyline;return WHITESPACE;}*/

{Punctuation}       {lexeme = yytext(); line = yyline;return new Symbol(sym.Punctuation);}
{Comparison_op}     {lexeme = yytext(); line = yyline;return new Symbol(sym.Comparison_op);}
{Arithmetic_Op}     {lexeme = yytext(); line = yyline;return new Symbol(sym.Arithmetic_op);}
{Logical_Op}        {lexeme = yytext(); line = yyline;return new Symbol(sym.Logical_Op);}

{LeftParenthesis}   {lexeme = yytext(); line = yyline;return new Symbol(sym.LeftParenthesis);}
{RightParenthesis}  {lexeme = yytext(); line = yyline;return new Symbol(sym.RightParenthesis);}
{LeftBrace}         {lexeme = yytext(); line = yyline;return new Symbol(sym.LeftBrace);}
{RightBrace}        {lexeme = yytext(); line = yyline;return new Symbol(sym.RightBrace);}
{LeftBracket}       {lexeme = yytext(); line = yyline;return new Symbol(sym.LeftBracket);}
{RightBracket}      {lexeme = yytext(); line = yyline;return new Symbol(sym.RightBracket);}

{CommentError}      {lexeme = yytext();line = yyline; return new Symbol(sym.CommentError);}
{Errors}            {lexeme = yytext(); line = yyline; return new Symbol(sym.Errors);}
/*.                   {lexeme = yytext(); line = yyline;return ERROR;}*/