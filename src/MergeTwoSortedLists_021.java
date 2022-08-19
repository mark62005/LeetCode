import utils.ListNode;

public class MergeTwoSortedLists_021 {
    // Time: O(M+N), Space: O(M+N)
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(4);
        ListNode ln4 = new ListNode(1);
        ListNode ln5 = new ListNode(3);
        ListNode ln6 = new ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;
        ln4.next = ln5;
        ln5.next = ln6;

        System.out.println(mergeTwoLists(ln1, ln4));
        System.out.println(mergeTwoLists(new ListNode(), new ListNode()));
        System.out.println(mergeTwoLists(new ListNode(), new ListNode(0)));
    }

}
