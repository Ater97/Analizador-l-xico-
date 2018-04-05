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
import javax.swing.JOptionPane;
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
        boolean flag = true;
        String path = new File(".").getCanonicalPath();
        Lex(path + "\\src\\analizador_lexico\\Lexer.flex");
        while(flag){
            Analyzer();
            flag = stay();
        }
        System.exit(0);
    }
    public static void Analyzer() throws FileNotFoundException, IOException
    {
        boolean flag_ERROR = false;
        File originalFile = OpenFile();
        Reader reader = new BufferedReader(new FileReader(originalFile.getPath()));
        Lexer lexer = new Lexer(reader);
        ArrayList<String> result = new ArrayList<String>();

        int lineNumber =0;
        while(true){
            Token token = lexer.yylex();
            if(token==null){
                result.add("END");
                if(!flag_ERROR){
                    createOUT(originalFile.getName(),originalFile.getPath(),result);
                }
                return;
            }
            if(lexer.lexeme.contains("\n"))
                lineNumber++;
            switch(token)
            {
                case ERROR: result.add(" " + token + " <" + lexer.lexeme+"> ");
                     System.out.println(" " + token + " <" + lexer.lexeme+"> in line "+ lineNumber);
                    flag_ERROR = true;
                break;      
                default: 
                    if("STRING"==token.toString()||"CONSTANT"==token.toString())
                    {
                        result.add(lexer.lexeme);
                    }
                    else
                        result.add(lexer.lexeme.toLowerCase()); //"Token " + token + " "+ lexer.lexeme);
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
		//bw.newLine();
	}
	bw.close();
    }
         public static boolean stay()
    {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to continue?","",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            return true;
        }
        return false;
    }
    
}
