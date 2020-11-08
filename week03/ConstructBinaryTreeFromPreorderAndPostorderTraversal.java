// 889 根据前序和后序遍历构造二叉树
// construct-binary-tree-from-preorder-and-postorder-traversal

//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 
// 👍 121 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        return dfs(pre, post);
    }
    private TreeNode dfs(int[] pre, int[] post) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]);
        int n = pre.length;
        for (int i = 0; i < post.length; ++i) {
            if (pre[1] == post[i]) {
                int left_conut = i + 1;
                int[] pre_left = Arrays.copyOfRange(pre, 1, left_conut + 1);
                int[] pre_right = Arrays.copyOfRange(pre, left_conut + 1, n);
                int[] post_left = Arrays.copyOfRange(post, 0, left_conut);
                int[] post_right = Arrays.copyOfRange(post, left_conut, n - 1);
                root.left = dfs(pre_left, post_left);
                root.right = dfs(pre_right, post_right);
                break;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

