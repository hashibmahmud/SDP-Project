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
public class ChoseMenu {
    private Menu play;
    private Menu play2;
    private Menu singlePlayer;
    private Menu multiPC;
    
    public ChoseMenu()
    {
        play=new Play();
        play2=new Play2();
        singlePlayer=new SinglePlayer();
        multiPC=new MultiPC();
                
        
    }
    
    public JButton implementPlay()
    {
        return play.option();
    }
    
    
    public JButton implementPlay2()
    {
        return play2.option();
    }
    
     public JButton implementSinglePlayer()
    {
        return singlePlayer.option();
    }
     
     public JButton implementMultiPC()
    {
        return multiPC.option();
    }
    
    
    
}
