package analizador_lexico;

import static analizador_lexico.Token.*;
%%
%class Lexer
%type Token

//letter          = [a-z A-Z]
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
white           = [ ,\n]
Digit           = [0-9]

Booleans        = "True"|"TRUE"|"False"|"FALSE"

Decimal         = [0-9]+
Octal           = “o”[0-7]+
Hex             = “0x”[0-9|A-F]+
Binary          = 0[bB][01]+
Integers        = [+-]?Decimal | [+-]?Hex | [+-]?Octal | [+-]?Binary

Lnum            = [0-9]+ 
Dnum            = ([0-9]*[\.]{Lnum}) | ({Lnum}[\.][0-9]*)
Exponent_Dnum   = [+-]?(({Lnum} | {Dnum}) [eE][+-]? {Lnum})

String          = 


Identifier      = [a-zA-Z][a-zA-Z0-9_]*
comment         = (("//")(.)*)|(("/*")(.)*("*/"))
reserved_words  = __halt_compiler|abstract| and| array| as| break|callable| case| catch| class| clone| const|
                 continue| declare| default| die| do| echo| else| elseif| empty| enddeclare| endfor| endforeach| 
                 endif| endswitch| endwhile|eval| exit| extends| final| for| foreach| function| global| goto| 
                 if| implements| include| include_once| instanceof| insteadof| interface| isset| list| namespace|
                 new| or| print| private| protected| public| require| require_once| return| static| switch| throw|
                 trait|try| unset| use| var| while| xor 
php             = "<?php"


%{
    public String lexeme;
%}

%%

{white}         {/*Ignore*/}
{letter}        {lexeme = yytext(); return Variable;}
.               {lexeme = yytext();return ERROR;}