/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador_lexico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sebas
 */
public class Analizador_lexico {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String path = new File(".").getCanonicalPath();
        Lex(path + "\\src\\analizador_lexico\\Lexer.flex");
        
        
        //OpenFile();
        Analyzer();
    }
    public static void Analyzer() throws FileNotFoundException, IOException
    {
        File originalFile = OpenFile();
        Reader reader = new BufferedReader(new FileReader(originalFile.getPath()));
        Lexer lexer = new Lexer(reader);
        int linecount =0;
        ArrayList<String> result = new ArrayList<String>();

        while(true){
            Token token = lexer.yylex();
            if(token==null){
                result.add( "END");
                createOUT(originalFile.getName(),originalFile.getPath(),result);
                return;
            }
            switch(token)
            {
                case ERROR: result.add("Error in line number " + linecount);
                break;
                case NEWLINE: linecount++;
                break;
                default: result.add( "Token " + token + lexer.lexeme);
                break;
            }
        }
    }
    public static void Lex(String path)
    {
        File file = new File(path);
        jflex.Main.generate(file);
    }
    
    public static File OpenFile()
    {
        File fileParse = null;
        JFrame parentFrame = new JFrame();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PHP Files", "php");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file");  
        fileChooser.setFileFilter(filter);
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileParse = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileParse.getAbsolutePath());}
        return  fileParse;
    }
    
       public static void createOUT(String filename, String path, ArrayList<String> MainList) throws IOException
    {
        path = path.replace(filename, "");
        filename = filename.replace(".php", "");  
        
        File fout = new File(path,filename+".out");
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
 
	for (int i = 0; i < MainList.size(); i++) {
		bw.write(MainList.get(i));
		bw.newLine();
	}
	bw.close();
    }
    
}
