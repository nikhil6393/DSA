class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, i, j, 0, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word,
                           int r, int c, int index,
                           boolean[][] visited) {

        // Out of bounds or already visited
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
                || visited[r][c])
            return false;

        // Character doesn't match
        if (board[r][c] != word.charAt(index))
            return false;

        // Entire word found
        if (index == word.length() - 1)
            return true;

        visited[r][c] = true;

        boolean left  = search(board, word, r, c - 1, index + 1, visited);
        boolean right = search(board, word, r, c + 1, index + 1, visited);
        boolean up    = search(board, word, r - 1, c, index + 1, visited);
        boolean down  = search(board, word, r + 1, c, index + 1, visited);

        visited[r][c] = false; // Backtrack

        return left || right || up || down;
    }
}