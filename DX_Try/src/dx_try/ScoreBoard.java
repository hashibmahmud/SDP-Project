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

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class ScoreBoard extends JFrame  {
    public static void main(String [] args, int chk) {

        // The name of the file to open.
        String fileName = "score.txt";
            int i = chk;
            int p1 =0, p2=0, p3=0, p4=0, p5=0;
            int y=0; int count =0;
//        String str  = Integer.toString(i);
         String str1, str2, str3, str4, str5;
        // This will reference one line at a time
        String line = null;
        String scr = null;
        String player1 = "Player 1  : ";
        String player2 = "Player 2  : ";
        String player3 = "Player 3  : ";
        String player4 = "Player 4  : ";
        String player5 = "Player 5  : ";
        String chkScore = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

                line = bufferedReader.readLine();
                scr = line; //System.out.println(scr);
                
                line = bufferedReader.readLine();
                player1 = line; //System.out.println(player1);
                chkScore = player1.substring(12); //System.out.println(chkScore);
                    p1 = Integer.parseInt(chkScore);
                
                line = bufferedReader.readLine();
                player2 = line; //System.out.println(player2);
                chkScore = player2.substring(12); //System.out.println(chkScore);
                p2 = Integer.parseInt(chkScore);
                
                line = bufferedReader.readLine();
                player3 = line; //System.out.println(player3);
                chkScore = player3.substring(12); //System.out.println(chkScore);
                p3 = Integer.parseInt(chkScore);
                
                line = bufferedReader.readLine();
                player4 = line; //System.out.println(player4);
                chkScore = player4.substring(12); //System.out.println(chkScore);
                p4 = Integer.parseInt(chkScore);
                
                line = bufferedReader.readLine();
                player5 = line; //System.out.println(player5);
                chkScore = player5.substring(12); //System.out.println(chkScore);
                p5 = Integer.parseInt(chkScore);
                
                if(chk<p5){
                    
                }
                else if(chk<p4){
                    p5 = chk;
                }
                else if(chk<p3){
                    p5 = p4; p4 = chk;
                }
                else if(chk<p2){
                    p5 = p4; p4 = p3; p3 = chk;
                }
                else if(chk<p1){
                    p5 = p4; p4 = p3; p3 = p2; p2= chk;
                }
                else{
                    p5 = p4; p4 = p3; p3 = p2; p2= p1; p1=chk;
                }


            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        
        try {
            // Assume default encoding.
            
            String scrW = "    SCORE  BOARD";
            str1  = Integer.toString(p1);
        String player1W = "Player 1  : "+ str1;
            str2  = Integer.toString(p2);
        String player2W = "Player 2  : "+ str2;
            str3  = Integer.toString(p3);
        String player3W = "Player 3  : "+ str3;
            str4  = Integer.toString(p4);
        String player4W = "Player 4  : "+ str4;
            str5  = Integer.toString(p5);
        String player5W = "Player 5  : "+ str5;
            
            FileWriter fileWriter = new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(scrW);
            //bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
//            bufferedWriter.write("We are writing");
//            bufferedWriter.write(" the text to the file.");
//            bufferedWriter.newLine();
            bufferedWriter.write(player1W);
                        bufferedWriter.newLine();
            bufferedWriter.write(player2W);
                        bufferedWriter.newLine();
            bufferedWriter.write(player3W);
                        bufferedWriter.newLine();
            bufferedWriter.write(player4W);
            bufferedWriter.newLine();
            bufferedWriter.write(player5W);
//            bufferedWriter.newLine();
//            bufferedWriter.write(player3);
//            bufferedWriter.newLine();
//            bufferedWriter.write(player4);
//            bufferedWriter.newLine();
//            bufferedWriter.write(player5);
//            bufferedWriter.newLine();

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

//            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//            for(int i =0; i<5; i++){
//                line = bufferedReader.readLine();
//                
//            }
                line = bufferedReader.readLine();
                scr = line; System.out.println(scr);
                line = bufferedReader.readLine();
                player1 = line; System.out.println(player1);
                line = bufferedReader.readLine();
                player2 = line; System.out.println(player2);
                line = bufferedReader.readLine();
                player3 = line; System.out.println(player3);
                line = bufferedReader.readLine();
                player4 = line; System.out.println(player4);
                line = bufferedReader.readLine();
                player5 = line; System.out.println(player5);


            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout());
        String player;

        player = "<html>"+ player1 + "<br>"+ player2+"<br>"+player3+ "<br>"+ player4+"<br>"+ player5+"</html>";

            JLabel label = new JLabel(player);
            //label.setFont(14);
            label.setFont(new Font("Serif", Font.PLAIN, 40));
            frame.add(label);
            frame.pack();
            frame.setSize(300, 400);
            frame.setVisible(true);

    }
}

