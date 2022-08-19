package strings;

public class PalindromicSubstrings_647 {
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] isCharPalindromic = new boolean[n][n];

        // length = 1
        for (int i = 0; i < n; i++) {
            isCharPalindromic[i][i] = true;
        }
        for (int length = 2; length <= n; length++) {  // checking for length greater than 1
            for (int i = 0; i <= n - length; i++) {
                int j = length + i-1; // finding ending index
                boolean isSameChar = s.charAt(i) == s.charAt(j);

                if (length == 2 && isSameChar) { // for 2 length string we only need to check first and last character
                    isCharPalindromic[i][j] = true;
                }
                if (isSameChar && isCharPalindromic[i + 1][j - 1]) { // check first and last character and string between them is palindrome or not
                    isCharPalindromic[i][j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if (isCharPalindromic[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
