学习笔记


## ArrayLsit 数组

1.  特性
由于是连续内存空间分配，在索引查找性能很快，在随机插入或者删除方面需要挪动该元素的后半部分数据，所以性能较差，是一种比较简单数据结构。
2.  时间复杂度
索引查找Access->O(1)
元素查找Search->O(n) 
元素插入Insertion->O(n) //在数据开头插入是最坏情况o(n), 在结尾插入则是o(1),平均是o(n)
元素删除Deletion->O(n) //在数据开头删除是最坏情况o(n), 在结尾插入则是o(1),平均是o(n)

ArrayList具备initialCapacity属性，初始值为10，扩大后为16，既扩容后的大小= 原始大小+原始大小/2 + 1 （1.5倍方式扩容       ）
3.  常用接口
x.get(index);
x.add(实体);
迭代器

##  LinkedList 链表
1.  特性
实现的方式是链表，结构体中有成员变量中指向另一个节点的引用，因此在插入和删除方面性能较好。
可以当作queue来使用，addFirst(),getFirst(),removeFirst()等可以实现其**先进先出**的功能。
可以当作stack来使用，addLast(),getLast(),removeLast()等可以实现其**后进先出**的功能。
大部分没有强调First或Last的接口默认都是是队列头(First),pop push是把队列头看作是栈顶，poll是队列头。

linkedlist没有初始化大小，所以没有扩容一说法。
2.  时间复杂度
索引查找Access->O(n) //只能通过遍历
元素查找Search->O(n) 
元素插入Insertion->O(1) //在知道需要在哪个节点前后插入情况下进行插入下，只需要更改相关节点的索引，像头节点这样的插入是O(1)
元素删除Deletion->O(1) //在知道需要在哪个节点前后插入情况下进行删除下，只需要更改相关节点的索引，像头节点这样的删除是O(1)

3.  常用API
x.addAll() //可以插入一个集合
x.addFirst() //
x.addLast() //
x.​remove() // 删除队列头或者指定元素
x.removeFirst()
x.removeLast() 
x.pop() //stack的用法在队列头删除
x.push() // stack的用法在队列头添加

Exception|NULL
:---|:---
add(push)|offer
remove(pop)|poll
element|peek

=======================================================================

1.分析 Queue 和 Priority Queue 的源码。



<1>

PriorityQueue继承了AbstractQueue类， 而AbstractQueue类是实现了Queue接口。

Queue只是一个接口，实现它的类有LinkedList，PriorityQueue，LinkedBlockingQueue，BlockingQueue，ArrayBlockingQueue，LinkedBlockingQueue，PriorityBlockingQueue



<2>

PriorityQueue的构造函数可以传入比较器Comparator子类对象，作为元素排序比较的使用。

升序 o1 - 02 降序 o2 - o1

<3>

PriorityQueue的数据结构是高级数据结构“二叉堆”，因此offer实现插入元素的方法使用 siftUp(i, e)

poll实现取出第一元素则要使用siftDown。

<4>

(1)、add()和offer()区别:

add()和offer()都是向队列中添加一个元素。一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，调用 add() 方法就会抛出一个 unchecked 异常，而调用 offer() 方法会返回 false。因此就可以在程序中进行有效的判断！

 

 (2)、poll()和remove()区别：

remove() 和 poll() 方法都是从队列中删除第一个元素。如果队列元素为空，调用remove() 的行为与 Collection 接口的版本相似会抛出异常，但是新的 poll() 方法在用空集合调用时只是返回 null。因此新的方法更适合容易出现异常条件的情况。

 

(3)、element() 和 peek() 区别：

element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。


=======================================================================

2.plusOne (加一)

一开始思路是有问题，把数组先转换成一个整数long类型导致后面测试超出long范围就出错了。

只要数组加一 然后再mod 10 即可。 ==》 余数为0就是要数组下一个元素加1，如此类推到第0个元素

当第0个元素还是0就数组重新申请长度加1， a[0]  = 1 

平均：

时间分析 O(n)  空间分析O(1)  

3.MoveZeros(移动零）

实现的方法比较多，但是暴力方法貌似是无解的。移动数组最好的办法是用下标（低级语言指针）

设一个下标J，当符合目标的时候才行后移。

平均：

时间分析 O(N)  空间分析O(1)

4.TwoSum(两数之和)

一开始的思路是暴力方法，时间消耗比较长，不可以取。后来习得hashmap用法，将过去的记录放

在哈希结构体的查找时间是O(1)大大提升了速度，从嵌套循环变成单循环，时间从O(N^2)变成O(N)，

类似记录查询类的操作以后可以考虑用hashmap，属于空间换时间的一种。

平均：

时间分析O(N)，空间分析O(N)

5.SwapNodesInPairs(两两交换链表的节点)

这题难啊，首先是想到了使用递归方法来实现，但是无法验证递归返回的值，思路顿挫。

后来看答案从中理解到head制作的next其实可以一直next下去，并且作为递归参数使用，只要确认了递归的

的返回值，其实还是很好办。

时间分析 O(N) ，空间分析O(1) (递归？应该是O(N) )

可以使用遍历迭代方法，思路比递归简单。因为 整个链表  是以 a1<->a2 ，a3<->a4 这样形式的交换，a2相当于

相对于a3来说是不参与交换过程的，所以可以假定一个前置节点，以前置节点a0 交换它的后两个节点a1,a2,然后

节点后移至a1(目前顺序是a0,a2,a1,a3,a4),再对a3和a4进行交换。至于交换过程就以更改frist节点和前置节点current为原则就行。迭代就直接current = current.next.next

 

