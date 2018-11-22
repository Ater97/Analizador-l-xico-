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
    public static String staticPath = "";
    public static SymbolTable STm = new SymbolTable();
    public static void main(String[] args) throws IOException, Exception {

        String path = new File(".").getCanonicalPath();
        GenerateLexerFile(path + "\\src\\analizador_lexico\\Lexer.flex");      
        GenerateCupFile(path + "\\src\\analizador_lexico\\parser.cup",path + "\\src\\analizador_lexico");
        do { 
            Analyzer();
        } while (stay());
        System.exit(0);
    }
    public static boolean flag_ERROR = false;
    public static int ERRORSNumber = 0;
    public static boolean comment_ERROR_Flag = true;
    public static SymbolTable STMAin;
    public static void Analyzer() throws FileNotFoundException, IOException, Exception
    {
        flag_ERROR = false;
        File originalFile = OpenFile();
        Lexer lexer = new Lexer(new FileReader(originalFile.getPath()));
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> ToPrint = new ArrayList<String>();
        Parser P = new Parser(lexer);
        //P.debug_parse();
        P.parse();
        result.add(P.ErrorM);        
        
        if(P.ErrorNumber == 0 && lexer.errornumber == 0 && lexer.errornumberLength == 0)
            System.out.println("Correct file :) Congrats!");
        else{
        System.out.println(P.ErrorM + 
                        "\n----------------------------------------------------\n"+
                        "Analysis report"+ 
                        "\nSintac: " + P.ErrorNumber + 
                        "\nLexic : " + lexer.errornumber + 
                        "\nLength: " + lexer.errornumberLength + 
                        "\nTotal : " + (P.ErrorNumber + lexer.errornumber + lexer.errornumberLength));
        }
    }
    public static void GenerateLexerFile(String path)
    {
        try{
        File file = new File(path);
        JFlex.Main.generate(file);
        }
                catch(Exception e){
        }
    }
    public static void GenerateCupFile(String path, String Folderpath){
                          
        String[] commands = {"-destdir", Folderpath, "-parser", "Parser", path};
        try {
            java_cup.Main.main(commands);
        } catch (Exception e) {
        }
    }
    public static File OpenFile()
    {
        File fileParse = null;
        JFrame parentFrame = new JFrame();
        FileNameExtensionFilter filterfrag = new FileNameExtensionFilter(".frag", "frag");
        FileNameExtensionFilter filtertxt = new FileNameExtensionFilter(".txt", "txt");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file");  
        fileChooser.addChoosableFileFilter(filterfrag);
        fileChooser.addChoosableFileFilter(filtertxt);
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileParse = fileChooser.getSelectedFile();
            
            System.out.println("File path: " + fileParse.getAbsolutePath());
            staticPath = fileParse.getAbsolutePath();
        }
            
        else
            System.exit(0);
        return  fileParse;
    }
       public static boolean stay()
    {
        flag_ERROR = false;
        ERRORSNumber = 0;
        comment_ERROR_Flag = true;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to continue?","",dialogButton);
        return dialogResult == JOptionPane.YES_OPTION;
    } 
       
    
}