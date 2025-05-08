// -----------------------------------------------------
// Mini project 1
// Question: Tic Tac Toe Game - GUI
// Written by: [Your Name and Student ID]
// -----------------------------------------------------

// This class handles the GUI using Java Swing and connects user interactions to the game logic.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI {
    private JFrame frame;
    private JButton[][] buttons;
    private JLabel statusLabel;
    private TicTacToeGame game;

    public TicTacToeGUI() {
        game = new TicTacToeGame();
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(400, 450);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i, col = j;
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].addActionListener(e -> handleMove(row, col));
                boardPanel.add(buttons[i][j]);
            }
        }

        statusLabel = new JLabel("Player X's turn");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton resetButton = new JButton("Restart Game");
        resetButton.addActionListener(e -> resetGame());

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(statusLabel, BorderLayout.CENTER);
        bottomPanel.add(resetButton, BorderLayout.EAST);

        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void handleMove(int row, int col) {
        if (game.makeMove(row, col)) {
            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));

            if (game.checkWin()) {
                statusLabel.setText("Player " + game.getCurrentPlayer() + " wins!");
                disableBoard();
            } else if (game.checkDraw()) {
                statusLabel.setText("It's a draw!");
            } else {
                game.switchPlayer();
                statusLabel.setText("Player " + game.getCurrentPlayer() + "'s turn");
            }
        }
    }

    private void resetGame() {
        game.resetBoard();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        statusLabel.setText("Player X's turn");
        game = new TicTacToeGame();
    }

    private void disableBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setEnabled(false);
    }
}
