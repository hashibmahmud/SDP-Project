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
//import static game_server.Game_server.socketA;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.swing.ImageIcon;

public class Paddlex extends Sprite implements Commons {

   // private int dx1;
    private int dx2;

    public Paddlex() {

        ImageIcon ii = new ImageIcon("padd.jpg");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        resetState();
    }

//    public void move1() {
//
//        x += dx1;
//
//        if (x <= 0) {
//            x = 0;
//        }
//
//        if (x >= WIDTH - i_width) {
//            x = WIDTH - i_width;
//        }
//    }
    
    public void move2() {

        x += dx2;

        if (x <= 0) {
            x = 0;
        }

        if (x >= WIDTH - i_width) {
            x = WIDTH - i_width;
        }
    }

    public void keyPressed(KeyEvent e) throws IOException {

        int key = e.getKeyCode();

//        if (key == KeyEvent.VK_LEFT ) {
//            dx1 = -1;
//        }
//
//        if (key == KeyEvent.VK_RIGHT ) {
//            dx1 = 1;
//            
//        }
        
        if (key == KeyEvent.VK_A) {
            dx2 = -1;
            String A = "A";
//            DX_Try.action(A);
            ModeSelection.action(A);
            
        }

        if (key == KeyEvent.VK_D) {
            dx2 = 1;
            String D ="D";
//            DX_Try.action(D);
            ModeSelection.action(D);
        }
    }

    public void keyReleased(KeyEvent e) throws IOException {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
           // dx1 = 0; 
            dx2 = 0;
            String X ="X";
            //DX_Try.action(X );
            ModeSelection.action(X);
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
           // dx1 = 0; 
           dx2 = 0;
           String Y ="Y";
           // DX_Try.action(Y );
           ModeSelection.action(Y);
        }
    }

    private void resetState() {

        x = INIT_PADDLE_X;
        y = INIT_PADDLE_Y;
    }
}