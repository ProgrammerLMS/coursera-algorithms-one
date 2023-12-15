# Quiz of Union Find

## 1. Social network connectivity

### 1.1 Description

Given a social network containing $n$ members and a log file containing $m$ timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm **should be $m\log{n}$ or better** and use extra space proportional to $n$.

### 1.2 Analysis

#### 1.2.1 case1-指定某两个对象建立联系的最早时间

要得到每对成员确立朋友关系的最早时间，实际上就是确认第一条使得两个连通分量连接的边。

由于我们当前拥有按时间排序的Union日志文件，我们可以根据文件中的Union记录，**依时间顺序进行Union操作，每次操作完检查两节点是否connect**。

如果在某次Union之后实现了connect，则本次Union操作一定是最早使得连通分量连接的边。

#### 1.2.2 case2-对于全部对象都建立联系的最早时间

全部对象都建立联系，即任意两个对象之间都是connect的，最简单的思路就是每次Union之后再循环判断是否所有对象都满足connect，但是显然这样操作的时间成本太高

另一方面，我们注意到，全部对象都建立联系，说明**整体只有一个连通分量**，而每次进行Union操作时，连通分量的个数都会减一，因为我们需要在Union-Find数据结构中，**维护一个统计当前连通分量个数的属性**，一旦在某次操作之后，连通分量的个数为1，则必定是全部建立连接的最早时间。

具体代码见quiz code/1-union find，测试文件见union-log.txt

## 2. Union-find with specific canonical element

### 2.1 Description

Add a method $find()$ to the union-find data type so that $find(i)$ returns the largest element in the connected component containing $i$. The operations, $union()$, $connected()$, and $find()$ should all take logarithmic time or better.

For example, if one of the connected components is ${1,2,6,9}$, then the $find()$ method should return $9$ for each of the four elements in the connected components.

### 2.2 Analysis

#### 2.2.1 暴力遍历

本题就是需要找到某个连通分量所包含的最大值，一种比较简单比较暴力的思路是：对于给定的i，我们遍历全部对象，寻找所有满足connect的对象中的最大值，伪代码如下：

```java
public int find(int i) {
    int max = 0;
    for (int k = N;k >= 0; k--) {
        if (connected(k, i)) {
            if (k > max) {
                max = k;
                break;
            }
        }
    }
    return max;
}
```

#### 2.2.2 “边构造边统计”思想

我们在Union-Find数据结构中，**维护一个统计当前连通分量最大值的数组**，如下：

```java
/* 以i为根的连通分量所包含的最大值 */
int[] maxValues = new int[N];
/* 以1为根的连通分量的最大值是8 */
maxvalues[1] = 8;
```

具体代码见quiz code/1-union find

## 3. Successor with delete

### 3.1 Description

Given a set of $n$ integers $S={0,1,...,n−1}$ and a sequence of requests of the following form:

- Remove $x$ from $S$
- Find the *successor* of $x$: the smallest $y$ in $S$ such that $y≥x$.

design a data type so that all operations (except construction)  take **logarithmic** time or better in the worst case.

### 3.2 Analysis

本题题意是，我们进行如下得一种操作，从S中移除x，并找到一个大于x得最小数，上述所有步骤都必须不超过对数时间
