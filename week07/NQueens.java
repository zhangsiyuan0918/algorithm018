// 51 N 皇后
// n-queens

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 659 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        //定义棋盘
        char[][] cheer = new char[n][n];
        //填充棋盘
        for (int i = 0; i < cheer.length; i++) {
            for (int j = 0; j < cheer[0].length; j++) {
                cheer[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        sol(res, cheer, 0);
        return res;
    }
    private void sol(List<List<String>> res, char[][] cheer, int row) {
        if (row == cheer.length) {
            res.add(constrcut(cheer));
            return;
        }
        for (int col = 0; col < cheer.length; col++) {
            if (valid(cheer, row, col)) {
                cheer[row][col] = 'Q';
                sol(res, cheer, row + 1);
                cheer[row][col] = '.';
            }
        }
    }
    private boolean valid(char[][] cheer, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cheer[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < cheer.length; i--, j++) {
            if (cheer[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (cheer[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    private List<String> constrcut(char[][] cheer) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < cheer.length; i++) {
            path.add(new String(cheer[i]));
        }
        return path;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

