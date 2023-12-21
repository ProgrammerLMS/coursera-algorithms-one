package stack;

public class FixedCapacityStackOfStrings {

    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        if (N < s.length) {
            s[N++] = item;
        }
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
