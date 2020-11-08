// 47 全排列 II
// permutations-ii

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 518 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        backtrack(nums, len, res, used, path, 0);
        return res;
    }
    private void backtrack(int[] nums, int len, List<List<Integer>> res, boolean[] used, Deque<Integer> path, int depth) {
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backtrack(nums, len, res, used, path, depth + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

