Lexical analyser

When you run the program a file dialog will display, so you 
can choose the file .php to convert into .out the new file 
will be created in the same path as the original. After this 
a new dialog will show, asking if you want to convert another 
file, if you do click YES and the file dialog will show again. 
In case you are done only click NO and the program will close.

The new file .out will be the same if there are no errors, otherwise 
there will be display on the file: ERROR => <actual unknown token> 
and in the console will be display the error number with the 
line where it is the error.

This program scann php code, and verify if the tokens are valid 
in a php context. Must be consider that this does not verify
syntax of php.
