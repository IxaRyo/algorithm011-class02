//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numIsLands = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                Queue<Integer> queue = new LinkedList<>();

                if (grid[r][c] == '1') {
                    numIsLands++;

                    grid[r][c] = 0;
                    queue.add(r * nc + c);

                    while (!queue.isEmpty()) {

                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            int id = queue.poll();
                            int row = id / nc;
                            int col = id % nc;

                            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                                queue.add((row - 1) * nc + col);
                                grid[row - 1][col] = '0';
                            }

                            if (row + 1 < nr && grid[row + 1][col] == '1') {
                                queue.add((row + 1) * nc + col);
                                grid[row + 1][col] = '0';
                            }

                            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                                queue.add(row * nc + col - 1);
                                grid[row][col - 1] = '0';
                            }

                            if (col + 1 < nc && grid[row][col + 1] == '1') {
                                queue.add(row * nc + col + 1);
                                grid[row][col + 1] = '0';
                            }


                        }
                    }
                }
            }
        }

        return numIsLands;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}