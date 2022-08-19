import utils.ListNode;

public class SortList_148 {
    // Merge Sort
    // Time: O(NlogN), Space: O(N)
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }

    public static void main(String[] args) {
        ListNode ln9 = new ListNode(3);
        ListNode ln8 = new ListNode(1, ln9);
        ListNode ln7 = new ListNode(2, ln8);
        ListNode ln6 = new ListNode(4, ln7);
        System.out.println(sortList(ln6));

        ListNode ln5 = new ListNode(0);
        ListNode ln4 = new ListNode(4, ln5);
        ListNode ln3 = new ListNode(3, ln4);
        ListNode ln2 = new ListNode(5, ln3);
        ListNode ln1 = new ListNode(-1, ln2);
        System.out.println(sortList(ln1));

        System.out.println(sortList(new ListNode()));
    }
}
