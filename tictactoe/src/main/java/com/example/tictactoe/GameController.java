package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class GameController {

    @FXML
    private ImageView im00;

    @FXML
    private ImageView im01;

    @FXML
    private ImageView im02;

    @FXML
    private ImageView im10;

    @FXML
    private ImageView im11;

    @FXML
    private ImageView im12;

    @FXML
    private ImageView im20;

    @FXML
    private ImageView im21;

    @FXML
    private ImageView im22;

    @FXML
    private Label lab;

    Game game = new Game();
    Player p1 = new Player();
    Player p2 = new Player();
    int cnt=0;
    boolean isWin = false;

    void reini(){
        Game game = new Game();
        Player p1 = new Player();
        Player p2 = new Player();
        int cnt=0;
        boolean isWin = false;
    }

    @FXML
    void setTile(MouseEvent event) {
        cnt++;
//        Game game = new Game();
//        Player p1 = new Player();
//        Player p2 = new Player();
        String source2 = event.getPickResult().getIntersectedNode().getId();
        ImageView clickedImageView = (ImageView) ((ImageView) event.getSource());
        System.out.println("ID: " + source2);
        char last = source2.charAt(source2.length()-1);
        char second = source2.charAt(source2.length()-2);
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
                imagePath = "src/main/java/com/example/images/X_modified.png";
            } else if (turn == 2) {
                imagePath = "src/main/java/com/example/images/o_modified.png";
            }

            File file = new File(imagePath);
            clickedImageView.setImage(new Image(file.toURI().toString()));

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
            if(isWin) reini();

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
