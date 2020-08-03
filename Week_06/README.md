学习笔记

动态规划
动态规划和递归或者分治没有根本上的区别（关键看有无最优的子结构）

共性：找到重复子问题

差异性：最优子结构、中途可以淘汰次优解

关键点：

最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], …)
储存中间状态：opt[i]
递推公式（状态转移方程或者DP方程）
动态规划模板：

~~~java
public void dp() {
    int[][] dp = new int[m+1][n+1];
    for(int i = 0; i <= m; i++) {
        for(int j = 0; j <= n; j++) {
            dp[i][j] = ... // dp方程
        }
    }
    return dp[m][n];
}
~~~java