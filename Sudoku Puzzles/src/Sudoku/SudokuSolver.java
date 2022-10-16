package Sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) throws FileNotFoundException{

        int board[][] = {
                {0,0,1,7,6,0,9,0,0},
                {8,2,0,0,0,0,6,0,3},
                {0,4,9,0,0,1,0,0,0},
                {2,0,0,9,3,0,7,0,0},
                {0,0,6,0,1,7,0,3,0},
                {0,0,0,0,2,0,0,0,0},
                {0,0,0,0,0,5,0,0,8},
                {0,0,0,6,0,0,0,0,0},
                {0,7,0,0,0,0,5,0,1}
        };


        solvePuzzles(board);



//        if(!solve(board, 0)){
//            System.out.println("Well, that's not good");
//        }else{
//            System.out.println("Now that's more like it!");
//            printBoard(board);
//        }
    }
    public static void solvePuzzles(int board[][]) throws FileNotFoundException {
        Scanner in = new Scanner(new File("sudoku.txt"));
        int sum = 0;

        while(in.hasNext()){
            in.nextLine();  //throw out header
            for (int i = 0; i < 9; i++) {
                String sNums = in.nextLine();
                String arr[] = sNums.split("");
                for(int j = 0; j < 9; j++){
                    board[i][j] = Integer.parseInt(arr[j]);
                }
            }
            solve(board,0);
            printBoard(board);
            String first3 = "";
            for (int i = 0; i < 3; i++) {   //add the top 3 items to a string
                first3 += board[0][i];
            }
            int top3 = Integer.parseInt(first3);    //convert string back to nums
            sum += top3;
//            printBoard(board);
        }
        System.out.println(sum);

    }


    public static boolean solve(int board[][], int pos){



        int row = pos / 9;  //position / 9 will give us the curr row
        int col = pos % 9;  //position % 9 will give us the curr col
        if(row >= 9){    //if we are past 9 rows, we have finished
            return true;
        }
        if(board[row][col] != 0){    //check if number already in space
            if(solve(board, pos+1)){
                return true;
            }else{
                return false;
            }
        }
        for (int i = 1; i <= 9; i++) {
//            printBoard(board);
            if(isSafe(board, row, col, i)){
                board[row][col] = i;
                if(solve(board, pos+1) == true){
                    return true;
                }
                board[row][col] = 0;

            }

        }
        return false;
    }
    public static boolean isSafe(int[][] board, int row, int col, int num){
//        if(board[row][col] != 0){ //check if number is already there
//            return false;
//        }
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == num){   //Check the row
                return false;
            }
            if(board[i][col] == num){   //Check the col
                return false;
            }
        }
        //check the grid
        if(row <= 2 && col <= 2){                                   //quadrant 1
            for (int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }
        else if(col >= 3 && col <= 5 && row <= 2){                  //quadrant 2
            for (int i = 0; i < 3; i++) {
                for(int j = 3; j <= 5; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }
        else if(col >= 6 && col <= 8 && row <= 2){                  //quadrant 3
            for (int i = 0; i < 3; i++) {
                for(int j = 6; j <= 8; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }
//================================================================================2/3
        if(row >= 3 && row <= 5 && col <= 2){                                   //quadrant 4
            for (int i = 3; i <= 5; i++) {
                for(int j = 0; j < 3; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }
        else if(col >= 3 && col <= 5 && row >= 3 && row <= 5){                  //quadrant 5
            for (int i = 3; i <= 5; i++) {
                for(int j = 3; j <= 5; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }
        else if(col >= 6 && col <= 8 && row >= 3 && row <= 5){                  //quadrant 6
            for (int i = 3; i <= 5; i++) {
                for(int j = 6; j <= 8; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }
//================================================================================3/3
        if(row >= 6 && row <= 8 && col <= 2){                                   //quadrant 7
            for (int i = 6; i <= 8; i++) {
                for(int j = 0; j < 3; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }
        else if(col >= 3 && col <= 5 && row >= 6 && row <= 8){                  //quadrant 8
            for (int i = 6; i <= 8; i++) {
                for(int j = 3; j <= 5; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }
        else if(col >= 6 && col <= 8 && row >= 6 && row <= 8){                  //quadrant 9
            for (int i = 6; i <= 8; i++) {
                for(int j = 6; j <= 8; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void printBoard(int[][] board){
        for (int i = 0; i < 9; i++) {
            System.out.print(i+1 + ": ");
            for(int j = 0; j < 9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
//                    String sNums = Integer.toString(nums);
//                    int num = Integer.parseInt(sNums.substring(0,1));
//                    if(sNums.length() != 1){    //if our string of numbers is longer than 1
//                        nums = Integer.parseInt(sNums.substring(1));
//                    }

//                    board[i][j] = num;
