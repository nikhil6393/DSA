class Solution {

    public boolean checkValidGrid(int[][] grid) {

        if (grid[0][0] != 0)
            return false;

        return solve(grid, 0, 0, 0);
    }

    public boolean solve(int[][] grid, int row, int col, int move) {

        int n = grid.length;

        if (move == n * n - 1)
            return true;

        // Up Left
        if (isValid(grid, row - 2, col - 1, move + 1))
            if (solve(grid, row - 2, col - 1, move + 1))
                return true;

        // Up Right
        if (isValid(grid, row - 2, col + 1, move + 1))
            if (solve(grid, row - 2, col + 1, move + 1))
                return true;

        // Left Up
        if (isValid(grid, row - 1, col - 2, move + 1))
            if (solve(grid, row - 1, col - 2, move + 1))
                return true;

        // Right Up
        if (isValid(grid, row - 1, col + 2, move + 1))
            if (solve(grid, row - 1, col + 2, move + 1))
                return true;

        // Left Down
        if (isValid(grid, row + 1, col - 2, move + 1))
            if (solve(grid, row + 1, col - 2, move + 1))
                return true;

        // Right Down
        if (isValid(grid, row + 1, col + 2, move + 1))
            if (solve(grid, row + 1, col + 2, move + 1))
                return true;

        // Down Left
        if (isValid(grid, row + 2, col - 1, move + 1))
            if (solve(grid, row + 2, col - 1, move + 1))
                return true;

        // Down Right
        if (isValid(grid, row + 2, col + 1, move + 1))
            if (solve(grid, row + 2, col + 1, move + 1))
                return true;

        return false;
    }

    public boolean isValid(int[][] grid, int r, int c, int nextMove) {

        int n = grid.length;

        return r >= 0 && r < n &&
               c >= 0 && c < n &&
               grid[r][c] == nextMove;
    }
}