public class DLL {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;

    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("empty");
            return;
        } else if (head.next == null) {
            head = tail = null;
        } else {
            Node oldHead = head;
            head = head.next;
            head.prev = null;
            oldHead.next = oldHead = null;

        }
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("empty");
            return;
        } else if (head.next == null) {
            head = tail = null;
        } else {
            Node oldTail = tail;
            tail = tail.prev;
            tail.next = null;
            oldTail.prev = oldTail = null;
        }
    }

    public void reverse() {
        Node previousNode = null;
        Node currentNode = head = tail;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            currentNode.prev = nextNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
    }

    public static void main(String[] args) {

    }
}