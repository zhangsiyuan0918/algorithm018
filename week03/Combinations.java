// 77 组合
// combinations

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 431 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k)
            return res;
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(res, path, n, k, 1);
        return res;
    }
    private void backtrack(List<List<Integer>> res, Deque<Integer> path, int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            backtrack(res, path, n, k, i + 1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

