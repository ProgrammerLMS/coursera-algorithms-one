package ImprovedUnionFind;

/* 路径压缩的核心，依旧是让树的高度变小 */
/* 具体的操作就是，在遍历找根节点的时候，让每个路径上的节点，都直接指向最终根节点 */
public class PathCompressionQuickUnionUF {
    /* ids[p] = q means the root of P-th Node is Q-th Node */
    private int[] ids;

    public PathCompressionQuickUnionUF(int N) {
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    private int getRoot(int i) {
        while (i != ids[i]) {
            /* 这里不是直接指向最终根节点，而是指向父节点的上一级，也就是祖父节点 */
            /* 在实际应用中，人们发现这种近似的效果和直接指向最终父节点差不多 */
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    public boolean whetherConnect(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        ids[pRoot] = qRoot;
    }
}
