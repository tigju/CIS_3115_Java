public class Solution2 {
    public int uniqueSum(int[] nums) {
        int[] count = new int[101];
        int unSum = 0;
        
        int len = nums.length;

        for (int i=0; i< len; i++){
            count[nums[i]]++;
        }
        for (int i=0; i<=100; i++){
            if(count[i] == 1){
                unSum += i;
            }
        }
        return unSum;
    }

    public static void main(String[] args) {
        Solution2 sol1 = new Solution2();
        int[] arr1 = { 0,2,3,2};
        System.out.println(sol1.uniqueSum(arr1));

        Solution2 sol2 = new Solution2();
        int[] arr2 = { 2,2,2,2,2,2,3,3 };
        System.out.println(sol2.uniqueSum(arr2));

        Solution2 sol3 = new Solution2();
        int[] arr3 = { 1,2,3,4 };
        System.out.println(sol3.uniqueSum(arr3));

    }
}
