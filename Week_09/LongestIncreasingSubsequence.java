//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

package leetcode.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int m = nums.length;
        int[][] dp = new int[m][2]; // 一个最大值 一个长度
        int MaxIdx = 0;

        dp[0][0] = nums[0];
        dp[0][1] = 1;

        for (int i = 1; i < nums.length; i++) {

            PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    heap.add(new Pair<>(j, dp[j][1]));
                }
            }

            if (heap.isEmpty()) {
                dp[i][0] = nums[i];
                dp[i][1] = 1;
            }
            else {
                int idx = heap.poll().getKey();
                dp[i][0] = Math.abs(dp[idx][0]) + nums[i];
                dp[i][1] = dp[idx][1] + 1;

            }

            if (dp[i][1] > dp[MaxIdx][1]) {
                MaxIdx = i;
            }
        }

        return dp[MaxIdx][1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}