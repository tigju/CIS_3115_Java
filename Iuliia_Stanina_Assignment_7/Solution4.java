import java.util.*;
class Solution4 {
    public ArrayList<String> topKFrequent(String[] words, int k) {
        // your methods

        if (words == null || words.length == 0) {
            return new ArrayList<String>();
        }

        // create hashmap to map words
        HashMap<String, Integer> map = new HashMap();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // use collections sort to sort the words
        ArrayList<String> keys = new ArrayList(map.keySet());
        Collections.sort(keys,
                (w1, w2) -> map.get(w1) != map.get(w2) ? map.get(w2) - map.get(w1) : w1.compareTo(w2));
        
        // get the first k words and store in separate array list
        ArrayList<String> result = new ArrayList<>();
        for (int i=0; i< k; i++) {
            result.add(keys.get(i));
        }
        return result;       
    }

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};

        Solution4 s1 = new Solution4();
        Solution4 s2 = new Solution4();

        ArrayList<String> w = s1.topKFrequent(words, 2);
        ArrayList<String> w2 = s2.topKFrequent(words2, 4);

        System.out.println("Original array:");
        System.out.println(Arrays.toString(words));

        System.out.println("top k words:");
        for (String str : w) {
            System.out.print(str + " ");
        }
        System.out.println("\n");
        System.out.println("Original array:");
        System.out.println(Arrays.toString(words2));

        System.out.println("top k words:");
        for (String str : w2) {
            System.out.print(str + " ");
        }
        System.out.println("\n");
    }
}