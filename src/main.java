public class main {

    private consoleUI ui = new consoleUI();
    private Board board;

    public static void main(String[] args){
        new main().play();                                //start the game
    }

    private void play(){
        ui.welcome();                                      // This shows a welcome to the user
        ui.rules();                                        // This shows the rules of the game
        int size = ui.askSize();
        board = new Board(size);
        ui.drawBoard(size,board.Matrix());                 // here we create a board with the matrix to solve

        while(!board.isSolved()){                          // this method checks if the board is fill correctly if true then the game ends
            board.fill();
            ui.drawBoard(size,board.Matrix());             // This draw the board with the numbers
        }
        ui.showMessage("Solved!");

    }

}
