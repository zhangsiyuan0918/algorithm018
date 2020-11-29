// 647 回文子串
// palindromic-substrings

//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 441 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 首先这一题可以使用动态规划来进行解决：
 *
 * 状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
 * 状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为false
 * 这个状态转移方程是什么意思呢？
 *
 * 当只有一个字符时，比如 a 自然是一个回文串。
 * 当有两个字符时，如果是相等的，比如 aa，也是一个回文串。
 * 当有三个及以上字符时，比如 ababa 这个字符记作串 1，把两边的 a 去掉，也就是 bab 记作串 2，可以看出只要串2是一个回文串，那么左右各多了一个 a 的串 1 必定也是回文串。所以当 s[i]==s[j] 时，自然要看 dp[i+1][j-1] 是不是一个回文串。
 *
 */
class Solution {
    public int countSubstrings(String s) {
        /*//1.动态规划
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    ans++;
                }
            }
        }
        return ans;*/
        //中心扩展法
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;//偶数时与left指向同一个，奇数时指向后一个。
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

