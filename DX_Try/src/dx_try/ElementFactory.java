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
public class ElementFactory {
    public void getShape(String str,int n)
    {
        if(str.equalsIgnoreCase("ball"))
        {
        if(n==1)
        BoardTwoDown.ball=new Ball();
        if(n==3)
            BoardA_UP_DOWN.ball=new Ball();
        
        }
        if(str.equalsIgnoreCase("ball1"))
        {
            if(n==1)
            BoardTwoDown.ball1=new Ball1();
            if(n==2)
            Board_SinglePlayer.ball1=new Ball1();
        }
         if(str.equalsIgnoreCase("ballA"))
        {
        
        if(n==3)
            BoardA_UP_DOWN.ballA=new BallA();
        
        }
         if(str.equalsIgnoreCase("paddle1"))
        {
            if(n==1)
            BoardTwoDown.paddle1=new Paddle1();
            if(n==2)
                Board_SinglePlayer.paddle1=new Paddle1();
            
        }
        
        if(str.equalsIgnoreCase("paddle"))
        {
            if(n==1)
            BoardTwoDown.paddle=new Paddle();
            if(n==3)
                BoardA_UP_DOWN.paddle=new Paddle();
            
        }
        if(str.equalsIgnoreCase("paddleA"))
        {
            
            if(n==3)
                BoardA_UP_DOWN.paddleA=new PaddleA();
            
        }
        
      
    }

    

   
    
    
}
