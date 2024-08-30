package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class GameController {

    @FXML
    private Button bt00;

    @FXML
    private Button bt01;

    @FXML
    private Button bt02;

    @FXML
    private Button bt10;

    @FXML
    private Button bt11;

    @FXML
    private Button bt12;

    @FXML
    private Button bt20;

    @FXML
    private Button bt21;

    @FXML
    private Button bt22;

    @FXML
    private Label lab;

    Game game;
    Player p1;
    Player p2;
    int cnt;
    boolean isWin;

    public void reini(){
        game = new Game();
        p1 = new Player();
        p2 = new Player();
        cnt=0;
        isWin = false;
        game.setBoard();
        lab.setText("Player1's Turn");
        bt00.setText("");
        bt01.setText("");
        bt02.setText("");
        bt10.setText("");
        bt11.setText("");
        bt12.setText("");
        bt20.setText("");
        bt21.setText("");
        bt22.setText("");
    }

    @FXML
    void setTile(ActionEvent event) {
        if(cnt==0) reini();
        if(isWin) reini();
        cnt++;
//        Game game = new Game();
//        Player p1 = new Player();
//        Player p2 = new Player();
        Button clickedButton = (Button) (event.getSource());
        String buttonId = clickedButton.getId();
        System.out.println("ID: " + buttonId);
        char last = buttonId.charAt(buttonId.length()-1);
        char second = buttonId.charAt(buttonId.length()-2);
        int row = Character.getNumericValue(last);
        int col = Character.getNumericValue(second);
        int turn = game.getTurn();

        System.out.println("Turn: " + game.getTurn());
        System.out.println(game.checkvalid(row, col));
        if (game.checkvalid(row, col)) {
            game.setBoard(row, col);
            System.out.println(game.checkvalid(row, col));

            String imagePath = "";
            if (turn == 1) {
                clickedButton.setText("X");
            } else if (turn == 2) {
                clickedButton.setText("O");
            }

            if (turn == 1) {
                if (row == col) {
                    p1.setD1();
                    if (p1.getD1() == 3) {
                        lab.setText("Player 1 wins");
                        isWin = true;
                    }
                }

                if (row + col == 2) {
                    p1.setD2();
                    if (p1.getD2() == 3) {
                        lab.setText("Player 1 wins");
                        isWin = true;
                    }
                }

                p1.setCol(col);
                if (p1.getCol(col) == 3) {
                    lab.setText("Player 1 wins");
                    isWin = true;
                }

                p1.setRow(row);
                if (p1.getRow(row) == 3) {
                    lab.setText("Player 1 wins");
                    isWin = true;
                }
            } else {
                if (row == col) {
                    p2.setD1();
                    if (p2.getD1() == 3) {
                        lab.setText("Player 2 wins");
                        isWin = true;
                    }
                }

                if (row + col == 2) {
                    p2.setD2();
                    if (p2.getD2() == 3) {
                        lab.setText("Player 2 wins");
                        isWin = true;
                    }
                }

                p2.setCol(col);
                if (p2.getCol(col) == 3) {
                    lab.setText("Player 2 wins");
                    isWin = true;
                }

                p2.setRow(row);
                if (p2.getRow(row) == 3) {
                    lab.setText("Player 2 wins");
                    isWin = true;
                }
            }
            game.setTurn();
            if (!isWin) {
                lab.setText("Player " + game.getTurn() + "'s Turn");
            }
            if(cnt==9 && !isWin) lab.setText("Game Tied");


        } else {
            System.out.println("Invalid move");
        }
//        if(game.checkvalid(row, col)) {
//            game.setBoard(row, col);
//            if(turn ==1){
//                File f1 = new File("src/main/java/com/example/images/X_modified.png");
//                clickedImageView.setImage(new Image(f1.toURI().toString()));
//            }
//            if(turn ==2){
//                File f2 = new File("src/main/java/com/example/images/o_modified.png");
//                clickedImageView.setImage(new Image(f2.toURI().toString()));
//            }
//            if(row == col) {
//                if (turn == 1) {
//                    p1.setD1();
//                    if(p1.getD1() == 3) lab.setText("Player 1 wins");
//                } else {
//                    p2.setD1();
//                    if(p2.getD1() == 3) lab.setText("Player 2 wins");
//                }
//            }
//            if(row+col == 2){
//                if (turn == 1) {
//                    p1.setD2();
//                    if(p1.getD2() == 3) lab.setText("Player 1 wins");
//                }
//                else {
//                    p2.setD2();
//                    if(p2.getD2() == 3) lab.setText("Player 2 wins");
//                }
//            }
//            if(turn ==1){
//                p1.setCol(col);
//                if(p1.getCol(col) == 3) lab.setText("Player 1 wins");
//                p1.setRow(row);
//                if(p1.getRow(row) == 3) lab.setText("Player 1 wins");
//            }
//            else if(turn==2){
//                p2.setCol(col);
//                if(p2.getCol(col) == 3) lab.setText("Player 2 wins");
//                p2.setRow(row);
//                if(p2.getRow(row) == 3) lab.setText("Player 2 wins");
//            }
//            game.setTurn();
//            lab.setText("Player"+game.getTurn()+"'s Turn");
//        }
//        else System.out.println("Invalid");

    }


}
