package strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_022 {
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
