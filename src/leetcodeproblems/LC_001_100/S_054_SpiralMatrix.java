package leetcodeproblems.LC_001_100;

import java.util.ArrayList;
import java.util.List;

public class S_054_SpiralMatrix {
    // https://leetcode.com/problems/spiral-matrix/
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> seq = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) {
            return seq;
        }

        int startX = 0, startY = 0;
        // left-up side node can be the start of a circle
        // don't use startX < matrix[0].length / 2, it's different.
        while(startX * 2 < matrix[0].length && startY * 2 < matrix.length) {
            printCircle(matrix, startX++, startY++, seq);
        }

        return seq;
    }

    private void printCircle(int[][] matrix, int startX, int startY, List<Integer> seq) {
        // left to right
        int i, j;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int endX = cols - startX - 1;
        int endY = rows - startY - 1;

        for(j = startX; j <= endX; j++) {
            seq.add(matrix[startY][j]);
        }

        // up to down
        for(i = startY + 1; i <= endY; i++) {
            seq.add(matrix[i][endX]);
        }

        // right to left
        if(endY > startY) {
            for (j = endX - 1; j >= startX; j--) {
                seq.add(matrix[endY][j]);
            }
        }

        // down to up
        if(endX > startX) {
            for (i = endY - 1; i >= startY + 1; i--) {
                seq.add(matrix[i][startX]);
            }
        }
    }

    public static void main(String[] args) {
        S_054_SpiralMatrix ex = new S_054_SpiralMatrix();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> seq = new ArrayList<>();

        seq = ex.spiralOrder(matrix);
        System.out.println(seq.toString());
    }
}
