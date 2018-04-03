/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador_lexico;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author sebas
 */
public class Analizador_lexico {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String path = new File(".").getCanonicalPath();
        Lex(path + "\\src\\analizador_lexico\\Lexer.flex");
        
    }
    public static void Lex(String path)
    {
        File file = new File(path);
        jflex.Main.generate(file);
    }
    
}
