//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

package leetcode.leetcode.editor.cn;
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if( m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }


//
//        int i = 0;
//        int nums1Index = 0;
//        int nums2Index = 0;
//        int nums1Length = m;
//        int nums2Length = n;
//
//        int[] tmp = new int[m + n];
//
//        while (nums1Length > 0 && nums2Length > 0) {
//
//            if(nums1[nums1Index] < nums2[nums2Index]) {
//                nums1Length--;
//                tmp[i++] = nums1[nums1Index++];
//            }
//            else {
//                nums2Length--;
//                tmp[i++] = nums2[nums2Index++];
//            }
//        }
//
//        if(nums1Length == 0) {
//            System.arraycopy(nums2, nums2Index, tmp, i, n - nums2Index);
//        }
//        else
//        {
//            System.arraycopy(nums1, nums1Index, tmp, i, m - nums1Index);
//        }
//
//        System.arraycopy(tmp, 0, nums1, 0, n + m);

        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        System.arraycopy(nums2, 0, nums1, 0,p2 + 1);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}