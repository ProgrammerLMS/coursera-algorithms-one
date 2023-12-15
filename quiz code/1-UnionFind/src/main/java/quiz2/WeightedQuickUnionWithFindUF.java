package quiz2;

public class WeightedQuickUnionWithFindUF {
    /* ids[p] = q means the root of P-th Node is Q-th Node */
    private int[] ids;

    /* size[i] means number of objects in the tree rooted at i */
    private int[] size;

    /* 以i为根的连通分量所包含的最大值 */
    private int[] maxValues;

    public WeightedQuickUnionWithFindUF(int N) {
        ids = new int[N];
        size = new int[N];
        maxValues = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
            size[i] = 1;
            maxValues[i] = i;
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
    /* the root of p is q */
    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if (pRoot == qRoot) {
            return;
        }
        if (size[pRoot] < size[qRoot]) {
            ids[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
            if (maxValues[qRoot] < p) {
                maxValues[qRoot] = p;
            }
        } else {
            ids[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
            if (maxValues[pRoot] < q) {
                maxValues[pRoot] = q;
            }
        }
    }

    /* find the max element in the connected component containing i */
    public int find(int i) {
        return maxValues[getRoot(i)];
    }

}
