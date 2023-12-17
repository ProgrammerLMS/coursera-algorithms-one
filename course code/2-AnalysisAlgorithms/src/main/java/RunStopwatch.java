import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class RunStopwatch {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,-1,-2,-3};
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(ThreeSum.count(a));
        double time = stopwatch.elapsedTime();
    }
}
