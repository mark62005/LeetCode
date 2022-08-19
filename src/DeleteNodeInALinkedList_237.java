import utils.ListNode;

public class DeleteNodeInALinkedList_237 {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(4);
        ListNode ln2 = new ListNode(5);
        ListNode ln3 = new ListNode(1);
        ListNode ln4 = new ListNode(9);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;

        deleteNode(ln2);
        System.out.println(ln1);
    }
}
