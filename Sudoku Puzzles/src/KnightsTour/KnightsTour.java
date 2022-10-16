package KnightsTour;

public class KnightsTour {
    public static void main(String[] args) {
        int board[][] = {
                {1,0,0,0,0,0,0,0},  //mark first square as visited
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}
        };
        if(solve(board,0,0, 2)){
            printBoard(board);
        }else{
            System.out.println("this sucks");
        }


    }

    public static boolean solve(int board[][], int row, int col, int i){
        if(i == 65){
            return true;
        }
//        printBoard(board);
            if(isValid(board,row-1,col-2)){ //option 1
                row -=1;
                col -=2;
                board[row][col] = i;
                i++;
                if(solve(board,row,col, i)){
                    return true;
                }else{
                    board[row][col] = 0;
                    row += 1;
                    col += 2;
                    i--;
                }

            }if(isValid(board,row-2,col-1)){   //option 2
                row -= 2;
                col -= 1;
                board[row][col] = i;
                i++;
                if(solve(board,row,col, i)){
                    return true;
                }else{
                    board[row][col] = 0;
                    row += 2;
                    col += 1;
                    i--;
                }

            }if(isValid(board,row-2,col+1)){   //option 3
                row -= 2;
                col += 1;
                board[row][col] = i;
                i++;
                if(solve(board,row,col, i)){
                    return true;
                }else{
                    board[row][col] = 0;
                    row += 2;
                    col -= 1;
                    i--;
                }

            }if(isValid(board,row-1,col+2)){ //option 4
                row -= 1;
                col += 2;
                board[row][col] = i;
                i++;
                if(solve(board,row,col, i)){
                    return true;
                }else{
                    board[row][col] = 0;
                    row += 1;
                    col -= 2;
                    i--;
                }

            }if(isValid(board,row+1,col+2)){ //option 5
                row += 1;
                col += 2;
                board[row][col] = i;
                i++;
                if(solve(board,row,col, i)){
                    return true;
                }else{
                    board[row][col] = 0;
                    row -= 1;
                    col -= 2;
                    i--;
                }

            }if(isValid(board,row+2,col+1)){//option 6
                row += 2;
                col += 1;
                board[row][col] = i;
                i++;
                if(solve(board,row,col, i)){
                    return true;
                }else{
                    board[row][col] = 0;
                    row -= 2;
                    col -= 1;
                    i--;
                }

            }if(isValid(board,row+2,col-1)){//option 7
                row += 2;
                col -= 1;
                board[row][col] = i;
                i++;
                if(solve(board,row,col,i)){
                    return true;
                }else{
                    board[row][col] = 0;
                    row -= 2;
                    col += 1;
                    i--;
                }

            }if(isValid(board,row+1,col-2)){//option 8
                row += 1;
                col -= 2;
                board[row][col] = i;
                i++;
                if(solve(board,row,col,i)){
                    return true;
                }else{
                    board[row][col] = 0;
                    row -= 1;
                    col += 2;
                    i--;
                }

            }


        return false;
    }
    public static boolean isValid(int board[][], int row, int col){
        if(row >= 0 && row <= 7 && col >= 0 && col <= 7 && board[row][col] == 0){
            return true;
        }
        return false;
    }
    public static boolean completed(int board[][]){
        for (int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void printBoard(int[][] board){
        for (int i = 0; i < 8; i++) {
            System.out.print(i+1 + ": ");
            for(int j = 0; j < 8; j++){
                System.out.printf("%3d ", board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
