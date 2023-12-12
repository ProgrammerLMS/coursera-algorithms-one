package BasicUnionFind;

public class QuickUnionUF {

    /* ids[p] = q means the root of P-th Node is Q-th Node */
    private int[] ids;

    public QuickUnionUF(int N) {
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
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

    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        ids[pRoot] = qRoot;
    }
}
