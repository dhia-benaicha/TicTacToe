import java.util.Scanner;

public class TicTacToe {
    private char currentPlayer;
    private char winner;
    private final Board board;

    public TicTacToe() {
        currentPlayer = 'X';
        winner = '-';
        board = new Board();
    }

    public void playGame() {
        Scanner input = new Scanner(System.in);

        while (!board.isFull()) {
            System.out.println("Player " + currentPlayer + ", enter row and column: ");
            int row = input.nextInt();
            int col = input.nextInt();

            if (board.setCell(row, col, currentPlayer)) {
                board.display();
                if (checkForWinner()) {
                    System.out.println("Player " + winner + " wins!");
                    return;
                }
                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        System.out.println("Tie game.");
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getWinner() {
        return winner;
    }

    private void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    private boolean checkForWinner() {
        char[][] cells = board.getCells();

        // check rows
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2] && cells[i][0] != '-') {
                winner = cells[i][0];
                return true;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i] && cells[0][i] != '-') {
                winner = cells[0][i];
                return true;
            }
        }

        // check diagonals
        if (cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2] && cells[0][0] != '-') {
            winner = cells[0][0];
            return true;
        }
        if (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0] && cells[0][2] != '-') {
            winner = cells[0][2];
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
