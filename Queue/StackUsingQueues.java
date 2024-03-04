package Queue;

import java.util.*;

public class StackUsingQueues {
    Queue<Integer> a = new LinkedList<>();
    Queue<Integer> b = new LinkedList<>();

    public boolean isEmpty() {
        return a.isEmpty() && b.isEmpty();
    }

    public void push(int data) {
        // Add data into the queue which is not empty and has elements in it
        if (!a.isEmpty()) {
            a.add(data);
        } else {
            b.add(data);
        }
    }

    public int pop() {
        // Send all the elements into the empty queue and hold the last element value
        // and remove it without adding into the empty queue
        if (isEmpty()) {
            System.out.println("Empty stack");
            return Integer.MIN_VALUE;
        }
        int top = -1;
        if (!a.isEmpty()) {
            while (a.size() > 1) {
                b.add(a.remove());
            }
            top = a.remove();
        } else {
            while (b.size() > 1) {
                a.add(b.remove());
            }
            top = b.remove();
        }
        return top;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.pop()); // Output: 2
        System.out.println(stack.pop()); // Output: 1
        System.out.println(stack.pop()); // Output: Empty stack
    }

}
