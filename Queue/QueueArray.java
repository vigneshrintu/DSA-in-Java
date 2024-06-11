package Queue;

import java.util.*;

public class QueueArray {
    public class Queue {
        int arr[];
        int size;
        int rear;
        int front;

        public Queue(int n) {
            this.arr = new int[n];
            this.size = n;
            this.rear = -1;
            this.front = -1;
        }

        public boolean isEmpty() {
            return (front == -1 && rear == -1);
        }

        public boolean isFull() {
            return ((rear + 1) % size == front);
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
                // If adding first element into the queue then put front to 0 from -1
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            int top = arr[front];
            if (front == rear) {
                front = rear = -1;
                // front and rear will be equal only when initialised queue or only one element
                // is in queue.
                // When only one element in queue then front is at 0 and rear is at 0;
            } else {
                front = (front + 1) % size;
            }
            return top;
        }

        public void display() {
            int temp = front;
            while (temp <= rear) {
                System.out.print(arr[temp] + " ");
                temp++;
            }
            System.out.println();
        }

        public void reverse() {
            // Use a stack to reverse a queue
            // Alternate way could be removing from front and adding in the rear in a loop
            // of queue size
            Stack<Integer> stack = new Stack<>();
            while (!isEmpty()) {
                stack.push(remove());
            }
            while (!(stack.isEmpty())) {
                add(stack.pop());
            }
        }

    }

    public static void main(String[] args) {

        QueueArray.Queue s = new QueueArray().new Queue(5);
        QueueArray.Queue p = new QueueArray().new Queue(5);
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        s.display();
        for (int i = 0; i < 5; i++) {
            p.add(s.remove());
        }
        p.display();

    }
}
