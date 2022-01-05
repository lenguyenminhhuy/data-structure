// the standard way: sentinel head (dummy head)
public class RemoveDuplicate {

    public ListNode removeDuplicate(ListNode head){
        ListNode result = new ListNode(0, head);
        ListNode dummy = result;
        while (head != null) {
            // detect the begining of duplicates
            if (head.next != null && head.val == head.next.val){
                // check all duplicates
                while (head.val == head.next.val){
                    head = head.next; // update new head
                }
                dummy.next = head.next;
            }
            else {
                dummy = dummy.next;
            }
            head = head.next;
        }
        return result.next;
    }
    public static void main(String args[]){
        RemoveDuplicate rmDuplicate = new RemoveDuplicate();
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))));
        ListNode result = rmDuplicate.removeDuplicate(head);
        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}