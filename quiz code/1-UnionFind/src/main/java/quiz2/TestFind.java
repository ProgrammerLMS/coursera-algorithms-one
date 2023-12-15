package quiz2;

public class TestFind {
    public static void main(String[] args) {
        WeightedQuickUnionWithFindUF quickUnionWithFindUF =
                new WeightedQuickUnionWithFindUF(15);
        /* 连通分量1: 0,2,4,9 */
        quickUnionWithFindUF.union(0, 2);
        quickUnionWithFindUF.union(0, 4);
        quickUnionWithFindUF.union(9, 0);
        /* 连通分量2: 1,3,5 */
        quickUnionWithFindUF.union(3, 1);
        quickUnionWithFindUF.union(3, 5);
        /* 连通分量3: 7,6,8,10,14 */
        quickUnionWithFindUF.union(6, 7);
        quickUnionWithFindUF.union(6, 8);
        quickUnionWithFindUF.union(8, 10);
        quickUnionWithFindUF.union(8,14);
        /* 连通分量4: 11,12 */
        quickUnionWithFindUF.union(11, 12);
        /* 别忘了孤独的 13 */
        for (int i = 0; i < 15; i ++) {
            int max = quickUnionWithFindUF.find(i);
            System.out.printf("%d 所在的连通分量最大值是：%d\n", i, max);
        }
    }
}
