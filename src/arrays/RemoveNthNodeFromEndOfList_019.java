package arrays;

import utils.ListNode;

public class RemoveNthNodeFromEndOfList_019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) {
            assert head != null;
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode ln7 = new ListNode(5);
        ListNode ln6 = new ListNode(4, ln7);
        ListNode ln5 = new ListNode(3, ln6);
        ListNode ln4 = new ListNode(2, ln5);
        ListNode ln3 = new ListNode(1, ln4);
        System.out.println(removeNthFromEnd(ln3, 1));

        ListNode ln2 = new ListNode(2);
        ListNode ln1 = new ListNode(1, ln2);
        System.out.println(removeNthFromEnd(ln1, 1));
    }
}
