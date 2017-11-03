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

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Paddle1 extends Sprite implements Commons,Factory {

    private int dx1;
   // private int dx2;

    public void draw() {

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

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT ) {
            dx1 = -2;
        }

        if (key == KeyEvent.VK_RIGHT ) {
            dx1 = 2;
            
        }
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

    private void resetState() {

        x = INIT_PADDLE_X;
        y = INIT_PADDLE_Y;
    }
}