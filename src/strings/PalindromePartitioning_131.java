package strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
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
