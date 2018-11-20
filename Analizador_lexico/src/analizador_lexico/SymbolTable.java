/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador_lexico;

import static analizador_lexico.Analizador_lexico.ERRORSNumber;
import static analizador_lexico.Analizador_lexico.flag_ERROR;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Sebastian
 */
public class SymbolTable {
    public HashMap<String,ST> SymbolHashtable;
    public Integer countkey;
    HashMap<String, String> dictionary = new HashMap<String, String>();
    public SymbolTable ()
    {
        SymbolHashtable = new HashMap<>();
        countkey = 0;
    }
    
    
    public void Insert(String name,String ambito,String type, String value){
        if(SymbolHashtable.get(name + ambito) == null)
        {
            dictionary.put(name + ambito, name + ambito + type + value);
            SymbolHashtable.put(name + ambito, new ST(name,ambito,type,value));
            System.out.println("Successful Insert " +name + " " + ambito);
        }   
    }
    
    public boolean Search(String name, String ambito)
    {
        if(SymbolHashtable.get(name+ambito) != null)
            return  true;
        return false;
    }
    
    public ST getSymbol (String name, String ambito)
    {
        return SymbolHashtable.get(name+ ambito);
    }
    
    public void update (String name, String ambito, String value)
    {
        ST temp = getSymbol(name, ambito);
        temp.Value = value;
        SymbolHashtable.put(name + ambito, temp);
    }
    

    
    public static void CreateFile(String filename, String path, ArrayList<String> MainList) throws IOException
    {
        path = path.replace(filename, "");
        filename = filename.replace(".frag", "");  
        File fout = new File(path,filename+".out");
	FileOutputStream fos = new FileOutputStream(fout);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
            for (int i = 0; i < MainList.size(); i++) {
                if(!MainList.get(i).equals("\r") && !MainList.get(i).isEmpty() && !MainList.get(i).equals("") && !MainList.get(i).equals("\n")){
                    bw.write(MainList.get(i));
                    bw.newLine();}
            }
        }
    }
    
}
