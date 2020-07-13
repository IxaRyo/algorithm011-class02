//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

package leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] pre;



    public TreeNode buildTree(int[] preorder, int[] inorder) {

        pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode helper(int is, int ie, int ps, int pe){

        if (ie < is || pe < ps) {
            return null;
        }

        int val = pre[ps];

        TreeNode root = new TreeNode(val);
        int ri = map.get(val);

        //靠近根节点，所以不加1？
        root.left = helper(is, ri - 1, ps + 1, ps + ri - is);
        root.right = helper(ri + 1, ie, ps + ri - is + 1, pe);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}