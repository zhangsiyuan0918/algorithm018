// 49 字母异位词分组
// group-anagrams

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 501 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] s1 = s.toCharArray();
            Arrays.sort(s1);
            String s2 = String.valueOf(s1);
            if (!map.containsKey(s2))
                map.put(s2, new ArrayList<>());
            map.get(s2).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

