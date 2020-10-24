// 88 合并两个有序数组
// merge-sorted-array

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 670 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1.合并排序(时间复杂度较差)
        /*System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);*/
        //2.双指针
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        //如果p1指针遍历完成了但p2指针还没遍历完，此时应该继续遍历p2指针并填入p指针，由于p2是有序的，就直接用复制数组代替了遍历写入。
        //如果p2指针遍历完了但p1指针还没遍历完，此时应该继续遍历p1并填入p指针，但由于此时p1指针和p指针重合，所以可以省略遍历操作。

    }
}
//leetcode submit region end(Prohibit modification and deletion)

