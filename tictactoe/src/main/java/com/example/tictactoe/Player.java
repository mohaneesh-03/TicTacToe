package com.example.tictactoe;

public class Player {
    private int[][] played;
    private int d1;
    private int d2;
    private int[] row;
    private int[] col;

    Player(){
        this.d1 = 0;
        this.d2 = 0;
        this.col = new int[3];
        this.row = new int[3];
    }

    public void turn(int r, int c){

    }

    public int getD1() {
        return d1;
    }
    public int getD2() {
        return d2;
    }

    public void setD1() {
        this.d1++;
    }
    public void setD2() {
        this.d2++;
    }

    public int getRow(int r) {
        return row[r];
    }

    public int getCol(int c) {
        return col[c];
    }

    public int setCol(int c) {
        this.col[c]++;
        return this.col[c];
    }

    public int setRow(int r) {
        this.row[r]++;
        return this.row[r];
    }
}
