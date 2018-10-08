package analizador_lexico;

import java_cup.runtime.Symbol;

%%
%class Lexer
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
Function = function
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
Constant        ={Booleans}|{Integers}|{Double}|{String}
/*("$"?[0-9]*[a-zA-Z0-9]*)|("=!=")*/

CommentError    = (\/\*)(.)
Errors          = (("\/\*")(\n)*)|(\/\*\n)|(\/\*)({WhiteSpace}|{Newline})*


int             =   "int"
double          =   "double" 
bool            =   "bool" 
string          =   "string"
void            =   "void"
class           =   "clas"
EXTENDS         =   "extends" 
implements      =   "implements"
interface       =   "interface" 
if              =   "if" 
else            =   "else"
while           =   "while"
for             =   "for"
return          =   "return"
break           =   "break" 
Print           =   "Print" 
this            =   "this"
New             =   "New"
NewArray        =   "NewArray" 
ReadInteger     =   "ReadInteger" 
ReadLine        =   "ReadLine" 
Malloc          =   "Malloc"
intConstant     =   "intConstant" 
doubleConstant  =   "doubleConstant" 
boolConstant    =   "boolConstant" 
stringConstant  =   "stringConstant" 
null            =   "null"
GetByte         =   "GetByte"
SetByte         =   "SetByte"

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

{int}               {return new Symbol(sym.int);} 
{double}            {return new Symbol(sym.double);} 
{bool}              {return new Symbol(sym.bool);} 
{string}            {return new Symbol(sym.string);} 
{void}              {return new Symbol(sym.void);} 
{class}             {return new Symbol(sym.class);} 
{EXTENDS}           {return new Symbol(sym.EXTENDS);} 
{implements}        {return new Symbol(sym.implements);} 
{if}                {return new Symbol(sym.if);} 
{else}              {return new Symbol(sym.else);} 
{while}             {return new Symbol(sym.while);} 
{for}               {return new Symbol(sym.for);} 
{return}            {return new Symbol(sym.return);} 
{break}             {return new Symbol(sym.break);} 
{Print}             {return new Symbol(sym.Print);} 
{this}              {return new Symbol(sym.this);} 
{New}               {return new Symbol(sym.New);} 
{NewArray}          {return new Symbol(sym.NewArray);} 
{ReadInteger}       {return new Symbol(sym.ReadInteger);} 
{ReadLine}          {return new Symbol(sym.ReadLine);} 
{Malloc}            {return new Symbol(sym.Malloc);} 
{intConstant}       {return new Symbol(sym.intConstant);} 
{doubleConstant}    {return new Symbol(sym.doubleConstant);} 
{boolConstant}      {return new Symbol(sym.boolConstant);} 
{stringConstant}    {return new Symbol(sym.stringConstant);} 
{null}              {return new Symbol(sym.null);} 
{GetByte}           {return new Symbol(sym.GetByte);} 
{SetByte}           {return new Symbol(sym.SetByte);} 

{LeftParenthesis}   {return new Symbol(sym.LeftParenthesis);}
{RightParenthesis}  {return new Symbol(sym.RightParenthesis);}
{LeftBrace}         {return new Symbol(sym.LeftBrace);}
{RightBrace}        {return new Symbol(sym.RightBrace);}
{LeftBracket}       {return new Symbol(sym.LeftBracket);}
{RightBracket}      {return new Symbol(sym.RightBracket);}
{Negation}          {return new Symbol(sym.Negation);}
{Equal}             {return new Symbol(sym.Equal);}

{reserved_words}    {return new Symbol(sym.reserved_words);} 
{ident}             {return new Symbol(sym.ident);} 

{Comment}           { return new Symbol(sym.Comment);}

{Integers}          { return new Symbol(sym.Integers);}
{Double}            { return new Symbol(sym.Double);}
{String}            { return new Symbol(sym.String);}

{NewLines}          {return new Symbol(sym.NewLines);}
/*{Newline}           {return new Symbol(sym.NewLine);}*/

{Punctuation}       {return new Symbol(sym.Punctuation);}
{Comparison_op}     {return new Symbol(sym.Comparison_op);}
{Arithmetic_Op}     {return new Symbol(sym.Arithmetic_op);}
{Logical_Op}        {return new Symbol(sym.Logical_Op);}

{CommentError}      { return new Symbol(sym.CommentError);}
{Errors}            { return new Symbol(sym.Errors);}
/*.                   {return ERROR;}*/