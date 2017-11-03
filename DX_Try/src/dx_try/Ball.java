/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dx_try;
/**
 * @author 
 * Md. Mahmudul hasan
 * Dept- CSE, DU
 * Roll- 28
 */
import javax.swing.ImageIcon;
import java.util.Random;

public class Ball extends Sprite implements Commons {

    private int xdir;
    private int ydir;

    public void draw() {

        xdir = 1;
        ydir = -1;

        ImageIcon ii = new ImageIcon("ball2.jpg");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        resetState();
    }

    public void move() {
        
        x += xdir;
        y += ydir;

        if (x == 0) {
            setXDir(1);
        }

        if (x == WIDTH - i_width) {
            setXDir(-1);
        }

        if (y == 0) {
            setYDir(1);
        }
    }

    private void resetState() {
        
        
        x = INIT_BALL_X;
        y = INIT_BALL_Y;
    }

    public void setXDir(int x) {
        xdir = x;
    }

    public void setYDir(int y) {
        ydir = y;
    }

    public int getYDir() {
        return ydir;
    }
}