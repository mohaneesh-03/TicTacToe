package com.example.tictactoe;

public class Game {

    private final int[][] board;
    private int turn;

    public Game() {
        board = new int[3][3];
        turn = 1;
    }

    public int getTurn() {
        return turn;
    }

    public boolean checkvalid(int r, int c){
        return this.board[r][c] == 0;
    }

    public void setBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = 0;
            }
        }
    }

    public void setBoard(int r, int c) {
        this.board[r][c] =1;
    }

    public void setTurn() {
        if (this.turn == 1) this.turn = 2;
        else this.turn = 1;
    }
}
