import utils.ListNode;

public class ReverseLinkedList_206 {
    // Time: O(N)
    public static ListNode reverseList(ListNode head) {
        return reverseListHelper(head, null);
    }

    private static ListNode reverseListHelper(ListNode head, ListNode newHead) {
        // base case
        if (head == null) {
            return newHead;
        }
        // recursive case
        ListNode next = head.next;
        head.next = newHead;
        return reverseListHelper(next, head);
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        System.out.println(reverseList(ln1));

        ListNode ln6 = new ListNode(1);
        ln6.next = new ListNode(2);
        System.out.println(reverseList(ln6));

        System.out.println(reverseList(new ListNode()));
    }
}
