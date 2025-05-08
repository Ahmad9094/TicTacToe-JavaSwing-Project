// -----------------------------------------------------
// Mini project 1
// Question: Tic Tac Toe Game
// Written by: [Your Name and Student ID]
// -----------------------------------------------------

// This is the entry point for the Tic Tac Toe application. It shows a welcome message and launches the GUI.

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Welcome message
        JOptionPane.showMessageDialog(null, "Welcome to Tic Tac Toe Game!\nCreated by [Your Name]", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        new TicTacToeGUI();
    }
}
