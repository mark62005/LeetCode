package arrays;

import utils.ListNode;

public class ReverseLinkedListII_092 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0); // created newHead node
        newHead.next = head;
        ListNode prev = newHead; // initialising prev pointer on newHead node

        for(int i = 0; i < left - 1; i++)
            prev = prev.next; // adjusting the prev pointer on its actual index

        ListNode curr = prev.next; // curr pointer will be just after prev
        // reversing
        for(int i = 0; i < right - left; i++){
            ListNode after = curr.next; // after pointer will be after curr
            curr.next = after.next;
            after.next = prev.next;
            prev.next = after;
        }
        return newHead.next;
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

        System.out.println(reverseBetween(ln1, 2, 4));
        System.out.println(reverseBetween(new ListNode(5), 1, 1));
    }
}
