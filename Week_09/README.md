学习笔记

## 高级动态规划

这里复习下动态规划的要点及解题标准步骤 关键词：

分治
最优子结构
动态递推
一般找最优解的可以先考虑是否能用dp来解决
多练、数学、逻辑思维

定义状态，不同的状态定义会导致不同的dp方程，所以状态定义很重要。根据题目场景可以考虑一维、二维、三维、甚至更多维数，有些一目了然，有些则要花点心思

### DP顺推模板

~~~java
function DP()
 dp = [][] #二维情况
 
 for i = 0...M {
   for j = 0...N {
      dp[i][j] = _Function(dp[i`][j`]...)
   }
 }
 return dp[M][N];
~~~

## 字符串匹配算法

Atoi代码示例：

~~~java
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    //1. Empty string
    if(str.length() == 0) return 0;

    //2. Remove Spaces
    while(str.charAt(index) == ' ' && index < str.length())
        index ++;

    //3. Handle signs
    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }

    //4. Convert number and avoid overﬂow
    while(index < str.length()){
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;

        //check if total will be overﬂow after 10 times and add digit
        if(Integer.MAX_VALUE/10 < total ||
                Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        total = 10 * total + digit;
        index ++;
    }
    return total * sign;
} 
~~~


对暴力法的优化，在匹配过程中遇到那些不可匹配的字符的时候，希望用某些规律将模式串右滑多几位，跳过那些肯定不会匹配的情况，时间复杂度O(m+n)

~~~java
public class KMP {

    private static int[] prefixTable(char pattern[]) {

        if (pattern == null || pattern.length == 0) {
            return null;
        }

        int n = pattern.length;
        int len = 0;
        int i = 1;
        int[] prefix = new int[n];

        while ( i < n) {
            if (pattern[i] == pattern[len]) {
                prefix[i++] = ++len;
            }
            else {
                if (len > 0) {
                    len = prefix[len - 1];
                }
                else {
                    prefix[i] = len;
                    i++;
                }
            }
        }

        return prefix;
    }

    private void movePrefixTable(int[] prefix) {
        if (prefix == null) {
            return;
        }

        for (int i = prefix.length - 1; i > 0;i--) {
            prefix[i] = prefix[i - 1];
        }

        prefix[0] = -1;
    }

    public int KmpSearch(char[] text , char[] pattern) {

        int i = 0;
        int j = 0;
        int m = text.length;
        int n = pattern.length;

        int prefixArray[] = prefixTable(pattern);
        movePrefixTable(prefixArray);

        while (i < m) {
            if (j == n - 1 && text[i] == pattern[j]) {
                return i - j;
            }
            if (text[i] == pattern[j]) {
                i++;
                j++;
            }
            else {
                j = prefixArray[j];
                if (j == -1) {
                    j++;
                    i++;
                }
            }
        }

        return -1;
    }
}

~~~


