package BasicUnionFind;

public class QuickFindUF {
    // ids[p] = q means P-th Node is in Set Q
    private int[] ids;

    public QuickFindUF(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    public boolean whetherConnect(int p, int q) {
        return ids[p] == ids[q];
    }

    /* O(n), if we do n times union, time cost will be n^2 */
    public void union(int p, int q) {
        int pid = ids[p];
        int qid = ids[q];
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pid) {
                ids[i] = qid;
            }
        }
    }
}
