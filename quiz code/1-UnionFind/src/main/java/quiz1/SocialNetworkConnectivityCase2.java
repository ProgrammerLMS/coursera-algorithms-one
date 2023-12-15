package quiz1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SocialNetworkConnectivityCase2 {
    /* N-members */
    static int N = 6;

    /* M-pairs Union log */
    static int M = 5;

    /* 确定全部成员都建立连接的最早时间 */
    public static void main(String[] args) throws IOException {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        String fileName = "1-UnionFind/src/main/resources/union-log.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int ansTimestamp = -1;
        while ((line = reader.readLine()) != null) {
            String[] splits = line.split(" ");
            int p = Integer.parseInt(splits[0]);
            int q = Integer.parseInt(splits[1]);
            int timestamp = Integer.parseInt(splits[2]);
            uf.union(p, q);
            System.out.println("连通分量的个数是：" + uf.count());
            if (uf.count() == 1) {
                ansTimestamp = timestamp;
                break;
            }
        }
        reader.close();
        System.out.println(ansTimestamp);
    }
}
