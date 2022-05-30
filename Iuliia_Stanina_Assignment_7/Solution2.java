import java.util.Arrays;
class Solution2 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // your methods
        int[][] arr2d = new int[m][n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                arr2d[j][i] = original[j * n + i];
            }
        }
        return arr2d;
    }

    public static void main(String[] args) {
        int[] arr = { 1,2,3,4 };
        int[] arr2 = {1,2,3};

        Solution2 s = new Solution2();
        int[][] n = s.construct2DArray(arr, 2,2);

        Solution2 s2 = new Solution2();
        int[][] n2 = s2.construct2DArray(arr, 1,3);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(n));

        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.deepToString(n2));
    }
}
