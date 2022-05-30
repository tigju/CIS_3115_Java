import java.util.*;

class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        // your methods
        int len = nums.length;
        if (k == len) {
            return nums;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        // use Priority Queue and lambda expression to sort less frequent element
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2));

        for (int num : map.keySet()) {
            queue.add(num);

            if (queue.size() > k) {
                // fetch and remove the first element if the size is greater k
                queue.poll();
            }
        }

        int[] result = new int[k];

        // add the remaining elements in array
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1,1,1,2,2,3 };
        int[] arr2 = {1};

        Solution3 s1 = new Solution3();
        Solution3 s2 = new Solution3();

        int[] tf1 = s1.topKFrequent(arr1, 2);
        int[] tf2 = s2.topKFrequent(arr2, 1);
        System.out.println("Original array 1:");
        System.out.println(Arrays.toString(arr1));
        System.out.println("Top K frequent elements from array 1:");
        System.out.println(Arrays.toString(tf1));
        System.out.println("Original array 2:");
        System.out.println(Arrays.toString(arr2));
        System.out.println("Top K frequent elements from array 2:");
        System.out.println(Arrays.toString(tf2));
    }
}