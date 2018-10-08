package analizador_lexico;

import java_cup.runtime.Symbol;

%%
%class Lexer
%line
%column
%cup
%cupdebug 


/*Reserved words*/
/*reserved_words  = void|Void|int|double|bool|string|class|interface|null|this|extends|implements|for|while|if|else|return|break|New|NewArray|Print|ReadInteger|ReadLine|Malloc */

/*Operators*/
/*  (, ), +, -, *, /, %, <, <=, >, >=, ==, !=, &&, ||, !  */

Comparison_op   = "<"|">"|"<="|">="|"=="|"!="|"||" 
 
/*  |"==="|"<>"|"<=>"|"??"   */
/*Arithmetic*/
Equal           = "="
Negation        = "!"|"-"
Arithmetic_Op   = \+|\-|\*|\/|\%|"="
/*Logic*/
/*Logical_Op      = ["and"|"or"|"xor"|"!"|"&&"|\|\|]+*/

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
/*Basic           = [a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*
var_id          = "$"{Basic}*/
               
Point           = \.                                       
Semicolon       = ";"
Comma           = ","
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
/*Function = function*/
/*Floating point numbers*/
Lnum            = [0-9]+ 
Dnum            = ([0-9]*[\.]{Lnum}) | ({Lnum}[\.][0-9]*)
Exponent_Dnum   = [+-]?(({Lnum} | {Dnum}) [eE][+-]? {Lnum})



ident           = ((_)*)?[a-zA-Z][a-zA-Z0-9_]*

Comment         =((\/\/)(.)*)|("\/\*"~"\*\/")|[0-9]*"pt"|(\/\*)(.)*(\*\/)|"/*"([^\*]|\*[^/])"*/"|"/*"(.)"*/"

Newline         = \n
NewLines        ={Newline}+|{Newline}({Newline}|{WhiteSpace}|" ")*
WhiteSpace      = [\s\t\r\v\f]

Point           = \.|\?|:|\\

Punctuation     ={Point}|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket}|"[]"|"{}"|"()"
/*Constant        ={Booleans}|{Integers}|{Double}|{String}*/
/*("$"?[0-9]*[a-zA-Z0-9]*)|("=!=")*/

CommentError    = (\/\*)(.)
Errors          = (("\/\*")(\n)*)|(\/\*\n)|(\/\*)({WhiteSpace}|{Newline})*




%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

%state STRING

%%


"int"                {return new Symbol(sym.INT);} 
"double"            {return new Symbol(sym.DOUBLE);} 
"bool"              {return new Symbol(sym.BOOL);} 
"string"            {return new Symbol(sym.STRING);} 
"void"              {return new Symbol(sym.VOID);} 
"class"             {return new Symbol(sym.CLASS);} 
"EXTENDS"           {return new Symbol(sym.EXTENDS);} 
"implements"        {return new Symbol(sym.IMPLEMENTS);} 
"interface"         {return new Symbol(sym.INTERFACE);}
"if"                {return new Symbol(sym.IF);} 
"else"              {return new Symbol(sym.ELSE);} 
"while"             {return new Symbol(sym.WHILE);} 
"for"               {return new Symbol(sym.FOR);} 
"return"            {return new Symbol(sym.RETURN);} 
"break"             {return new Symbol(sym.BREAK);} 
"Print"             {return new Symbol(sym.PRINT);} 
"this"              {return new Symbol(sym.THIS);} 
"New"               {return new Symbol(sym.NEW);} 
"NewArray"          {return new Symbol(sym.NEWARRAY);} 
"ReadInteger"       {return new Symbol(sym.READINTEGER);} 
"ReadLine"          {return new Symbol(sym.READLINE);} 
"Malloc"            {return new Symbol(sym.MALLOC);} 
{Integers}          {return new Symbol(sym.INTCONSTANT);} 
{Double}            {return new Symbol(sym.DOUBLECONSTANT);} 
{Booleans}          {return new Symbol(sym.BOOLCONSTANT);} 
{String}            {return new Symbol(sym.STRINGCONSTANT);} 
"null"              {return new Symbol(sym.NULL);} 
"GetByte"           {return new Symbol(sym.GETBYTE);} 
"SetByte"           {return new Symbol(sym.SETBYTE);} 


{Comparison_op}     {return new Symbol(sym.Comparison_op);}
{Arithmetic_Op}     {return new Symbol(sym.Arithmetic_Op);}

{LeftParenthesis}   {return new Symbol(sym.LeftParenthesis);}
{RightParenthesis}  {return new Symbol(sym.RightParenthesis);}
{LeftBrace}         {return new Symbol(sym.LeftBrace);}
{RightBrace}        {return new Symbol(sym.RightBrace);}
{LeftBracket}       {return new Symbol(sym.LeftBracket);}
{RightBracket}      {return new Symbol(sym.RightBracket);}
{Negation}          {return new Symbol(sym.Negation);}
{Equal}             {return new Symbol(sym.Equal);}
{Semicolon}         {return new Symbol(sym.Semicolon);}
{Comma}             {return new Symbol(sym.Comma);}
{Point}             {return new Symbol(sym.Point);}

/*{reserved_words}    {return new Symbol(sym.reserved_words);} */
{ident}             {return new Symbol(sym.ident);} 

{Comment}           {/*return new Symbol(sym.Comment);*/}

{NewLines}          {/*return new Symbol(sym.NewLines);*/}
/*{Newline}           {return new Symbol(sym.NewLine);}*/

/*{Logical_Op}        {/*return new Symbol(sym.Logical_Op);*/}*/
{Punctuation}       {}
{CommentError}      { /*return new Symbol(sym.CommentError);*/}
{Errors}            { /*return new Symbol(sym.Errors);*/}
/*.                   {return ERROR;}*/