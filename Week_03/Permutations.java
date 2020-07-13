//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private  List<List<Integer>> res = new LinkedList<>();
    private int size;
    private int[]tmp;
    private int[] visited;

    public List<List<Integer>> permute(int[] nums) {

        this.size = nums.length;
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