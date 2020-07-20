学习笔记

### DFS代码 - 递归写法

~~~python
    visited = set()

    def dfs(node, visited) :
        visited.add(node)
        #process current node here
        for next_node in node.children();
            if not next_node in visited:
                dfs(next node, visited)
~~~

~~~python
    if tree.node is None :
        return []

    visited, stack = [], [tree, root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process (node)
        nodes = generate_related_nodes(node)
        stack.push(node)

    #orther processing work
~~~

### BFS代码

~~~python
    def BFS(graph, start, end) :
        queue = []
        queue.append(node)
        visited.add(start)

        while queue:
            node = queue.pop()
            nodes = generate_related_nodes(node)
            queue.push(nodes)
    #orther processing work
~~~

### 贪心算法

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结局是全局最好或最优的算法。

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心：当下做局部最优判断
回溯：能够回退
动态规划:最优判断+回退

简单地说，问题能够分解成**子问题**来解决，子问题的最优能递推到最终问题的最优解。这种子问题最优解称为**最优子结构**

### 二分查找

1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）(注：单链表因为没有索引，进行二分查找比较困难)

~~~java
public int binarrySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right ) {
        mid = left + (right - left) / 2;

        if(array[mid] == target) {
            return mid;
        }
        else if(array[mid] < target) {
            right = mid - 1;
        }
        else if(array[mid] > target) {
            left = mid + 1;
        } 
    }

    return -1;
}
~~~

4. 寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

数组没有旋转过，是升序排列，满足 last element > first element，即：

关于**中间旋转点**的特点：
所有变化的点左侧元素 > 数组第一个元素
所有变化的点右侧元素 < 数组第一个元素

找到数组的中间元素 mid。

如果中间元素 > 数组第一个元素，我们需要在 mid 右边搜索变化点。

如果中间元素 < 数组第一个元素，我们需要在 mid 做边搜索变化点。

当满足以下任意一个条件即可：

array[mid] > array[mid + 1]
array[mid - 1] > array[mid]