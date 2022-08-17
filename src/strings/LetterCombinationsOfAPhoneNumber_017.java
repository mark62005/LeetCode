package strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_017 {
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
