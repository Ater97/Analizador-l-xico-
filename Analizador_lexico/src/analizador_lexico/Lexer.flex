package analizador_lexico;

import static analizador_lexico.Token.*;
%%
%class Lexer
%type Token

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
reserved_words  = __halt_compiler|abstract| and| array| as| break|callable| case| catch| class| clone| const|
                 continue| declare| default| die| do| echo| else| elseif| empty| enddeclare| endfor| endforeach| 
                 endif| endswitch| endwhile|eval| exit| extends| final| for| foreach| function| global| goto| 
                 if| implements| include| include_once| instanceof| insteadof| interface| isset| list| namespace|
                 new| or| print| private| protected| public| require| require_once| return| static| switch| throw|
                 trait|try| unset| use| var| while| xor 
/*Operators*/
Comparison_op = "<"|">"|"<="|">="|"=="|"!="
/*Arithmetic*/
Arithmetic_Op   = "+"|"-"|"*"|"/"|"%"|"**"
/*Logic*/
Logical_Op      = "and"|"or"|"xor"|"!"|"&&"|"||"

/*Types*/
/*Logic*/
Booleans        = {t}{r}{u}{e}|{f}{a}{l}{s}{e}
/*Integers*/
Decimal         = [1-9][0-9]* | 0
Hexadecimal     = 0[xX][0-9a-fA-F]+
Octal           = 0[0-7]+
Binary          = 0[bB][01]+
Integers        = [+-]?Decimal | [+-]?Hexadecimal | [+-]?Octal | [+-]?Binary
/*Strings*/
String          = ('[(.)(\n)(\\')]*')|(\"[(.)(\n)(\\")]*\")

/*IDs*/
var_id          = "$"{Basic}
/*Vars*/
Basic           = [a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*
/*Consts*/

/*Control structures*/
control_struct  = ({i}{f}|{e}{l}{s}{e}|{e}{l}{s}{e}{i}{f}|{e}{n}{d}{i}{f}|{w}{h}{i}{l}{e}|{d}{o}|{f}{o}{r}|{f}{o}{r}{e}{a}{c}{h}|
                  {b}{r}{e}{a}{k}|{s}{w}{i}{t}{c}{h}|{c}{a}{s}{e}|{c}{o}{n}{t}{i}{n}{u}{e}|{r}{e}{t}{u}{r}{n}|{i}{n}{c}{l}{u}{d}{e}|
                  {g}{o}{to}|require_once|include_once)

/*Floating point numbers*/
Lnum            = [0-9]+ 
Dnum            = ([0-9]*[\.]{Lnum}) | ({Lnum}[\.][0-9]*)
Exponent_Dnum   = [+-]?(({Lnum} | {Dnum}) [eE][+-]? {Lnum})



Identifier      = [a-zA-Z][a-zA-Z0-9_]*
comment         = (("//")(.)*)|(("/*")(.)*("*/"))

php             = "<?php"


%{
    public String lexeme;
%}

%%
/*Rules Section*/
{white}         {/*Ignore*/}
{letter}        {lexeme = yytext(); return Variable;}
.               {lexeme = yytext();return ERROR;}