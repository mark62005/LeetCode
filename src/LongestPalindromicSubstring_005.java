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
}
