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
//import game_server.DX_Tryx;
//import game_server.Game_server;
//import static game_server.Game_server.socketA;
//import game_server.Paddle1x;
import java.awt.EventQueue;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

class chkVariable {
    public static int a = 0;
    
} 

class JButtonEx extends JFrame implements ActionListener{
    
    JButton b;
    JButton bA;
    JButton singlePlayer;
    JButton multiPC_Player;
    
    JButtonEx (String title){
        super(title);
        setLayout(new FlowLayout());
        ChoseMenu choseMenu=new ChoseMenu();
        b=choseMenu.implementPlay();
        //b = new JButton("Play");
        b.addActionListener(this);
        add(b);
        
        //bA = new JButton("Play __ A");
        bA=choseMenu.implementPlay2();
        bA.addActionListener(this);
        add(bA);
        
        //singlePlayer = new JButton("SINGLE PLAYER");
        singlePlayer=choseMenu.implementSinglePlayer();
        singlePlayer.addActionListener(this);
        add(singlePlayer);
        
        ////multiPC_Player = new JButton("multiPC PLAYER");
        multiPC_Player=choseMenu.implementMultiPC();
        multiPC_Player.addActionListener(this);
        add(multiPC_Player);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent evt){
        getContentPane().setBackground(Color.red);
        repaint();
        Object src = evt.getSource();
        setVisible(false);
        if(src == b){
            int a = 7;
            BrickBreaker.run(a);
        }
        else if(src == bA){
            int aa = 77;
            BrickBreaker.run(aa);
        }
        else if(src == singlePlayer){
            int aaa = 777;
            BrickBreaker.run(aaa);
        }
        else if(src == multiPC_Player){
            int aaa = 7777;
            BrickBreaker.run(aaa);
        }
        
      //  DX_Try.run();
       
    }

}

class ModeSelection extends JFrame implements ActionListener{
    
    JButton MultiPC;
    JButton SinglePC;
    int chk =0;
    
    ModeSelection (String title){
        super(title);
        setLayout(new FlowLayout());
        
        MultiPC = new JButton("MultiPC: Two Player");
        MultiPC.addActionListener(this);
        add(MultiPC);
        
        SinglePC = new JButton("SinglePC: One/Two Player");
        SinglePC.addActionListener(this);
        add(SinglePC);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent evt){
        getContentPane().setBackground(Color.red);
        repaint();
        Object src = evt.getSource();
        setVisible(false);
        if(src == MultiPC){
            
            //*************
            try {

                connect_server();
            } catch (IOException ex) {
                Logger.getLogger(ModeSelection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // *****
        }
        
        /**
        * @author
        * Hashib Mahmud
        * Roll- 106
        * CSE,DU
        */
         // Singleton Pattern 
        else if(src == SinglePC){

            JButtonEx frm;

            Singleton object=new Singleton();
              frm= object.applyButton();

            frm.setSize(300, 400);
            frm.setVisible(true);

        }
    }
    public static Socket socketA = null;
///     **************************************************
    public void connect_server() throws IOException {
        
        
        try
        {
 
            int port = 2555;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");

                socketA = serverSocket.accept();
                System.out.println("Server Started and listening to the port 25000");
                InputStream isA = socketA.getInputStream();
                InputStreamReader isrA = new InputStreamReader(isA);
                BufferedReader brA = new BufferedReader(isrA);
                String numberA = brA.readLine();
                System.out.println("Message received from client is "+numberA);
                String returnMessageA;

                try
                {
                    int numberInIntFormatA = Integer.parseInt(numberA);
                    int returnValueA = numberInIntFormatA*2;
                    returnMessageA = String.valueOf(returnValueA) + "\n";

                }
                catch(NumberFormatException e)
                {
                    returnMessageA = "Please send a proper number\n";
                }
 
                //Sending the response back to the client.
                OutputStream osA = socketA.getOutputStream();
                OutputStreamWriter oswA = new OutputStreamWriter(osA);
                BufferedWriter bwA = new BufferedWriter(oswA);
                bwA.write(returnMessageA);
                System.out.println("Message sent to the client is "+returnMessageA);
                bwA.flush();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String[] args = null;
      int aaaa =7777;
      BrickBreaker.playMultiPC();
                while(true){
                    InputStream isA = socketA.getInputStream();
                InputStreamReader isrA = new InputStreamReader(isA);
                BufferedReader brA = new BufferedReader(isrA);
                
                 String message;
                    message = brA.readLine();
                    System.out.println("Take : " +message);
                    
                    String LEFT = "LEFT";
                    String RIGHT = "RIGHT";
                    String X1 = "X1";
                    String Y1 = "Y1";

                    if(LEFT.equalsIgnoreCase(message) || RIGHT.equalsIgnoreCase(message)){
                        Paddle1xx.keyPressed(message);
                    }
                    if(X1.equalsIgnoreCase(message) || Y1.equalsIgnoreCase(message)){
                        Paddle1xx.keyReleased(message);
                    }
                
                }
    }
    
    static void action(String str) throws IOException {
        OutputStream osA = socketA.getOutputStream();
                OutputStreamWriter oswA = new OutputStreamWriter(osA);
                BufferedWriter bwA = new BufferedWriter(oswA);
        String D = "D";
        String A = "A";
        String X = "X";
        String Y = "Y";
        if(A.equalsIgnoreCase(str)){
            A = A + "\n";
            bwA.write(A);
                System.out.println("Give "+A);
                bwA.flush();
        }
        if(D.equalsIgnoreCase(str)){
            D = D + "\n";
            bwA.write(D);
                System.out.println("Give "+D);
                bwA.flush();
        }
        if(X.equalsIgnoreCase(str)){
            X = X + "\n";
            bwA.write(X);
                System.out.println("Give "+X);
                bwA.flush();
        }
        if(Y.equalsIgnoreCase(str)){
            Y = Y + "\n";
            bwA.write(Y);
                System.out.println("Give "+Y);
                bwA.flush();
        }
                
    }

    
    
    
///     ***************************************************
}


/**
 * @author
 * Md. Mahmudul Hasan
 * Roll- 28
 * CSE,DU
 */
    // State PAttern
class BoardAddition{
    private State currentState;
    
    public BoardAddition(int chk) {
        if(chk== 7){
            currentState = new Board_down_two(); 
        }
        if(chk== 77){
            currentState = new Board_up_down(); 
        }
        if(chk== 777){
            currentState = new Board_single(); 
        }
        if(chk== 7777){
            currentState = new Board_multi_server(); 
        }
        
    }

    public void set_state(State s) {
        currentState = s;
    }

    public void addBoard(int a) {
        currentState.addBoard(this);
    }
}

class initial extends JFrame implements State {
    
    

    public void addBoard(BoardAddition BA) {
        
        JButtonEx frm;
            frm = new JButtonEx("Brick Breaker");

            frm.setSize(300, 400);
            frm.setVisible(true);
    }
}

class Board_down_two extends JFrame implements State {
    
    

    public void addBoard(BoardAddition BA) {
        System.out.println("GOT IT----->>");
        add(new BoardTwoDown());
        
        setTitle("Brick Breaker");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.WIDTH, Commons.HEIGTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        BA.set_state(new initial());
    }
}

class Board_up_down extends JFrame implements State {

    public void addBoard(BoardAddition BA) {
        add(new BoardA_UP_DOWN());
        
        setTitle("Brick Breaker");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.WIDTH, Commons.HEIGTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        BA.set_state(new initial());
    }
}

class Board_single extends JFrame implements State {

    public void addBoard(BoardAddition BA) {
        add(new Board_SinglePlayer());
        
        setTitle("Brick Breaker");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.WIDTH, Commons.HEIGTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        BA.set_state(new initial());
    }
}

class Board_multi_server extends JFrame implements State {

    public void addBoard(BoardAddition BA) {
        add(new Board_multiPCserver());
        
        setTitle("Brick Breaker");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.WIDTH, Commons.HEIGTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        BA.set_state(new initial());
    }
}

public class BrickBreaker extends JFrame{
    
    public BrickBreaker(int a) {

        BoardAddition boardaddition = new BoardAddition(a);
        boardaddition.addBoard(a);
    }
    
  
    
   public static void main(String[] args) throws IOException {

        if(chkVariable.a ==0){
            ModeSelection modeSelect;
        modeSelect = new ModeSelection("ModeSelection");
        
        modeSelect.setSize(300, 400);
        modeSelect.setVisible(true);
        }
        
        if(chkVariable.a ==1){
         //   Game_server.main(args);
        }
        
        
    }
    
    public static void run(int a) {      
        int aa = a;
                BrickBreaker game = new BrickBreaker(aa);
                
                game.setVisible(true); 
                 
            }
    
    public static void playMultiPC() {
        JButtonEx frm;
            frm = new JButtonEx("Brick Breaker");

            frm.setSize(300, 400);
            frm.setVisible(true);
    }
}
