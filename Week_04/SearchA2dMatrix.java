//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找

package leetcode.leetcode.editor.cn;
public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int left = 0;
        int right = matrix[0].length * matrix.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            int RowMid = mid / matrix[0].length;
            int ColMid = mid % matrix[0].length;

            if (target == matrix[RowMid][ColMid]) {
                return true;
            }

            if (target < matrix[RowMid][ColMid]) {
                right = mid - 1;
            }
            else if (target > matrix[RowMid][ColMid]) {
                left = mid + 1;
            }


        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}