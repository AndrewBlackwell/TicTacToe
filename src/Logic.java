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

    public void clearBoard() 
    {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = EMPTY;
            }
        }
        currentPlayer = X;
        gameOver = false;
        winner = EMPTY;
    } 

    private void checkGameOver(int lastRow, int lastCol) 
    {
        // Check row
        if (board[lastRow][0] == board[lastRow][1] && board[lastRow][0] == board[lastRow][2]) 
        {
            gameOver = true;
            winner = currentPlayer;
            return;
        }

        // Check column
        if (board[0][lastCol] == board[1][lastCol] && board[0][lastCol] == board[2][lastCol]) 
        {
            gameOver = true;
            winner = currentPlayer;
            return;
        }

        // Check diagonal
        if (lastRow == lastCol) 
        {
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) 
            {
                gameOver = true;
                winner = currentPlayer;
                return;
            }
        }

        // Check anti-diagonal
        if (lastRow + lastCol == 2) 
        {
            if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) 
            {
                gameOver = true;
                winner = currentPlayer;
                return;
            }
        }

        // Check tie
        boolean tie = true;
        for (int row = 0; row < 3; row++) 
        {
            for (int col = 0; col < 3; col++) 
            {
                if (board[row][col] == EMPTY) 
                {
                    tie = false;
                    break;
                }
            }
        }
        if (tie) 
        {
            gameOver = true;
            winner = EMPTY;
        }
    }
}
