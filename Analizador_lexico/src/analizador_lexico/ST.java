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
public class ST {
    public String Name = "";
    public String Type = "";
    public String Value = "";
    public String Scope = "";
    
    public ST(String name,String scope, String type,String value)
    {
        Name = name;
        Type = type;
        Value = value;
        Scope = scope;
        setValueDefault();
    }       
    
    public void setValueDefault()
    {
        if(Value==null)
        {
            if(Type.equals("int"))
                Value="0";
            else if(Type.equals("double"))
                Value="0.0";
            else if(Type.equals("bool"))
                Value="false";
        }
    }
}
