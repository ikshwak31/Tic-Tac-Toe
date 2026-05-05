import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static boolean isHumanTurn = true;

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        while (true) {

            printBoard();

            if (isHumanTurn) {
                System.out.print("Enter slot (1-9): ");
                int slot = sc.nextInt();

                int row = getRowFromSlot(slot);
                int col = getColFromSlot(slot);

                if (isValidMove(row, col)) {
                    placeMove(row, col, 'X');
                } else {
                    System.out.println("Invalid move! Try again.");
                    continue; // retry same turn
                }

            } else {
                computerMove();
            }

            // Check win
            if (checkWin()) {
                printBoard();
                System.out.println(isHumanTurn ? "Human wins!" : "Computer wins!");
                break;
            }

            // Check draw
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch turn
            isHumanTurn = !isHumanTurn;
        }
    }

    // UC4
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    // UC5
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    // UC6
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7
    static void computerMove() {
        while (true) {
            int slot = rand.nextInt(9) + 1;
            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(row, col)) {
                placeMove(row, col, 'O');
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // UC8 helpers

    static boolean checkWin() {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return true;
            }
        }

        // Columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' &&
                board[0][j] == board[1][j] &&
                board[1][j] == board[2][j]) {
                return true;
            }
        }

        // Diagonals
        if (board[0][0] != '-' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != '-' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}