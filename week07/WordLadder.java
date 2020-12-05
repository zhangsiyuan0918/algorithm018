// 127 单词接龙
// word-ladder

//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 660 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord) || wordSet.size() == 0) {
            return 0;
        }
        wordSet.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visitied = new HashSet<>();
        visitied.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (valid(currWord, endWord, wordSet, queue, visitied)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }
    private boolean valid(String currWord, String endWord, Set<String> wordSet, Queue<String> queue, Set<String> visitied) {
        char[] c = currWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char old = c[i];
            for (char c1 = 'a'; c1 <= 'z'; c1++) {
                if (old == c1) {
                    continue;
                }
                c[i] = c1;
                String nextWord = String.valueOf(c);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visitied.contains(nextWord)) {
                        queue.add(nextWord);
                        visitied.add(nextWord);
                    }
                }
            }
            c[i] = old;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

