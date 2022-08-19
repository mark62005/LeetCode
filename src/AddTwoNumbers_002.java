import utils.ListNode;

public class AddTwoNumbers_002 {
    // Time: O(M + N), Space: O(
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode ln19 = new ListNode(3);
        ListNode ln18 = new ListNode(4, ln19);
        ListNode ln17 = new ListNode(2, ln18);

        ListNode ln16 = new ListNode(4);
        ListNode ln15 = new ListNode(6, ln16);
        ListNode ln14 = new ListNode(5, ln15);
        System.out.println(addTwoNumbers(ln17, ln14));

        ListNode ln13 = new ListNode(0);

        ListNode ln12 = new ListNode(0);
        System.out.println(addTwoNumbers(ln13, ln12));

        ListNode ln11 = new ListNode(9);
        ListNode ln10 = new ListNode(9, ln11);
        ListNode ln9 = new ListNode(9, ln10);
        ListNode ln8 = new ListNode(9, ln9);
        ListNode ln7 = new ListNode(9, ln8);
        ListNode ln6 = new ListNode(9, ln7);
        ListNode ln5 = new ListNode(9, ln6);

        ListNode ln4 = new ListNode(9);
        ListNode ln3 = new ListNode(9, ln4);
        ListNode ln2 = new ListNode(9, ln3);
        System.out.println(addTwoNumbers(ln5, ln2));
    }
}
