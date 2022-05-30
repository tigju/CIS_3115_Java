class Solution1 {
    public String convert(String s, int numRows) {

        String result = "";
        // your method
        if (numRows == 1) {
            return s;
        }
        
        int step = 2 * numRows - 2;
        // Loop for each row
        for (int i = 0; i < numRows; i++) {
            // Loop for each character in the row
            for (int j = i; j < s.length(); j += step) {
                result = result + s.charAt(j);
                if (i != 0 && i != numRows - 1 && (j + step - 2 * i) < s.length()) {
                    result = result + s.charAt(j + step - 2 * i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Solution1 s1 = new Solution1();

        System.out.println(s1.convert("PAYPALISHIRING", 3));
        System.out.println(s1.convert("PAYPALISHIRING", 4));
        System.out.println(s1.convert("A", 1));
    }
}