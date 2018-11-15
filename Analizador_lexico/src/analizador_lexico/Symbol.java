/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador_lexico;

/**
 *
 * @author Sebastian
 */
public class Symbol {
    public String Name = "";
    public String Type = "";
    public String Value = "";
    
    public Symbol(String name,String type,String value)
    {
        Name = name;
        Type = type;
        Value = value;
    }
    
            
}
