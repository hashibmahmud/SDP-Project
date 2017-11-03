/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dx_try;
/**
 * @author
 * Hashib Mahmud
 * Roll- 106
 * CSE,DU
 */
public class Singleton {
    private static Singleton uniqueinstance;
    JButtonEx fr;
    
    Singleton()
    {
        
    }
    
    public static Singleton getInstance()
    {
        if(uniqueinstance==null)
        {
            uniqueinstance=new Singleton();
                    }
        return uniqueinstance;
    }
    
    public JButtonEx  applyButton()
    {
        fr=new  JButtonEx("Sky");
        return fr;
    }
}

