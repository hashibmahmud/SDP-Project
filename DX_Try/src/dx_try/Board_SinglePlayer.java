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

/**
    * @author
    * Hashib Mahmud
    * Roll- 106
    * CSE,DU
    */

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Board_SinglePlayer extends JPanel implements Commons {
    
    private Timer timer;
    private String message = "    Game Over";
//    private Ball ball;
    public static Ball1 ball1;
  public static Paddle1 paddle1;
//    private Paddle paddle;
    
    private Brick bricks[];
    
    private boolean ingame = true;
    
    JLabel label;
    JTextField text;

    int kA=0;
   
    public Board_SinglePlayer() {

        initBoard();
    }

    private void initBoard() {

        
        label = new JLabel("Score : ");
        this.add(label);
        label.setForeground(Color.red);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        text = new JTextField("0", 6);
        this.add(text);

        addKeyListener(new TAdapter());
        setFocusable(true);

        bricks = new Brick[N_OF_BRICKS];
        
        setDoubleBuffered(true);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), DELAY, PERIOD);
    }

    @Override
    public void addNotify() {

        super.addNotify();
        gameInit();
    }
    
    /**
    * @author
    * Hashib Mahmud
    * Roll- 106
    * CSE,DU
    */
    // Factory Pattern Implementation
    private void gameInit() {
 ElementFactory elementFactory=new ElementFactory();

        elementFactory.getShape("ball1",2);
        ball1.draw();
        System.out.println(ball1);
        elementFactory.getShape("paddle1",2);
        paddle1.draw();
        int k = 0;
        int i = 0;
        int j = 0;
        for ( i = 0; i < 10; i++) {
            for ( j = 0; j <20 ; j++) {
                bricks[k] = new Brick(j * 40 + 30, i * 10 + 50);
                k++;
            }
        }   
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        if (ingame) {
            
            drawObjects(g2d);
        } else {

            gameFinished(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawObjects(Graphics2D g2d) {
 
        g2d.drawImage(ball1.getImage(), ball1.getX(), ball1.getY(),
                ball1.getWidth(), ball1.getHeight(), this);
        g2d.drawImage(paddle1.getImage(), paddle1.getX(), paddle1.getY(),
                paddle1.getWidth(), paddle1.getHeight(), this);

        for (int i = 0; i < N_OF_BRICKS; i++) {
            if (!bricks[i].isDestroyed()) {
                g2d.drawImage(bricks[i].getImage(), bricks[i].getX(),
                        bricks[i].getY(), bricks[i].getWidth(),
                        bricks[i].getHeight(), this);
            }
        }
    }
    
    private void gameFinished(Graphics2D g2d) {

        Font font = new Font("Verdana", Font.BOLD, 40);
        FontMetrics metr = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(message, 185, 185);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
        }
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {

            ball1.move();
            paddle1.move1();

            checkCollision();
            repaint();
        }
    }

    private void stopGame() {

        ingame = false;
        timer.cancel();
    }

    private void checkCollision() {

        if (ball1.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
            String[] args=null;

            ScoreBoard.main(args, kA);
            stopGame();

        }

        
        for (int i = 0, j = 0; i < N_OF_BRICKS; i++) {
            
            if (bricks[i].isDestroyed()) {
                j++;

            }
            
            if (j == N_OF_BRICKS) {
                message = "Victory";
                String[] args=null;
            ScoreBoard.main(args, kA);
                stopGame();
            }
        }
 
        if ((ball1.getRect()).intersects(paddle1.getRect()) ) {

            int paddleLPos = 0;
            if((ball1.getRect()).intersects(paddle1.getRect())){
                 paddleLPos = (int) paddle1.getRect().getMinX();
            }
            
            //int paddleLPos = (int) paddle1.getRect().getMinX();
            int ballLPos = (int) ball1.getRect().getMinX();

            int first = paddleLPos + 8;
            int second = paddleLPos + 16;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;

            if (ballLPos < first) {
                ball1.setXDir(-1);
                ball1.setYDir(-1);
            }

            if (ballLPos >= first && ballLPos < second) {
                ball1.setXDir(-1);
                ball1.setYDir(-1 * ball1.getYDir());
            }

            if (ballLPos >= second && ballLPos < third) {
                ball1.setXDir(0);
                ball1.setYDir(-1);
            }

            if (ballLPos >= third && ballLPos < fourth) {
                ball1.setXDir(1);
                ball1.setYDir(-1 * ball1.getYDir());
            }

            if (ballLPos > fourth) {
                ball1.setXDir(1);
                ball1.setYDir(-1);
            }
        }


        
        for (int i = 0; i < N_OF_BRICKS; i++) {
            int m=0; int n=0;
            if ((ball1.getRect()).intersects(bricks[i].getRect()) ) {

                
                int ballLeft1 = (int) ball1.getRect().getMinX();
                int ballHeight1 = (int) ball1.getRect().getHeight();
                int ballWidth1 = (int) ball1.getRect().getWidth();
                int ballTop1 = (int) ball1.getRect().getMinY();

                Point pointRight1 = new Point(ballLeft1 + ballWidth1 + 1, ballTop1);
                Point pointLeft1 = new Point(ballLeft1 - 1, ballTop1);
                Point pointTop1 = new Point(ballLeft1, ballTop1 - 1);
                Point pointBottom1 = new Point(ballLeft1, ballTop1 + ballHeight1 + 1);

                if (!bricks[i].isDestroyed()) {

                    if (bricks[i].getRect().contains(pointRight1)) {
                        
                        n= 1;
                        
                         ball1.setXDir(-1);
                    } else if (bricks[i].getRect().contains(pointLeft1)) {
                        
                       n= 1;
                        
                        ball1.setXDir(1);
                    }

                    if (bricks[i].getRect().contains(pointTop1)) {
                        
                        n= 1;
                        
                        ball1.setYDir(1);
                    } else if (bricks[i].getRect().contains(pointBottom1)) {
                        
                        n= 1;
                        
                        ball1.setYDir(-1);
                    }

                    bricks[i].setDestroyed(true);
                    
                    if(n==1){
                        kA++;
                        text.setText(String.valueOf(kA));
                    }

                }
            }

        }
    }
}