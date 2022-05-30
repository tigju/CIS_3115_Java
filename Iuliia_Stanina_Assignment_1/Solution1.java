import java.util.Arrays;
class Solution1 {
 public int[] answer(int[] nums) {
 //Your method
   int arrLen = (nums.length)*2;
   int[] ans = new int[arrLen];

   System.arraycopy(nums, 0, ans, 0, nums.length);
   System.arraycopy(nums, 0, ans, nums.length, nums.length);
   return ans;
   }
   
   public static void main(String[] args) {
      Solution1 sol1 = new Solution1();
      int[] arr1 = new int[]{1,2,1};
      System.out.println(Arrays.toString(sol1.answer(arr1)));
      
      Solution1 sol2 = new Solution1();
      int[] arr2 = new int[]{1,3,2,1};
      System.out.println(Arrays.toString(sol1.answer(arr2)));
   }
}


