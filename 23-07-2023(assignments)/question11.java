class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class question11{

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            
            prev.next = second;
            first.next = second.next;
            second.next = first;

            
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }

    
    public static ListNode createLinkedList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        ListNode head1 = createLinkedList(nums1);
        System.out.print("Original List: ");
        printLinkedList(head1);

        ListNode swappedHead1 = swapPairs(head1);
        System.out.print("Swapped List: ");
        printLinkedList(swappedHead1);

        int[] nums2 = {};
        ListNode head2 = createLinkedList(nums2);
        System.out.print("Original List: ");
        printLinkedList(head2);

        ListNode swappedHead2 = swapPairs(head2);
        System.out.print("Swapped List: ");
        printLinkedList(swappedHead2);

        int[] nums3 = {1};
        ListNode head3 = createLinkedList(nums3);
        System.out.print("Original List: ");
        printLinkedList(head3);

        ListNode swappedHead3 = swapPairs(head3);
        System.out.print("Swapped List: ");
        printLinkedList(swappedHead3);
    }
}

