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
import javax.swing.ImageIcon;

public class BrickA extends Sprite {

    private boolean destroyed;

    public BrickA(int x, int y) {
        
        this.x = x;
        this.y = y;

        ImageIcon ii = new ImageIcon("brick.jpg");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        destroyed = false;
    }

    public boolean isDestroyed() {
        
        return destroyed;
    }

    public void setDestroyed(boolean val) {
        
        destroyed = val;
    }
}