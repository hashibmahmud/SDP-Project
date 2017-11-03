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

public class BoardA_UP_DOWN extends JPanel implements Commons {

    private Timer timer;
    private String message = "Game Over";
    public static Ball ball;
   public static BallA ballA;
  public static PaddleA paddleA;
    public static Paddle paddle;
    
    private Brick bricks[];
    
    private boolean ingame = true;
    
    JLabel label;
    JTextField text;
    
    JLabel labelA;
    JTextField textA;
    
    int kA=0;
    int lA=0;
    int one_out=0;
    int two_out=0;

    public BoardA_UP_DOWN() {

        initBoard();
    }

    private void initBoard() {
        
        // Add Score Box
        
        label = new JLabel("Player_1 : ");
        this.add(label);
        label.setForeground(Color.red);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        text = new JTextField("0", 6);
        this.add(text);
        
        
        labelA = new JLabel("Player_2 : ");
        this.add(labelA);
        labelA.setForeground(Color.GREEN);
        labelA.setFont(new Font("Serif", Font.BOLD, 20));
        textA = new JTextField("0", 6);
        this.add(textA);

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
        //ball = new Ball();
         elementFactory.getShape("ball",3);
        ball.draw();
        //ballA = new BallA();
        elementFactory.getShape("ballA",3);
        ballA.draw();
        //paddleA = new PaddleA();
        elementFactory.getShape("paddleA",3);
        paddleA.draw();
        //paddle = new Paddle();
         elementFactory.getShape("paddle",3);
         paddle.draw();;
       
        int k = 0;
        int i = 0;
        int j = 0;
        for ( i = 25; i < 25+10; i++) {
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
        
        g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(),
                ball.getWidth(), ball.getHeight(), this);
        g2d.drawImage(ballA.getImage(), ballA.getX(), ballA.getY(),
                ballA.getWidth(), ballA.getHeight(), this);
        g2d.drawImage(paddleA.getImage(), paddleA.getX(), paddleA.getY(),
                paddleA.getWidth(), paddleA.getHeight(), this);
        g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                paddle.getWidth(), paddle.getHeight(), this);

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
            paddleA.keyReleased(e);
            paddle.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            paddleA.keyPressed(e);
            paddle.keyPressed(e);
        }
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {

            ball.move();
            ballA.move();
            paddleA.move1();
            paddle.move2();
            checkCollision();
            repaint();
        }
    }

    private void stopGame() {

        ingame = false;
        timer.cancel();
    }

    private void checkCollision() {

        if (ball.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
            one_out =1;
        }
        if (ballA.getRect().getMaxY() < 10) {
            two_out =1;
        }   
        
        if (one_out == 1 && two_out == 1) {
            
            if (kA>lA) {
            message = "Player one win";
            }
            else if (kA<lA) {
            message = "Player two win";
            }
            else{
                message = "Scores are level";
            }
            
            stopGame();
            
        }
        
        for (int i = 0, j = 0; i < N_OF_BRICKS; i++) {
            
            if (bricks[i].isDestroyed()) {
                j++;
            }
            
            if (j == N_OF_BRICKS) {
                message = "Victory";
                
                stopGame();
            }
        }
        

        if ( (ball.getRect()).intersects(paddle.getRect()) ) {

            int paddleLPos = 0;

            if((ball.getRect()).intersects(paddle.getRect())){
                 paddleLPos = (int) paddle.getRect().getMinX();
            }
            //int paddleLPos = (int) paddle1.getRect().getMinX();
            int ballLPos = (int) ball.getRect().getMinX();

            int first = paddleLPos + 8;
            int second = paddleLPos + 16;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;

            if (ballLPos < first) {
                ball.setXDir(-1);
                ball.setYDir(-1);
            }

            if (ballLPos >= first && ballLPos < second) {
                ball.setXDir(-1);
                ball.setYDir(-1 * ball.getYDir());
            }

            if (ballLPos >= second && ballLPos < third) {
                ball.setXDir(0);
                ball.setYDir(-1);
            }

            if (ballLPos >= third && ballLPos < fourth) {
                ball.setXDir(1);
                ball.setYDir(-1 * ball.getYDir());
            }

            if (ballLPos > fourth) {
                ball.setXDir(1);
                ball.setYDir(-1);
            }
        }
        
        if ((ballA.getRect()).intersects(paddleA.getRect()) ) {

            int paddleLPos = 0;
            if((ballA.getRect()).intersects(paddleA.getRect())){
                 paddleLPos = (int) paddleA.getRect().getMinX();
            }
            
            //int paddleLPos = (int) paddle1.getRect().getMinX();
            int ballLPos = (int) ballA.getRect().getMinX();

            int first = paddleLPos + 8;
            int second = paddleLPos + 16;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;

            if (ballLPos < first) {
                ballA.setXDir(-1);
                ballA.setYDir(1);
            }

            if (ballLPos >= first && ballLPos < second) {
                ballA.setXDir(-1);
                ballA.setYDir(1 * ballA.getYDir());
            }

            if (ballLPos >= second && ballLPos < third) {
                ballA.setXDir(0);
                ballA.setYDir(1);
            }

            if (ballLPos >= third && ballLPos < fourth) {
                ballA.setXDir(1);
                ballA.setYDir(1 * ballA.getYDir());
            }

            if (ballLPos > fourth) {
                ballA.setXDir(1);
                ballA.setYDir(1);
            }
        }

        for (int i = 0; i < N_OF_BRICKS; i++) {
            int m=0; int n=0;
            if ((ball.getRect()).intersects(bricks[i].getRect()) || (ballA.getRect()).intersects(bricks[i].getRect()) ) {

                int ballLeft = (int) ball.getRect().getMinX();
                int ballHeight = (int) ball.getRect().getHeight();
                int ballWidth = (int) ball.getRect().getWidth();
                int ballTop = (int) ball.getRect().getMinY();
                
                
                int ballLeft1 = (int) ballA.getRect().getMinX();
                int ballHeight1 = (int) ballA.getRect().getHeight();
                int ballWidth1 = (int) ballA.getRect().getWidth();
                int ballTop1 = (int) ballA.getRect().getMinY();

                Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                Point pointLeft = new Point(ballLeft - 1, ballTop);
                Point pointTop = new Point(ballLeft, ballTop - 1);
                Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);
                
                Point pointRight1 = new Point(ballLeft1 + ballWidth1 + 1, ballTop1);
                Point pointLeft1 = new Point(ballLeft1 - 1, ballTop1);
                Point pointTop1 = new Point(ballLeft1, ballTop1 - 1);
                Point pointBottom1 = new Point(ballLeft1, ballTop1 + ballHeight1 + 1);

                if (!bricks[i].isDestroyed()) {
                    if (bricks[i].getRect().contains(pointRight)) {
                        ball.setXDir(-1);// ballA.setXDir(1);
                        m= 1;
                    } else if (bricks[i].getRect().contains(pointLeft)) {
                        ball.setXDir(1);// ballA.setXDir(-1);
                        m= 1;
                    }
                    if (bricks[i].getRect().contains(pointRight1)) {
                         ballA.setXDir(1);
                         n= 1;
                    } else if (bricks[i].getRect().contains(pointLeft1)) {
                        ballA.setXDir(-1);
                        n= 1;
                    }

                    if (bricks[i].getRect().contains(pointTop)) {
                        ball.setYDir(1);// ballA.setYDir(-1);
                        m= 1;
                    } else if (bricks[i].getRect().contains(pointBottom)) {
                        ball.setYDir(-1); //ballA.setYDir(1);
                        m= 1;
                    }
                    if (bricks[i].getRect().contains(pointTop1)) {
                        ballA.setYDir(1);
                        n= 1;
                    } else if (bricks[i].getRect().contains(pointBottom1)) {
                        ballA.setYDir(-1);
                        n= 1;
                    }

                    bricks[i].setDestroyed(true);
                    
                    if(m==1){
                        kA++;
                        text.setText(String.valueOf(kA));
                    }
                    
                   if(n==1){
                        lA++;
                        textA.setText(String.valueOf(lA));
                    }
                    
                }
            }
            
            
            
        }
    }
}