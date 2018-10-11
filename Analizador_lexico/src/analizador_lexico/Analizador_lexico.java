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
    
    public static void main(String[] args) throws IOException, Exception {

        String path = new File(".").getCanonicalPath();
        GenerateLexerFile(path + "\\src\\analizador_lexico\\Lexer.flex");      
        GenerateCupFile(path + "\\src\\analizador_lexico\\parser.cup",path + "\\src\\analizador_lexico");
        while(stay()){
            Analyzer();
        }
        System.exit(0);
    }
    public static boolean flag_ERROR = false;
    public static int ERRORSNumber = 0;
    public static boolean comment_ERROR_Flag = true;
    
    public static void Analyzer() throws FileNotFoundException, IOException, Exception
    {
        flag_ERROR = false;
        File originalFile = OpenFile();
        Lexer lexer = new Lexer(new FileReader(originalFile.getPath()));
        ArrayList<String> result = new ArrayList<String>();

        /*int lineNumber = 1;
        int tempLineNumber = 1;
        String tempLinestr = "";
        int lenghtA = 1;
        int lenghtB = 0;
        ERRORSNumber = 0;*/
        Parser P = new Parser(lexer);
        //P.debug_parse();
        P.parse();
        result.add(P.ErrorM);        
        if(P.ErrorNumber == 0 && lexer.errornumber == 0 && lexer.errornumberLength == 0)
            System.out.println("Correct file :)\n Congrats!");
        else{
        System.out.println(P.ErrorM + 
                        "\n----------------------------------------------------\n"+
                        "Analysis report"+ 
                        "\nSintac: " + P.ErrorNumber + 
                        "\nLexic : " + lexer.errornumber + 
                        "\nLength: " + lexer.errornumberLength + 
                        "\nTotal : " + (P.ErrorNumber + lexer.errornumber + lexer.errornumberLength));
        }
        
        //createOUT(originalFile.getName(),originalFile.getPath(),result);
        
        /*while(true){
            Token token = lexer.yylex();
           x`
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
                /*case CONSTANT:
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
                break;*//*
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
                case DOUBLE:
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
                        result.add(" CONSTANT " + token + "                       => " + lexer.lexeme + " in line " + lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                        System.out.println(" CONSTANT " + token + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);}
                break;
                case INTEGER:
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
                        result.add(" CONSTANT " + token + "                       => " + lexer.lexeme + " in line " + lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                        System.out.println(" CONSTANT " + token + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);}
                break;
                case STRING:
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
                        result.add(" CONSTANT " + token + "                       => " + lexer.lexeme + " in line " + lineNumber + " Cols " + lenghtA + "-" + lenghtB);
                        System.out.println(" CONSTANT " + token + " <" + lexer.lexeme+"> in line "+ lineNumber + " Cols " + lenghtA + "-" + lenghtB);}
                break;
                default: 
                    if(lexer.lexeme.equals(""))
                        result.add(lexer.lexeme);//"Token " + token + " "+ lexer.lexeme);
                break;
            }
        }*/
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
                          
        String[] commands = {/* "-expect", "32" ,*/"-destdir", Folderpath, "-parser", "Parser", path};
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
            System.out.println("File path: " + fileParse.getAbsolutePath());}
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