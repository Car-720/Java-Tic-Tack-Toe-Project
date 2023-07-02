package java_tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{

    Random rndm = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] btns = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe Tutorial");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i = 0; i < 9; i++) {
            btns[i] = new JButton();
            button_panel.add(btns[i]);
            btns[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            btns[i].setFocusable(false);
            btns[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 9; i++) {
            if(e.getSource() == btns[i]){
                if(player1_turn) {
                    if(btns[i].getText() == ""){
                        btns[i].setForeground(new Color(255,0,0));
                        btns[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turns");
                        check();
                    }
                } else {
                    if(btns[i].getText() == ""){
                        btns[i].setForeground(new Color(0,0,255));
                        btns[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turns");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        if(rndm.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        //Check X win conditions
        if(
            (btns[0].getText() == "X") && 
            (btns[1].getText() == "X") &&
            (btns[2].getText() == "X")){
              xWins(0,1,2);  
        }
        if(
            (btns[3].getText() == "X") && 
            (btns[4].getText() == "X") &&
            (btns[5].getText() == "X")){
              xWins(3,4,5);  
        }
        if(
            (btns[6].getText() == "X") && 
            (btns[7].getText() == "X") &&
            (btns[8].getText() == "X")){
              xWins(6,7,8);  
        }
        if(
            (btns[0].getText() == "X") && 
            (btns[3].getText() == "X") &&
            (btns[6].getText() == "X")){
              xWins(0,3,6);  
        }
        if(
            (btns[1].getText() == "X") && 
            (btns[4].getText() == "X") &&
            (btns[7].getText() == "X")){
              xWins(1,4,7);  
        }
        if(
            (btns[2].getText() == "X") && 
            (btns[5].getText() == "X") &&
            (btns[8].getText() == "X")){
              xWins(2,5,8);  
        }
        if(
            (btns[0].getText() == "X") && 
            (btns[4].getText() == "X") &&
            (btns[8].getText() == "X")){
              xWins(0,4,8);  
        }
        if(
            (btns[2].getText() == "X") && 
            (btns[4].getText() == "X") &&
            (btns[6].getText() == "X")){
              xWins(2,4,6);  
        }

        //O win conditions
        if(
            (btns[0].getText() == "O") && 
            (btns[1].getText() == "O") &&
            (btns[2].getText() == "O")){
              oWins(0,1,2);  
        }
        if(
            (btns[3].getText() == "O") && 
            (btns[4].getText() == "O") &&
            (btns[5].getText() == "O")){
              oWins(3,4,5);  
        }
        if(
            (btns[6].getText() == "O") && 
            (btns[7].getText() == "O") &&
            (btns[8].getText() == "O")){
              oWins(6,7,8);  
        }
        if(
            (btns[0].getText() == "O") && 
            (btns[3].getText() == "O") &&
            (btns[6].getText() == "O")){
              oWins(0,3,6);  
        }
        if(
            (btns[1].getText() == "O") && 
            (btns[4].getText() == "O") &&
            (btns[7].getText() == "O")){
              oWins(1,4,7);  
        }
        if(
            (btns[2].getText() == "O") && 
            (btns[5].getText() == "O") &&
            (btns[8].getText() == "O")){
              oWins(2,5,8);  
        }
        if(
            (btns[0].getText() == "O") && 
            (btns[4].getText() == "O") &&
            (btns[8].getText() == "O")){
              oWins(0,4,8);  
        }
        if(
            (btns[2].getText() == "O") && 
            (btns[4].getText() == "O") &&
            (btns[6].getText() == "O")){
              oWins(2,4,6);  
        }
    }

    public void xWins(int a, int b, int c) {
        btns[a].setBackground(Color.GREEN);
        btns[b].setBackground(Color.GREEN);
        btns[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        btns[a].setBackground(Color.GREEN);
        btns[b].setBackground(Color.GREEN);
        btns[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }
        textfield.setText("O wins");
    }
}
