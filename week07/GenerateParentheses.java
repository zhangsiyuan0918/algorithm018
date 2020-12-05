// 22 括号生成
// generate-parentheses

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1451 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0)
            return res;
        backtrack(n, 0, 0, res, new StringBuilder());
        return res;
    }
    private void backtrack(int n, int left, int right, List<String> res, StringBuilder sb) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
        }
        if (left < n) {
            sb.append("(");
            backtrack(n, left + 1, right, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            sb.append(")");
            backtrack(n, left, right + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

