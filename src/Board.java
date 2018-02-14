
import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {
    private int size;
    private int [][] matrix;


    //this method creates a board and a matrix with the
    //sudoku numbers stored
    public Board(int size){
        this.size = size;
        matrix =new int[size][size];
    }

    //this method send the matrix game
    public int [][] Matrix(){
        return this.matrix;
    }

    //this method checks if the games is complete or not
    public boolean isSolved(){
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                if(matrix[i][j]==0) return false;
            }
        }
        return true;

    }

    //this method ask the user the data to fill the board
    public void fill() {
        try {
            int x,y,value;
            Scanner scnr = new Scanner(System.in);
            System.out.println("*add "+"*del "+ "(quit to exit)");
            String line=scnr.nextLine();
            if(line.equals("quit")){
                System.exit(0);
            }
            if(line.equals("del")){
                System.out.print("Y(coordinate): ");
                y = scnr.nextInt();
                System.out.print("X(coordinate): ");
                x = scnr.nextInt();
                removeNum(y,x);

            }
            if(line.equals("add")) {
                System.out.print("Y(coordinate): ");
                y = scnr.nextInt();
                System.out.print("X(coordinate): ");
                x = scnr.nextInt();
                System.out.print("value: ");
                value = scnr.nextInt();


                if (checkRep(y - 1, x - 1, value)) {
                    System.out.println("|| The number is invalid or there is a repetition ||");
                }
                else {
                    updateMatrix(y - 1, x - 1, value);

                }
            }

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("|| Invalid Position ||");
        }catch (InputMismatchException e){
            System.out.println("|| Not a number ||");

        }
    }

    //this method updates the matrix with the new values
    //if are accepted
    private void updateMatrix(int y, int x, int value) {
        this.matrix[y][x]=value;
    }

    //This method removes the desire number
    private void removeNum(int y, int x) {

        updateMatrix(y-1,x-1,0);
    }

    //this method check if the new number is valid in the board by
    //cheking the row,column, and subgrid
    private boolean checkRep(int y, int x, int value) {
        //check if the number is in the same row or colunm or box
        boolean verify=(ValidNumber(value));
        if(checkRow(y,value) || checkColumn(x,value) || verify ||checkSubgrid(y,x,value)){
            return true;
        }
        //true is not valid or there is a rep.
        //false its good.
        return false;
    }

    //this method checks if the number is in the range (1-4 or 1-9)
    private boolean ValidNumber(int input) {
        if(input>size || input<1){
            return true;
        }
        return false;
    }

    //this method checks every row with the same x coordinate
    private boolean checkRow(int y, int value){
        for (int i=0; i<size;i++){
            if(matrix[y][i] == value){
                return true;
            }
        }
        return false;
    }

    //this method checks every column with the same Y coordinate
    private boolean checkColumn(int x, int value){
        for (int i=0; i<size;i++){
            if(matrix[i][x] == value){
                return true;
            }

        }
        return false;
    }

    //this method checks the subgrid of the new value
    //by subtracting the y and x coordinates
    // and the mod of the square root of the board size
    //and start the for loop in that position and checking
    //the sub grid witch is the squared root of the size of the board
    private boolean checkSubgrid(int y, int x, int value){

        int outline=(int)(Math.sqrt(size));
        int row = y-(y%outline);
        int column=x-(x%outline);

        for (int i=row;i<outline;i++){
            for (int e =column;e<outline;e++){

                if(matrix[i][e] == value) return true;

            }
        }
        return false;
    }


}


