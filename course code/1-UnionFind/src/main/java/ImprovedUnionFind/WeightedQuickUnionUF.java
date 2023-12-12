package ImprovedUnionFind;

/* 所谓权重，就是让小树和大树平衡一点
   节点少的树，一定要做节点多的大树的子树 */
public class WeightedQuickUnionUF {
    /* ids[p] = q means the root of P-th Node is Q-th Node */
    private int[] ids;

    /* size[i] means number of objects in the tree rooted at i */
    private int[] size;

    public WeightedQuickUnionUF(int N) {
        ids = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
            size[i] = 1;
        }
    }

    private int getRoot(int i) {
        while (i != ids[i]) {
            i = ids[i];
        }
        return i;
    }

    public boolean whetherConnect(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    /* 有效控制了树的高度，getRoot方法不会达到O(n)级别 */
    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if (pRoot == qRoot) {
            return;
        }
        if (size[pRoot] < size[qRoot]) {
            ids[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            ids[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}
