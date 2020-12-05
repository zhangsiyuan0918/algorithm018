// 37 解数独
// sudoku-solver

//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 709 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][][] boxes = new boolean[3][3][10];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int num = board[row][col] - '0';
                if (num >= 1 && num <= 9) {
                    rows[row][num] = true;
                    cols[col][num] = true;
                    boxes[row / 3][col / 3][num] = true;
                }
            }
        }
        backtrack(board, rows, cols, boxes, 0, 0);
    }
    private boolean backtrack(char[][] board, boolean[][] rows, boolean[][] cols,
                              boolean[][][] boxes, int row, int col) {

        if (col == board[0].length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }
        if (board[row][col] == '.') {
            for (int num = 1; num <= 9; num++) {
                boolean canUsed = !(rows[row][num] || cols[col][num] || boxes[row / 3][col / 3][num]);
                if (canUsed) {
                    rows[row][num] = true;
                    cols[col][num] = true;
                    boxes[row / 3][col / 3][num] = true;
                    board[row][col] = (char)('0' + num);
                    if (backtrack(board, rows, cols, boxes, row, col+ 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                    rows[row][num] = false;
                    cols[col][num] = false;
                    boxes[row / 3][col / 3][num] = false;
                }
            }
        }
        else {
            return backtrack(board, rows, cols, boxes, row, col + 1);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

