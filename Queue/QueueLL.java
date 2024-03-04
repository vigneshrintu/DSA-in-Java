package Queue;

public class QueueLL {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Assume head as front and tail as rear

    public Node head;
    public Node tail;

    public boolean isEmpty() {
        if (head == null && tail == null) {
            return true;
        }
        return false;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;

    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return Integer.MIN_VALUE;
        }
        int top = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return top;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return Integer.MIN_VALUE;
        }
        return head.data;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLL s = new QueueLL();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.display();
        s.remove();
        s.display();

    }

}
