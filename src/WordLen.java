public class WordLen {
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
                if(hasPathCore(board, word, visited, i, j, rows, cols, strId)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPathCore(char[][] board, String word, boolean visited[][], int rowId, int colId, int rows, int cols, int strId) {
        if(word.charAt(strId) == '\0') {
            return true;
        }

        if(rowId >= 0 && rowId < rows && colId >= 0 && colId < cols
                && !visited[rowId][colId] && board[rowId][colId] == word.charAt(strId)) {
            visited[rowId][colId] = true;
            strId++;

            if(hasPathCore(board, word, visited, rowId + 1, colId, rows, cols, strId) ||
                    hasPathCore(board, word, visited, rowId - 1, colId, rows, cols, strId) ||
                    hasPathCore(board, word, visited, rowId, colId + 1, rows, cols, strId) ||
                    hasPathCore(board, word, visited, rowId, colId - 1, rows, cols, strId)) {
                return true;
            }

            strId--;
            visited[rowId][colId] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        WordLen ex = new WordLen();
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean rs = ex.exist(board, word);
        System.out.println(rs);
    }
}
