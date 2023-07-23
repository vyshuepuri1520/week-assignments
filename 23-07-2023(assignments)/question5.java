class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class question5{

    public static Node mergeLL(Node head1, Node head2) {
        Node mergedHead = null;
        Node tail = null;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (mergedHead == null) {
                    mergedHead = head1;
                    tail = head1;
                } else {
                    tail.next = head1;
                    tail = tail.next;
                }
                head1 = head1.next;
            } else {
                if (mergedHead == null) {
                    mergedHead = head2;
                    tail = head2;
                } else {
                    tail.next = head2;
                    tail = tail.next;
                }
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            tail.next = head1;
        }
        if (head2 != null) {
            tail.next = head2;
        }

        return mergedHead;
    }

    public static Node sortLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        Node firstHalf = sortLL(head);
        Node secondHalf = sortLL(slow);
        return mergeLL(firstHalf, secondHalf);
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head1 = new Node(25);
        head1.next = new Node(35);
        head1.next.next = new Node(12);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(36);
        head1.next.next.next.next.next = new Node(48);

        Node head2 = new Node(8);
        head2.next = new Node(32);
        head2.next.next = new Node(22);
        head2.next.next.next = new Node(45);
        head2.next.next.next.next = new Node(63);
        head2.next.next.next.next.next = new Node(49);

        System.out.print("Linked-List-1:");
        printLinkedList(head1);
        System.out.print("Linked-List-2:");
        printLinkedList(head2);
        Node mergedHead = mergeLL(head1, head2);
        Node sortedHead = sortLL(mergedHead);
        System.out.println("Sorted Linked-List:");
        printLinkedList(sortedHead);
    }
}

