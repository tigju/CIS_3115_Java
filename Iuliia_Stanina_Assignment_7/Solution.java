import java.util.*;
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // your methods
        int m0 = mat.length, m1 = mat[0].length, k = 0;
        if (r*c != m0*m1) {
            return mat;
        }
        int [][] result = new int[r][c];
        for (int i = 0; i < r; i++){
            for (int j=0;j<c;j++,k++){
                result[i][j] = mat[k/m1][k%m1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr1 = { {1,2}, {3,4} };
        Solution s = new Solution();
        int[][] n = s.matrixReshape(arr1, 1,4);

        System.out.println(Arrays.deepToString(arr1));
        System.out.println(Arrays.deepToString(n));
    }
}

