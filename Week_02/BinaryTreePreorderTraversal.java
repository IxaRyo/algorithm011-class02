//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();

        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res ) {

        if (root != null) {

            res.add(root.val);

            if (root.left != null) {
                helper(root.left, res);
            }

            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}