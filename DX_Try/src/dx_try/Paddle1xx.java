/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dx_try;

/**
 *
 * @author user
 */

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paddle1xx extends Sprite implements Commons {

    static int dx1;
   // private int dx2;

    public Paddle1xx() {

        ImageIcon ii = new ImageIcon("pad.jpg");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        resetState();
    }

    public void move1() {

        x += dx1;

        if (x <= 0) {
            x = 0;
        }

        if (x >= WIDTH - i_width) {
            x = WIDTH - i_width;
        }
    }
    
//    public void move2() {
//
//        x += dx2;
//
//        if (x <= 0) {
//            x = 0;
//        }
//
//        if (x >= WIDTH - i_width) {
//            x = WIDTH - i_width;
//        }
//    }
/*
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT ) {
            dx1 = -1;
        }

        if (key == KeyEvent.VK_RIGHT ) {
            dx1 = 1;
            
        }
        
//        if (key == KeyEvent.VK_A) {
//            dx2 = -1;
//        }

//        if (key == KeyEvent.VK_D) {
//            dx2 = 1;
//            
//        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            dx1 = 0; //dx2 = 0;
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            dx1 = 0; //dx2 = 0;
        }
    }
*/
    
    
    public static void keyPressed(String str) {

        String LEFT = "LEFT";
        String RIGHT = "RIGHT";
        
        if (LEFT.equalsIgnoreCase(str)) {
            dx1 = -1;
        }

        if (RIGHT.equalsIgnoreCase(str)) {
            dx1 = 1;
            
        }
    }

    public static void keyReleased(String str) {

        String X1 = "X1";
        String Y1 = "Y1";
        System.out.println("DIDIDI");
        if (X1.equalsIgnoreCase(str)) {
            dx1 = 0; 
            //dx2 = 0;
        }

        if (Y1.equalsIgnoreCase(str)) {
            dx1 = 0; 
           //dx2 = 0;
        }
    }
    
    
    private void resetState() {

        x = INIT_PADDLE_X;
        y = INIT_PADDLE_Y;
    }
}