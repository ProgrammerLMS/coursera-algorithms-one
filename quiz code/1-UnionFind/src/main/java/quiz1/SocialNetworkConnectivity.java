package quiz1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SocialNetworkConnectivity {
    /* N-members */
    static int N = 6;

    /* M-pairs Union log */
    static int M = 5;

    /* we want to know the earliest time of P,Q */
    static int findP = 1, findQ = 5;

    public static void main(String[] args) throws IOException {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        String fileName = "1-UnionFind/src/main/resources/union-log.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int ansTimestamp = -1;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            String[] splits = line.split(" ");
            int p = Integer.parseInt(splits[0]);
            int q = Integer.parseInt(splits[1]);
            int timestamp = Integer.parseInt(splits[2]);
            uf.union(p, q);
            if (uf.whetherConnect(findP, findQ)) {
                ansTimestamp = timestamp;
                break;
            }
        }
        reader.close();
        System.out.println(ansTimestamp);
    }
}
