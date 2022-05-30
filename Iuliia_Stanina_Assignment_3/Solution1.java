public class Solution1 {
    public String reversedWords(String s) {
        String result = "";
        for(int i = s.length()-1; i>=0; i--){
            result += s.charAt(i); // first solution, charAt method
        //  result += str1.substring(i, i+1); // first solution,  substring method
        }
        return result;

    }

    public static void main(String[] args) {
        Solution1 sol1 = new Solution1();
        String[] arr1 = {"Let's take LeetCode contest", "Gd Ding"};

        for (int i=0; i<arr1.length; i++){
            System.out.println(sol1.reversedWords(arr1[i]));
        }
    }
}
