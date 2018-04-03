package analizador_lexico;

import static analizador_lexico.Token.*;
%%
%class Lexer
%type Token

letter = [a-z A-Z]
white =[ ,\n]

digit = [0-9]
comment = (("//")(.)*)|(("/*")(.)*("*/"))
reserved_words = __halt_compiler|abstract| and| array| as| break|callable| case| catch| class| clone| const|
                 continue| declare| default| die| do| echo| else| elseif| empty| enddeclare| endfor| endforeach| 
                 endif| endswitch| endwhile|eval| exit| extends| final| for| foreach| function| global| goto| 
                 if| implements| include| include_once| instanceof| insteadof| interface| isset| list| namespace|
                 new| or| print| private| protected| public| require| require_once| return| static| switch| throw|
                 trait|try| unset| use| var| while| xor

%{
    public String lexeme;
}%
%%

{white}         {/*Ignore*/}
{letter}        {lexeme = yytext(); return Variable;}
.               {lexeme = yytext();return ERROR;}