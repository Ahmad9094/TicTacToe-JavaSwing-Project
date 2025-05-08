// -----------------------------------------------------
// Mini project 1
// Question: Tic Tac Toe Game - Game Board Class
// Written by: [Your Name and Student ID]
// -----------------------------------------------------

// This class manages the board structure and interactions at a lower level than the game controller.

public class GameBoard {
    private char[][] board;

    public GameBoard() {
        board = new char[3][3];
        clearBoard();
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';
    }

    public boolean setCell(int row, int col, char symbol) {
        if (board[row][col] == '-') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-')
                    return false;
        return true;
    }

    public char[][] getBoard() {
        return board;
    }
}
