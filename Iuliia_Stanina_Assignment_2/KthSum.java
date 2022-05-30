import java.util.Arrays;

class KthSum {
    
    int k;
    int[] nums;

    public KthSum(int kNum, int[] numsArr) {
        k = kNum;
        nums = numsArr;
    }

    int add(int val) {
        
        int[] newArr = new int[nums.length + 1];
        // copy the old in the new array
        System.arraycopy(nums, 0, newArr, 0, nums.length);
        // add element to new array
        newArr[nums.length] = val;
        // assign to old array
        nums = newArr;
        // sort
        Arrays.sort(nums);
        //get values needed by k-index
        int kthLargest = nums[nums.length - k];
        int kthSmallest = nums[0+k-1];
        int sum = kthLargest + kthSmallest;
        return sum;
    }

    public static void main(String[] args) {

        KthSum obj = new KthSum(3, new int[] {4,5,8,2});
        int param_1 = obj.add(3);
        System.out.println(param_1);
        int param_2 = obj.add(5);
        System.out.println(param_2);
        int param_3 = obj.add(10);
        System.out.println(param_3);
    }
}

 