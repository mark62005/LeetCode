import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring_005 {
    // Time: O(N^2), Space: O(N^2)
    public static String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[n][n];

        for (int length = 0; length < n; length++) {
            for (int i = 0; (i + length) < n; i++) {
                dp[i][i + length] =
                    s.charAt(i) == s.charAt(i + length)
                        && (length < 2 || dp[i + 1][i + length - 1]);

                if (dp[i][i + length] && length > (end - start)) {
                    start = i;
                    end = i + length;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static class GenerateParentheses_022 {
        public static List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            helper(result, new StringBuilder(), 0, 0, n);
            return result;
        }

        private static void helper(List<String> result, StringBuilder stringBuilder, int open, int close, int n) {
            if (open == n && close == n) {
                result.add(stringBuilder.toString());
                return;
            }

            if (open < n) {
                stringBuilder.append("(");
                helper(result, stringBuilder, open + 1, close, n);
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
            if (close < open) {
                stringBuilder.append(")");
                helper(result, stringBuilder, open, close + 1, n);
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
        }

        public static void main(String[] args) {
            System.out.println(generateParenthesis(3));
            System.out.println(generateParenthesis(1));
        }
    }

    public static class LetterCombinationsOfAPhoneNumber_017 {
        final static char[][] LETTERS = {
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
        };

        public static List<String> letterCombinations(String digits) {
            int len = digits.length();
            List<String> ans = new ArrayList<>();

            if (len == 0) {
                return ans;
            }

            dfs(0, len, new StringBuilder(), ans, digits);
            return ans;
        }

        public static void dfs(int pos, int len, StringBuilder stringBuilder, List<String> ans, String digits) {
            if (pos == len) {
                ans.add(stringBuilder.toString());
            }
            else {
                char[] letters = LETTERS[Character.getNumericValue(digits.charAt(pos))];
                for (char letter : letters) {
                    dfs(pos + 1, len, new StringBuilder(stringBuilder).append(letter), ans, digits);
                }
            }
        }

        public static void main(String[] args) {
            System.out.println(letterCombinations("23"));
            System.out.println(letterCombinations(""));
            System.out.println(letterCombinations("2"));
        }
    }

    public static class PalindromePartitioning_131 {
        // Time: O(N*2^N), Space: O(N)
        public static List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            List<String> path = new ArrayList<>();
            partitionHelper(0, s, path, result);
            return result;
        }

        // Entire recursive function, that generates all the partition substring
        public static void partitionHelper(int index, String s, List<String> path, List<List<String>> result){
            // Base Condition, which means when we have done partition at the end (n)
            if (index == s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }

            // partition
            for (int i = index; i < s.length(); i++) {
                if(isPalindrome(s, index, i)){
                    path.add(s.substring(index, i + 1));
                    partitionHelper(i + 1, s, path, result);
                    path.remove(path.size() - 1);
                }
            }
        }

        public static boolean isPalindrome(String s, int start, int end){
            while (start <= end) {
                if (s.charAt(start++) != s.charAt(end--)) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            System.out.println(partition("aab"));
            System.out.println(partition("a"));
        }
    }

    public static class PalindromicSubstrings_647 {
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
}
