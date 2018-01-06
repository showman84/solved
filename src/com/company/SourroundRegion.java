package com.company;

public class SourroundRegion {

    public void solve(char[][] board) {

        int size = board.length;



        int col=board[0].length;

        for (int i = 0; i < size; i++) {

            fillRegion(board, i, 0, size, col);
            fillRegion(board, i, board[0].length - 1, size, col);
        }

        for (int i = 0; size > 0 && i < board[0].length; i++) {

            fillRegion(board, 0, i, size, col );
            fillRegion(board, size - 1, i, size, col );
        }

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

            }

        }


        for (int i = 0; i < size; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }

            }

        }



    }

    public void fillRegion(char[][] vec, int i, int j, int row, int col) {

        if(vec[i][j]=='O'){
            vec[i][j]='1';
            if(i>1)
                fillRegion(vec,i-1,j,row,col);
            if(j>1)
                fillRegion(vec,i,j-1,row,col);
            if(i+1<row)
                fillRegion(vec,i+1,j,row,col);
            if(j+1<col)
                fillRegion(vec,i,j+1,row,col);
        }

    }

    public static void main(String[] args) {

        char A[][] =   {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};

       new SourroundRegion().solve(A);
       System.out.println(A);

    }
}
