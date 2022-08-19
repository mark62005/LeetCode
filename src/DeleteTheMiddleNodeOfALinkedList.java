import utils.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {
    public static ListNode deleteMiddle(ListNode head) {
        // Base Condition
        if(head == null || head.next == null) return null;
        // Pointers Created
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode ln13 = new ListNode(6);
        ListNode ln12 = new ListNode(2, ln13);
        ListNode ln11 = new ListNode(1, ln12);
        ListNode ln10 = new ListNode(7, ln11);
        ListNode ln9 = new ListNode(4, ln10);
        ListNode ln8 = new ListNode(3, ln9);
        ListNode ln7 = new ListNode(1, ln8);
        System.out.println(deleteMiddle(ln7));

        ListNode ln6 = new ListNode(4);
        ListNode ln5 = new ListNode(3, ln6);
        ListNode ln4 = new ListNode(2, ln5);
        ListNode ln3 = new ListNode(1, ln4);
        System.out.println(deleteMiddle(ln3));

        ListNode ln2 = new ListNode(1);
        ListNode ln1 = new ListNode(2, ln2);
        System.out.println(deleteMiddle(ln1));
    }
}
