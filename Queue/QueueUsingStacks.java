package Queue;

import java.util.*;

public class QueueUsingStacks {
    static Stack<Integer> a = new Stack<>();
    static Stack<Integer> b = new Stack<>();

    public static void add(int data) {
        // Send all values in a into b until a becomes empty
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        // When a becomes empty then push new value
        a.push(data);
        // Finally,send all values in b back into a until b becomes empty
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    public static int remove() {
        if (a.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return a.pop();
    }

    public static int peek() {
        if (a.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return a.peek();
    }
}
