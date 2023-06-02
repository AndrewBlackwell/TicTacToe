public class Logic 
{
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char EMPTY = ' ';

    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private char winner;

    public Logic() 
    {
        board = new char[3][3];
        currentPlayer = X;
        gameOver = false;
        winner = EMPTY;
        clearBoard();
    }

    public boolean makeMove(int row, int col) 
    {
        if (board[row][col] == EMPTY && !gameOver) 
        {
            board[row][col] = currentPlayer;
            checkGameOver(row, col);
            currentPlayer = (currentPlayer == X) ? O : X;
            return true;
        }
        return false;
    }

    public char getCurrentPlayer() 
    {
        return currentPlayer;
    }

    public boolean isGameOver() 
    {
        return gameOver;
    }

    public char getWinner() 
    {
        return winner;
    }
}
