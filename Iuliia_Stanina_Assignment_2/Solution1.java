public class Solution1 {
    public int majorityElement(int[] nums){
        int len = nums.length;
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (nums[i] == nums[j])
                    count++;
            }

            if (count > maxCount) {
                maxCount = count;
            }
            if (maxCount > len/2) {
                maxIndex = i;
            }
        }
        return nums[maxIndex];
    }

    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        int[] arr1 = {1,2,1};
        System.out.println(sol1.majorityElement(arr1));

        Solution1 sol2 = new Solution1();
        int[] arr2 = {3, 3, 1, 2, 0, 3, 3};
        System.out.println(sol2.majorityElement(arr2));

    }
}
