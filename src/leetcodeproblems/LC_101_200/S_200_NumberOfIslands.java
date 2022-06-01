package leetcodeproblems.LC_101_200;

//200. [Number of Islands](https://leetcode.com/problems/number-of-islands)
public class S_200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // boolean visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfsIsland(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfsIsland(char[][] grid, int rowId, int colId) {
        grid[rowId][colId] = '0'; // if traversed, set it to zero

        // start to expand to the circle
        if(rowId >= 1 && grid[rowId - 1][colId] == '1') {
            dfsIsland(grid, rowId - 1, colId);
        }
        if(rowId < grid.length - 1 && grid[rowId + 1][colId] == '1') {
            dfsIsland(grid, rowId + 1, colId);
        }
        if(colId >= 1 && grid[rowId][colId - 1] == '1') {
            dfsIsland(grid, rowId, colId - 1);
        }
        if(colId < grid[0].length - 1 && grid[rowId][colId + 1] == '1') {
            dfsIsland(grid, rowId, colId + 1);
        }
    }
}
