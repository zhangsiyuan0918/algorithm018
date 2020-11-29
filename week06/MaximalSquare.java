// 221 最大正方形
// maximal-square

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例： 
//
// 
//输入：
//matrix = [["1","0","1","0","0"],
//          ["1","0","1","1","1"],
//          ["1","1","1","1","1"],
//          ["1","0","0","1","0"]]
//
//输出：4 
// Related Topics 动态规划 
// 👍 625 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;
        int height = matrix.length;
        int weight = matrix[0].length;
        int maxSide = 0;

        int[][] dp = new int[height + 1][weight + 1];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < weight; col++) {
                if (matrix[row][col] == '1') {
                    dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                    maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

