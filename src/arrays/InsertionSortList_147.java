package arrays;

import utils.ListNode;

public class InsertionSortList_147 {
    // Time: O(N^2), Space: O(1)
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head.next;
        ListNode pre = head;
        while (current != null) {
            if (current.val >= pre.val) {
                current = current.next;
                pre = pre.next;
            }
            else {
                pre.next = current.next;
                if (current.val <= head.val) {
                    current.next = head;
                    head = current;
                }
                else {
                    ListNode search = head;
                    while (search.next != null && search.next.val < current.val) {
                        search = search.next;
                    }
                    ListNode temp = search.next;
                    search.next = current;
                    current.next = temp;
                }
                current = pre.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode ln9 = new ListNode(3);
        ListNode ln8 = new ListNode(1, ln9);
        ListNode ln7 = new ListNode(2, ln8);
        ListNode ln6 = new ListNode(4, ln7);
        System.out.println(insertionSortList(ln6));

        ListNode ln5 = new ListNode(0);
        ListNode ln4 = new ListNode(4, ln5);
        ListNode ln3 = new ListNode(3, ln4);
        ListNode ln2 = new ListNode(5, ln3);
        ListNode ln1 = new ListNode(-1, ln2);
        System.out.println(insertionSortList(ln1));
    }
}
