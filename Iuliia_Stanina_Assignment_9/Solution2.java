import java.util.*;

class Solution2 {
    public List<String> letterCombinations(String digits) {

        // for zero and one no characters mapping 
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        
        
        List<String> result = new ArrayList<>();

        int len = digits.length();
        if (len == 0){
            return result;
        }

        if (len == 1) {
            result = Arrays.asList(map.get(digits).split(""));
            return result;
        }

        String numbers[] = digits.split("");
        ArrayList<String> letterset = new ArrayList<>();
        for (String num : numbers) {
            letterset.add(map.get(num));    
        }

        // Big O is not good but since the constraint max 4 digits, it's ok to use nested loops
        for (int i = 1; i < letterset.size(); i++) {
            char[] temp1 = letterset.get(i).toCharArray();
            char[] temp2 = letterset.get(i-1).toCharArray();
            
            for(char c1 : temp1) {
                for(char c2 : temp2) {
                    result.add(String.valueOf(c1) + String.valueOf(c2));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Solution2 s2 = new Solution2();

        System.out.println(s2.letterCombinations("23"));

        System.out.println(s2.letterCombinations("2"));

        System.out.println(s2.letterCombinations("37"));

    }
}