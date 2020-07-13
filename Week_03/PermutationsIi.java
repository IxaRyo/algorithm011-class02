//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法

package leetcode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private  List<List<Integer>> res = new LinkedList<>();
    private int size;
    private int[]tmp;
    private int[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {

        this.size = nums.length;
        Arrays.sort(nums);
        tmp = nums;
        visited = new int[nums.length];
        backtrack(1, new LinkedList<Integer>());
        return res;

    }

    private void backtrack(int first, LinkedList<Integer> curr) {

        if (curr.size() == size) {
            res.add(new LinkedList<>(curr));
        }

        for (int i = 0; i < tmp.length; i++) {

            if (visited[i] == 1) {
                continue;
            }


            if (i > 0 && tmp[i] == tmp[i - 1] && visited[i - 1] == 1)
            {
                break;
            }

            visited[i] = 1;
            curr.add(tmp[i]);
            backtrack(0, curr);
            visited[i] = 0;
            curr.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}