public class StackLL {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return Integer.MIN_VALUE;
        }
        int top = head.data;
        head = head.next;
        return top;

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

    }

}
