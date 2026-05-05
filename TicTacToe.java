public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    public static void main(String[] args) {
        int row = 1;
        int col = 1;

        if (isValidMove(row, col)) {
            placeMove(row, col, 'X');
        }

        printBoard();
    }

    // UC5 (reuse)
    static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return board[row][col] == '-';
    }

    // UC6: Place move
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Helper to see result
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}