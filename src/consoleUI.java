
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class consoleUI {
    PrintStream out =System.out;
    InputStream in= System.in;


    //this method display a welcoming to the user
    public void welcome() {
        out.println("Welcome to Sudoku!");
    }

    //this method ask for the size of the board of the game
    public int askSize(){
        Scanner scnr = new Scanner(in);
        out.println("Choose Board 4 (4x4) or 9 (9x9) (quit to exit) ");
        int size =  scnr.nextInt();
        return size;
    }

    //this method display a message
    public void showMessage(String msg){
        out.println(msg);
    }

    //this method checks which board to draw and call the correct board
    public void drawBoard(int size, int M [][]){
        if(size ==4){
            Board4x4(size,M);
        }
        if(size ==9){
            Board9x9(size,M);
        }

    }

    //this method draw the 9x9 board
    public void Board9x9(int size, int matrix [][]){

        int count;
        int row=0;
        out.println("    1   2   3   4   5   6   7   8   9 ");
        out.println("  +___________+___________+___________+");
        for (int i = 0; i < size; i++) {
            out.print(i + 1 + " | ");
            count=0;
            for (int e = 0; e < size; e++) {
                out.print(displayNum(i,e, matrix));
                count++;
                if (count == 3 && e<8) {
                    out.print(" ! ");
                    count =0;

                } else {
                    out.print(" | ");
                }
            }
            if (row==2) {
                out.println("");
                out.println("  +___________*___________*___________+");
                row=0;
            } else {
                out.println("");
                out.println("  -------------------------------------");
                row++;
            }


        }


    }

    //this method draw the 4x4 board
    public void Board4x4(int size, int matrix [][]){
        int count=0;

        out.println("    1   2   3   4 ");
        out.println("  +_______+_______+");
        for (int i = 0; i < size; i++) {
            out.print(i + 1 + " | ");
            for (int e = 0; e < size; e++) {
                out.print(displayNum(i,e, matrix));
                count++;
                if (e <3 && count==2 ) {
                    out.print(" ! ");
                    count =0;

                } else {
                    out.print(" | ");
                }
            }
            if (i > 0 && i / 2 == 0) {
                out.println("");
                out.println("  +_______*_______+");

            } else {
                out.println("");
                out.println("  ----------------");

            }

        }
    }

    //this method shows the number of the matrix and checks if is
    //0 then it would not be display.
    public String  displayNum(int y, int x, int matrix [][]){
        String blank=" ";
        if(matrix[y][x] ==0) return blank;
        else return String.valueOf(matrix[y][x]);
    }

    //this method prints the rules of the game
    public void rules() {
        out.println("======================================");
        out.println("|-To insert a number use add,        |");
        out.println("| then select the coordinates x and y|");
        out.println("| following the desire number.       |");
        out.println("|-To remove a number use del.        |");
        out.println("|-To exit the game use quit.         |");
        out.println("======================================");
    }
}