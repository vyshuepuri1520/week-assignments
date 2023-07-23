class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class questionno12 {
    public static void main(String[] args) {
        // Test cases
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed1 = reverseKGroup(head1, 2);
        printLinkedList(reversed1); // Output: 2 -> 1 -> 4 -> 3 -> 5 -> null

        ListNode head2 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed2 = reverseKGroup(head2, 3);
        printLinkedList(reversed2); // Output: 3 -> 2 -> 1 -> 4 -> 5 -> null
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);

            while (count > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
                count--;
            }
            head = curr;
        }
        return head;
    }

    private static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}