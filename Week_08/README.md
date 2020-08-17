学习笔记






## 排序

各种排序时间复杂度：

[sort](pic/sort.png)

比较类排序：
通过比较来决定元素间相对次序，由于其时间复杂度不能突破O(nlogn),因此也称为非线性时间比较类排序
（类似系统函数中的comparator）

非比较类排序:
不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序

### 1 o(n^2) --- 初级排序

选择排序 (Selection Sort)
每次找最小值，然后放到待排序数组的起始位置。

插入排序 (Insertion Sort)
从前到后逐步构建有序序列；对未排序数据，在已排序序列中从后向前扫描，找到相对应位置并插入。

冒泡排序 (Bubble Sort)
嵌套循环，每次查看相邻的元素如果逆序，则交换。

#### 1.1 选择排序代码

~~~java
    //平均时间：O(n^2)
    public static int[] select(int[] array) {
        for (int i = 0; i < array.length; i++) {

            int minIdx = i;

            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }

            int tmp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = tmp;
        }
        return array;
    }
~~~

### 1.2 冒泡排序

~~~java
    //平均时间 ：O(n^2)
    public static int[] bubble(int[] array) {
        if (array == null) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) { //由小到大 是大于， 由大到小 是小于
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        return array;
    }
~~~

### 2 O(logn) 


快速排序 （Quick Sort）

数组取标杆pivot, 将小元素放pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排；以达到整个序列有序。


归并排序(Merge Sort)

把长度为n的输入序列分成两个长度为n/2的子序列；
对这两个子序列分别采用归并排序；
将两个排序好的子序列合并成一个最终序列；

归并和快排具有相似性，但步骤顺序相反

归并：先排序左右子数组，然后合并两个有序子数组
快排：先调出左右子数组，然年对于左右子数组进行排序


堆排序（Head Sort）-插入O(logN), 取最大/小值O(1)

1.数组元素依次建立小顶堆
2.依次取堆顶元素，并删除


### 2.1 快速排序代码

~~~java
    /*
    *
    *  快速排序
    *数组取标杆pivot, 将小元素放pivot左边，
    * 大元素放右侧，然后依次对右边和右边的子数组继续快排；以达到整个序列有序。
    * */

    public static void quickSort(int[] array, int begin, int end) {

        if (end <= begin) {
            return;
        }

        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot -1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }

        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return  counter;
    }
~~~

### 2.2 归并排序代码

~~~java
    /*
    *
    *  快速排序
    *数组取标杆pivot, 将小元素放pivot左边，
    * 大元素放右侧，然后依次对右边和右边的子数组继续快排；以达到整个序列有序。
    * */

    public static void quickSort(int[] array, int begin, int end) {

        if (end <= begin) {
            return;
        }

        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot -1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }

        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return  counter;
    }
~~~

### 2.3 堆排序代码

~~~java
    /*
    *   1.数组元素依次建立小顶堆
        2.依次取堆顶元素，并删除
    *
    * */
    public void heapSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        
        BinaryHeap binaryHeap = new BinaryHeap(array.length);

        for (int i : array) {
            binaryHeap.insert(i);
        }
        
        //因为BinaryHeap是大顶堆，所以从后面开始赋值
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = binaryHeap.delete(0);
        }
    }
~~~

### 3 o(n) --特殊排序

计数排序(Counting Sort)
计数排序要求输入的空间必须是有确定范围的整数。将输入的数据值转化为键存储在额外开辟的数组空间中；然后依次把计数大于1的值填充回原数组。

桶排序(Bucket Sort)
桶排序的工作原理；假设输入的数据服从均匀分步，将数据分到有限数量桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归的方式继续使用桶排序进行排序）。

基数排序(Radix Sort)
基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是优先级顺序的，先按低优先级排序，再按高优先级排序。

