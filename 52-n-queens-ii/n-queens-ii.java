class Solution {

    public int totalNQueens(int n) {

        char[][] chessBoard = new char[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                chessBoard[i][j] = '.';

        return nQueens(0, chessBoard);
    }

    private int nQueens(int row, char[][] chessBoard) {

        int n = chessBoard.length;

        if (row == n)
            return 1;

        int count = 0;

        for (int col = 0; col < n; col++) {

            if (canQueenBePlaced(row, col, chessBoard)) {

                chessBoard[row][col] = 'Q'; // mark

                count += nQueens(row + 1, chessBoard);

                chessBoard[row][col] = '.'; // unmark
            }
        }

        return count;
    }

    private boolean canQueenBePlaced(int row, int col, char[][] chessBoard) {

        int n = chessBoard.length;

        // check column
        int i = row - 1;
        while (i >= 0) {
            if (chessBoard[i][col] == 'Q')
                return false;
            i--;
        }

        // check left diagonal
        i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (chessBoard[i][j] == 'Q')
                return false;
            i--;
            j--;
        }

        // check right diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (chessBoard[i][j] == 'Q')
                return false;
            i--;
            j++;
        }

        return true;
    }
}