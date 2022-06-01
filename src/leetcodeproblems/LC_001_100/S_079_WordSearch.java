package leetcodeproblems.LC_001_100;

// 79. [Word Search](https://leetcode.com/problems/word-search)

public class S_079_WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        boolean visited[][] = new boolean[rows][cols];
        int strId = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(hasPathCore(board, word, visited, i, j, strId)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPathCore(char[][] board, String word, boolean visited[][], int rowId, int colId, int strId) {
        if(rowId < 0 || rowId >= board.length || colId < 0 || colId >= board[0].length ||
                visited[rowId][colId] || board[rowId][colId] != word.charAt(strId)) { // This condition should be ahead of condition II.
            return false;
        }
        if(strId == word.length() - 1) { // condition II
            return true;
        }

        visited[rowId][colId] = true;

        if(hasPathCore(board, word, visited, rowId + 1, colId, strId + 1) ||
                hasPathCore(board, word, visited, rowId - 1, colId, strId + 1) ||
                hasPathCore(board, word, visited, rowId, colId + 1, strId + 1) ||
                hasPathCore(board, word, visited, rowId, colId - 1, strId + 1)) {
            return true;
        }

        visited[rowId][colId] = false;

        return false;
    }

    public static void main(String[] args) {
        S_079_WordSearch ex = new S_079_WordSearch();
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean rs = ex.exist(board, word);
        System.out.println(rs);
    }
}
