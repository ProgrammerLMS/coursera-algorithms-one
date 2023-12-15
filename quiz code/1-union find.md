# Quiz of Union Find

## 1. Social network connectivity

### 1.1 Description

Given a social network containing $n$ members and a log file containing $m$ timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be $m\log{n}$ or better and use extra space proportional to $n$.

### 1.2 Analysis

要得到每对成员确立朋友关系的最早时间，实际上就是确认第一条使得两个连通分量连接的边。由于我们当前拥有按时间排序的Union日志文件，我们可以根据文件中的Union记录，依时间顺序进行Union操作，每次操作完检查两节点是否connect，如果在某次Union之后实现了connect，则本次Union操作一定是最早使得连通分量连接的边。具体代码见quiz code/1-union find，测试文件见union-log.txt





