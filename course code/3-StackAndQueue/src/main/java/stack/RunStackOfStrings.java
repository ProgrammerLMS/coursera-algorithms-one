package stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RunStackOfStrings {

    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if (s.equals("-") && !stack.isEmpty())
                StdOut.print(stack.pop());
            else stack.push(s);
        }
    }
}
