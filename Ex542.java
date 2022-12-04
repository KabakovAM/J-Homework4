package Homework4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex542 {
    static int[][] room = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
    static int[][] directons = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateMatrix(room)));
    }

    public static int[][] updateMatrix(int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    q.add(new int[] { row, col });
                } else {
                    mat[row][col] = Integer.MAX_VALUE;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curPoint = q.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];
            for (int[] directon : directons) {
                int newRow = curRow + directon[0];
                int newCol = curCol + directon[1];
                if (newRow >= 0 && newCol >= 0 && newRow < mat.length && newCol < mat[0].length) {
                    if (mat[curRow][curCol] + 1 < mat[newRow][newCol]) {
                        mat[newRow][newCol] = mat[curRow][curCol] + 1;
                        q.add(new int[] { newRow, newCol });
                    }
                }
            }
        }
        return mat;
    }
}