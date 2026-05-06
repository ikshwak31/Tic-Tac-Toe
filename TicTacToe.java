public class TicTacToe {

    static char[][] board = {
        {'X', 'O', 'X'},
        {'X', 'O', 'O'},
        {'O', 'X', 'X'}
    };

    public static void main(String[] args) {

        if (isDraw()) {
            System.out.println("Game is a draw!");
        } else {
            System.out.println("Game is not a draw.");
        }
    }

    // UC10: Check draw condition
    static boolean isDraw() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // Empty cell found
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }
}