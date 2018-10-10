
package analizador_lexico;

import java_cup.runtime.*;

%%
%class Lexer
%unicode
%line
%column
%cup


%{
    public int linenumber = 0;
    public int columnnumber = 0;
    public String lexeme;
    public int errornumber = 0;
    public int errornumberLength = 0;
    public String Errors = "";
    public void getErrors(String error){
        errornumber++;
       System.out.println( errornumber + " Lexic Message Line: " + linenumber + " Col: " + columnnumber + " Text: " + error);
    }
    public void getIdenterror(String error){
        errornumberLength++;
       System.out.println( errornumberLength + " Lenght Message Line: " + linenumber + " Col: " + columnnumber + " Text: " + error);
    }
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn, yytext());
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }


%}

/*Operators*/
/*  (, ), +, -, *, /, %, <, <=, >, >=, ==, !=, &&, ||, !  */

Comparison_op   = "<"|">"|"<="|">="|"=="|"!="
 
/*  |"==="|"<>"|"<=>"|"??"   */
/*Arithmetic*/
Equal           = "="
Negation        = "!"|"-"
Arithmetic_Op   = \+|\-|\*|\/|\%
/*Logic*/
Logical_Op      = "||"|"!"|"&&"

/*Types*/
Booleans        =true|false
Decimal         = [1-9][0-9]*|0
Hexadecimal     = 0[xX][0-9a-fA-F]+
Octal           = 0[0-7]+
Binary          = 0[bB][01]+
Integers        = [+-]?{Decimal}|[+-]?{Hexadecimal}|[+-]?{Octal}|[+-]?{Binary}
Double          = [+-]?([1-9][0-9]*|0)(\.)[0-9]*|{Exponent_Dnum}|[+-]?(({Lnum}|{Dnum})\.[eE][+-]? {Lnum})

Point           = "."                                       
Semicolon       = ";"
Comma           = ","
RightParenthesis= ")"
LeftParenthesis = "("
Parenthesis     = {LeftParenthesis}|{RightParenthesis}
RightBrace      = \]
LeftBrace       = \[
Brace           = {LeftBrace}|{RightBrace}
RightBracket    = \}
LeftBracket     = \{
Bracket         = {LeftBracket}|{RightBracket}
String          =(\'(.|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket}|{Point})*\')|(\"(.|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket})*\")


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

Punctuation     ={Point}|{Semicolon}|{Comma}|{Parenthesis}|{Brace}|{Bracket}|"[]"|"{}"
/*Constant        ={Booleans}|{Integers}|{Double}|{String}*/
/*("$"?[0-9]*[a-zA-Z0-9]*)|("=!=")*/

CommentError    = (\/\*)(.)
Errors          = (("\/\*")(\n)*)|(\/\*\n)|(\/\*)({WhiteSpace}|{Newline})*






/*%state STRING*/

%%
<YYINITIAL>{

{LeftParenthesis}   {return new Symbol(sym.LeftParenthesis, yyline, yycolumn, yytext());}
{RightParenthesis}  {return new Symbol(sym.RightParenthesis, yyline, yycolumn, yytext());}

"int"               {return new Symbol(sym.INT, yyline, yycolumn, yytext());} 
"double"            {return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());} 
"bool"              {return new Symbol(sym.BOOL, yyline, yycolumn, yytext());} 
"string"            {return new Symbol(sym.STRING, yyline, yycolumn, yytext());} 
"void"              {return new Symbol(sym.VOID, yyline, yycolumn, yytext());} 
"class"             {return new Symbol(sym.CLASS, yyline, yycolumn, yytext());} 
"extends"           {return new Symbol(sym.EXTENDS, yyline, yycolumn, yytext());} 
"implements"        {return new Symbol(sym.IMPLEMENTS, yyline, yycolumn, yytext());} 
"interface"         {return new Symbol(sym.INTERFACE, yyline, yycolumn, yytext());}
"if"                {return new Symbol(sym.IF, yyline, yycolumn, yytext());} 
"else"              {return new Symbol(sym.ELSE, yyline, yycolumn, yytext());} 
"while"             {return new Symbol(sym.WHILE, yyline, yycolumn, yytext());} 
"for"               {return new Symbol(sym.FOR, yyline, yycolumn, yytext());} 
"return"            {return new Symbol(sym.RETURN, yyline, yycolumn, yytext());} 
"break"             {return new Symbol(sym.BREAK, yyline, yycolumn, yytext());} 
"Print"             {return new Symbol(sym.PRINT, yyline, yycolumn, yytext());} 
"this"              {return new Symbol(sym.THIS, yyline, yycolumn, yytext());} 
"New"               {return new Symbol(sym.NEW, yyline, yycolumn, yytext());} 
"NewArray"          {return new Symbol(sym.NEWARRAY, yyline, yycolumn, yytext());} 
"ReadInteger"       {return new Symbol(sym.READINTEGER, yyline, yycolumn, yytext());} 
"ReadLine"          {return new Symbol(sym.READLINE, yyline, yycolumn, yytext());} 
"Malloc"            {return new Symbol(sym.MALLOC, yyline, yycolumn, yytext());} 
{Integers}          {return new Symbol(sym.INTCONSTANT, yyline, yycolumn, yytext());} 
{Double}            {return new Symbol(sym.DOUBLECONSTANT, yyline, yycolumn, yytext());} 
{Booleans}          {return new Symbol(sym.BOOLCONSTANT, yyline, yycolumn, yytext());} 
{String}            {return new Symbol(sym.STRINGCONSTANT, yyline, yycolumn, yytext());} 
"null"              {return new Symbol(sym.NULL, yyline, yycolumn, yytext());} 
"GetByte"           {return new Symbol(sym.GETBYTE, yyline, yycolumn, yytext());} 
"SetByte"           {return new Symbol(sym.SETBYTE, yyline, yycolumn, yytext());} 


{Comparison_op}     {return new Symbol(sym.Comparison_op, yyline, yycolumn, yytext());}
{Arithmetic_Op}     {return new Symbol(sym.Arithmetic_Op, yyline, yycolumn, yytext());}
{Logical_Op}        {return new Symbol(sym.Logical_Op, yyline, yycolumn, yytext());}
{Equal}             {return new Symbol(sym.Equal, yyline, yycolumn, yytext());}
{LeftBrace}         {return new Symbol(sym.LeftBrace, yyline, yycolumn, yytext());}
{RightBrace}        {return new Symbol(sym.RightBrace, yyline, yycolumn, yytext());}
{LeftBracket}       {return new Symbol(sym.LeftBracket, yyline, yycolumn, yytext());}
{RightBracket}      {return new Symbol(sym.RightBracket, yyline, yycolumn, yytext());}
{Negation}          {return new Symbol(sym.Negation, yyline, yycolumn, yytext());}
{Semicolon}         {return new Symbol(sym.Semicolon, yyline, yycolumn, yytext());}
{Comma}             {return new Symbol(sym.Comma, yyline, yycolumn, yytext());}
"."                 {return new Symbol(sym.Point, yyline, yycolumn, yytext());}

{ident}             {lexeme=yytext();
                    if(lexeme.length()<31)
                        return new Symbol(sym.ident, yyline, yycolumn, yytext());
                    linenumber=yyline;
                    columnnumber=yycolumn;
                    String temp = lexeme.substring(0, 30);
                    getIdenterror(temp);
                    } 

{Comment}           {}

[\t\r]              {}
[\r\n]+             {}

{Punctuation}       {}
{NewLines}          {}
{CommentError}      {}
{Errors}            {}
" "                 {}
{WhiteSpace}        {}
}
.                   {lexeme=yytext();linenumber=yyline;columnnumber=yycolumn;getErrors(lexeme);}