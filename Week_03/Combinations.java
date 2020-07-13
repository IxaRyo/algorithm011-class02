//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法

package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res = new LinkedList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {

        this.n = n;
        this.k = k;

        backtrack(1, new LinkedList<Integer>());
        return res;
    }

    private void backtrack(int first, LinkedList<Integer> curr) {

        //
        if (curr.size() == k) {
            res.add(new LinkedList<>(curr));
        }

        for (int i = first; i <= n; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}