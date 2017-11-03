/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//facade pattern
package dx_try;

import javax.swing.JButton;
/**
 * @author
 * Md. Aminul Islam 
 * Roll- 122
 * CSE, DU
 */
public class MultiPC implements Menu{
    JButton b;
    public JButton option()
    {
        b = new JButton("MultiPC Player");
        return b;
       
    }
    
    
}
