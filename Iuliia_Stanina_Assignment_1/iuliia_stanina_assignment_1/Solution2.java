import java.util.Arrays;
class Solution2 {
 public int maximumWealth(int[][] accounts) {
 //Your method
   int maxN = 0;
   int temp;
   int arrLen = accounts.length;
   for(int i=0; i<arrLen; i++){
       temp = 0;
      for (int j=0; j<accounts[i].length; j++){
         temp += accounts[i][j];
      }
      if (maxN < temp){
         maxN = temp;
      }
   }
      return maxN;
   }
   
   public static void main(String[] args) {
      Solution2 sol1 = new Solution2();
      int[][] arr1 = {{1, 2, 3}, {3, 2, 1}};
      System.out.println(sol1.maximumWealth(arr1));
      
      Solution2 sol2 = new Solution2();
      int[][] arr2 = {{1, 5}, {7, 3}, {3, 5}};
      System.out.println(sol2.maximumWealth(arr2));
      
      Solution2 sol3 = new Solution2();
      int[][] arr3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
      System.out.println(sol3.maximumWealth(arr3));

   }
}


