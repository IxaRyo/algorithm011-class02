//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法

package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        if (n == 0) {
            return res;
        }

        char[][] colParments = new char[n][];
        dfs(res, colParments, 0, n);

        return res;
    }

    public void dfs(List<List<String>> res, char[][] colParments, int RowNowIdx, int n) {

        if (RowNowIdx == n) {

            ArrayList<String> way = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                way.add(String.valueOf(colParments[i]));
            }

            res.add(way);
            return;
        }

        char[] singleRow = new char[n];
        Arrays.fill(singleRow, '.');


        for (int col = 0; col < n; col++) {

            singleRow[col] = 'Q';
            colParments[RowNowIdx] = singleRow;

            if (isVaild(colParments, RowNowIdx, col, n)) {

                dfs(res, colParments,RowNowIdx + 1, n);

            }

            colParments[RowNowIdx] = null;
            singleRow[col] = '.';

        }
    }

    private boolean isVaild(char[][] colParments, int NumOfRow, int colIdx, int n) {

        if (NumOfRow == 0) {
            return true;
        }

        for (int i = 0; i < NumOfRow; i++) {
            if (colParments[i][colIdx] == 'Q') {
                return false;
            }
        }

        for (int i = NumOfRow - 1, j = colIdx + 1; i >= 0 && j < n; i--, j++) {
            if (colParments[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = NumOfRow - 1, j = colIdx - 1; i >= 0 && j >= 0; i--, j--) {
            if (colParments[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}