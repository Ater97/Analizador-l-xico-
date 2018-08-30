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
    public static boolean flag_ERROR = false;
    public static int ERRORSNumber = 0;
    public static boolean comment_ERROR_Flag = true;
    public static void Analyzer() throws FileNotFoundException, IOException
    {
        flag_ERROR = false;
        File originalFile = OpenFile();
        Reader reader = new BufferedReader(new FileReader(originalFile.getPath()));
        Lexer lexer = new Lexer(reader);
        ArrayList<String> result = new ArrayList<String>();

        int lineNumber = 1;
        int tempLineNumber =1;
        String tempLinestr = "";
        int lenghtA = 1 ;
        int lenghtB = 0;
        ERRORSNumber = 0;
        while(true){
            Token token = lexer.yylex();
            if(token==null){
                    createOUT(originalFile.getName(),originalFile.getPath(),result);
                return;
            }
            //if(lexer.lexeme.contains("\n"))
              //  lineNumber++;
            switch(token) //RESERVED_WORD, IDENTIFIER, WHITESPACE, COMMENT, CONSTANT, CONSTANTCOMPARISON_OPERATOR, ARITHMETIC_OPERATOR, LOGICAL_OPERATOR, ERROR
            {
                case NEWLINES:
                    lineNumber++;
                    break;
                case ERROR: 
                    if(lineNumber == tempLineNumber)
                    {
                        lenghtA = tempLinestr.length();
                        tempLinestr += lexer.lexeme.trim();
                        lenghtB = tempLinestr.length();
                    }
                    else
                    {
                        tempLineNumber++;
                        tempLinestr = lexer.lexeme.trim();
                        lenghtA =1;
                        lenghtB = tempLinestr.length();
                    }
                    if(comment_ERROR_Flag){
                        ERRORSNumber++;
                        result.add(" ***" + token + " " + ERRORSNumber + " <" + lexer.lexeme+"> in line " +  lineNumber + "***" );
                        System.out.println(" "+ token + " " + ERRORSNumber + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                        flag_ERROR = true;}
                break;   
                case RESERVED_WORD:
                    if(lineNumber == tempLineNumber)
                    {
                        lenghtA = tempLinestr.length();
                        tempLinestr += lexer.lexeme.trim();
                        lenghtB = tempLinestr.length();
                    }
                    else
                    {
                        tempLineNumber++;
                        tempLinestr = lexer.lexeme.trim();
                        lenghtA =1;
                        lenghtB= tempLinestr.length();
                    }
                    if(comment_ERROR_Flag){
                        result.add(" " + token + "                    => " + lexer.lexeme + " in line " + lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                        System.out.println(" " + token + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);}
                break;
                case IDENTIFIER:
                    if(lineNumber == tempLineNumber)
                    {
                        lenghtA = tempLinestr.length();
                        tempLinestr += lexer.lexeme.trim();
                        lenghtB = tempLinestr.length();
                    }
                    else
                    {
                        tempLineNumber++;
                        tempLinestr = lexer.lexeme.trim();
                        lenghtA =1;
                        lenghtB = tempLinestr.length();
                    }
                    if(comment_ERROR_Flag){
                        if(lexer.lexeme.length()<32){
                            result.add(" " + token + "                       => " + lexer.lexeme + " in line " + lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                            System.out.println(" " + token + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);}
                        else{
                            ERRORSNumber++;
                            String temp = lexer.lexeme.substring(0, 30);
                            result.add(" ***ERROR " + ERRORSNumber + " IDENTIFIER LENGTH ERROR <" + temp + "> in line " + lineNumber + "***");
                            System.out.println("ERROR " + ERRORSNumber + " IDENTIFIER LENGTH ERROR  <" + temp + "> in line "+ lineNumber);
                        }
                    }
                break;
                case COMMENT:
                    //result.add(" " + token + "                          => " + lexer.lexeme + " in line " + lineNumber);
                    //System.out.println(" " + token + " <" + lexer.lexeme+"> in line "+ lineNumber);
                break;
                case COMMENT_ERROR:
                    if(comment_ERROR_Flag){
                        ERRORSNumber++;
                        result.add(" " + token + "                          => " + lexer.lexeme + " in line " + lineNumber);
                        System.out.println(" " + token + " <" + lexer.lexeme+"> in line "+ lineNumber);
                        comment_ERROR_Flag = false;
                        flag_ERROR = true;}
                break;
                case CONSTANT:
                    if(lineNumber == tempLineNumber)
                    {
                        lenghtA = tempLinestr.length();
                        tempLinestr += lexer.lexeme.trim();
                        lenghtB = tempLinestr.length();
                    }
                    else
                    {
                        tempLineNumber++;
                        tempLinestr = lexer.lexeme.trim();
                        lenghtA =1;
                        lenghtB = tempLinestr.length();
                    }
                    if(comment_ERROR_Flag){
                        result.add(" " + token + "                         => " + lexer.lexeme + " in line " + lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                        System.out.println(" " + token + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);}
                break;
                case CONSTANTCOMPARISON_OPERATOR:
                    if(lineNumber == tempLineNumber)
                    {
                        lenghtA = tempLinestr.length();
                        tempLinestr += lexer.lexeme.trim();
                        lenghtB = tempLinestr.length();
                    }
                    else
                    {
                        tempLineNumber++;
                        tempLinestr = lexer.lexeme.trim();
                        lenghtA =1;
                        lenghtB = tempLinestr.length();
                    }
                    if(comment_ERROR_Flag){
                        result.add(" " + token + "      => " + lexer.lexeme + " in line " + lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                        System.out.println(" " + token + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);}
                break;
                case  ARITHMETIC_OPERATOR:
                    if(lineNumber == tempLineNumber)
                    {
                        lenghtA = tempLinestr.length();
                        tempLinestr += lexer.lexeme.trim();
                        lenghtB = tempLinestr.length();
                    }
                    else
                    {
                        tempLineNumber++;
                        tempLinestr = lexer.lexeme.trim();
                        lenghtA =1;
                        lenghtB = tempLinestr.length();
                    }
                    if(comment_ERROR_Flag){
                        result.add(" " + token + "              => " + lexer.lexeme + " in line " + lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                        System.out.println(" " + token + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);}
                break;
                case LOGICAL_OPERATOR:
                    if(lineNumber == tempLineNumber)
                    {
                        lenghtA = tempLinestr.length();
                        tempLinestr += lexer.lexeme.trim();
                        lenghtB = tempLinestr.length();
                    }
                    else
                    {
                        tempLineNumber++;
                        tempLinestr = lexer.lexeme.trim();
                        lenghtA =1;
                        lenghtB = tempLinestr.length();
                    }
                    if(comment_ERROR_Flag){
                        result.add(" " + token + "                 => " + lexer.lexeme + " in line " + lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                        System.out.println(" " + token + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);}
                break;
                case PUNCTUATION:
                    if(lineNumber == tempLineNumber)
                    {
                        lenghtA = tempLinestr.length();
                        tempLinestr += lexer.lexeme.trim();
                        lenghtB = tempLinestr.length();
                    }
                    else
                    {
                        tempLineNumber++;
                        tempLinestr = lexer.lexeme.trim();
                        lenghtA =1;
                        lenghtB = tempLinestr.length();
                    }
                    if(comment_ERROR_Flag){
                        result.add(" " + token + "                       => " + lexer.lexeme + " in line " + lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                        System.out.println(" " + token + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);}
                break;
                default: 
                    if(lexer.lexeme.equals(""))
                        result.add(lexer.lexeme);//"Token " + token + " "+ lexer.lexeme);
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
        FileNameExtensionFilter filter = new FileNameExtensionFilter("C# Files", "frag");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file");  
        fileChooser.setFileFilter(filter);
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileParse = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileParse.getAbsolutePath());}
        else
            System.exit(0);
        return  fileParse;
    }
    
       public static void createOUT(String filename, String path, ArrayList<String> MainList) throws IOException
    {
        path = path.replace(filename, "");
        filename = filename.replace(".frag", "");  
        
        File fout = new File(path,filename+".out");
	FileOutputStream fos = new FileOutputStream(fout);
 
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
            if(flag_ERROR){
                if(ERRORSNumber==1)
                    bw.write("***The file have " + ERRORSNumber + " ERROR***");
                else
                    bw.write("***The file have " + ERRORSNumber + " ERRORS***");
                bw.newLine();
            }
            
            for (int i = 0; i < MainList.size(); i++) {
                if(!MainList.get(i).equals("\r") && !MainList.get(i).isEmpty() && !MainList.get(i).equals("") && !MainList.get(i).equals("\n")){
                    bw.write(MainList.get(i));
                    bw.newLine();}
            }
        }
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