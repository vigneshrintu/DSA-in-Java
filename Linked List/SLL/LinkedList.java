public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;

        }

    }

    public Node head;
    public Node tail;
    public int size;

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;

        }
        System.out.println("null");
        System.out.println();
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);// create node and initialise it with data
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;// link newnode to head
        head = newNode;// update head
    }

    public void addLast(int data) {
        Node newNode = new Node(data);// create node and initialise it with data
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;// link newnode to tail
        tail = newNode;// update tail
    }

    public void add(int data, int index) {
        if (index == 0) {
            addFirst(data);
        } else if (size == index) {
            addLast(data);// tail index is size-1 and beyond tail is size
        } else {
            Node newNode = new Node(data);
            size++;
            Node temp = head;
            int indexCount = 0;
            // make sure to go till (index-1)th node since it is perfect for starting
            // linking procedure
            while (indexCount < index - 1) {
                temp = temp.next;
                indexCount++;

            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;

        } else {
            int value = head.data;
            head = head.next;
            size--;
            return value;
        }

    }

    public int removeLast() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;

        } else {
            // put second last node's next as null then last node will be garbage collected
            Node temp = head;
            for (int i = 0; i <= size - 3; i++) {
                temp = temp.next;
            }
            int value = temp.next.data;
            temp.next = null;
            size--;
            tail = temp;
            return value;

        }

    }

    public int remove(int index) {
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();

        } else {
            int i = 0;
            Node temp = head;
            while (i < index) {
                temp = temp.next;
                i++;
            }
            i = temp.next.data;
            temp.next = temp.next.next;
            return i;
        }
    }

    public void reverse() {
        Node previousNode = null;
        Node currentNode = tail = head;
        Node nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
        /*
         * Basically you are placing three pointers on the nodes and breaking the
         * existing links and
         * reconnecting them in reverse order
         */
    }

    public Node findMidNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;// slow jumps one node at a time
            fast = fast.next.next;// fast jumps two nodes at a time
        }
        return slow;// at the end slow is at mid node
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // finding middle node
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;// slow jumps one node at a time
            fast = fast.next.next;// fast jumps two nodes at a time
        }
        Node midNode = slow;
        // reversing the linkedlist from midNode to tail
        Node previousNode = null;
        Node currentNode = midNode;
        Node nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        Node rightHalf = previousNode;
        // comparing the right and left halves of linkedlist until one of the head
        // becomes null
        Node leftHalf = head;
        while (rightHalf != null) {
            if (rightHalf.data != leftHalf.data) {
                return false;
            }
            leftHalf = leftHalf.next;
            rightHalf = rightHalf.next;
        }
        return true;

    }

    public void removeCycleInLL() {
        Node slow = head;
        Node fast = head;
        boolean cycleExists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycleExists = true;
                return;
            }
            if (!cycleExists) {
                return;
            }
            // if cycle exists then shift slow to head and start incrementing both pointers
            // by one
            slow = head;
            Node lastNode = null;
            while (slow != fast) {
                lastNode = fast;
                // slow and fast will meet at intersection of loop when we increment them by one
                // so store the fast in lastNode so that you can later put lastNode.next to null
                // and break the cycle by removing the node which is in intersection
                slow = slow.next;
                fast = fast.next;
            }
            lastNode.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.add(1, 0);
        ll.add(2, 1);
        ll.add(99, 2);
        ll.display();
        System.out.println(ll.size);

    }

}