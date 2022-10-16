package NQueensProblem;

public class SolveQueens {
    public static void main(String[] args) {
        int board[][] = {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}
        };
        if(!solve(board, 0)){
            System.out.println("this is not possible");
        }else{
            for (int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++){
                    System.out.print(board[i][j] + " ");

                }
                System.out.println("");
            }
        }

    }

    public static boolean isSafe(int board[][], int row, int col){

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {    //Check north west
            if(board[i][j] == 1){
                return false;
            }
        }
        for (int i = row, j = col; i < 8 && j >= 0; i++, j--) {    //Check south west
            if(board[i][j] == 1){
                return false;
            }
        }

        
        for (int i = 0; i <= col; i++) {
            if(board[row][i] == 1){
                return false;
            }
        }
        return true;


    }

    public static boolean solve(int board[][], int col){
        if(col>=8){
            return true;
        }
        for(int i = 0; i < 8; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solve(board, col + 1) == true) {
                    return true;
                } else {
                    board[i][col] = 0;
                }
            }
        }
        return false;

    }
}
