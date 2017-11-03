/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//facade pattern
package dx_try;
/**
 * @author
 * Md. Aminul Islam 
 * Roll- 122
 * CSE, DU
 */
import javax.swing.JButton;


public class Play2 implements Menu{
    JButton b;
    public JButton option()
    {
        b = new JButton("Play UP-DOWN MODE");
        return b;
       
    }
    
}
