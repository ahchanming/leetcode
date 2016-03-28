/**
 * Created by chanming on 16/3/28.
 */

public class Problem2 {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode now = head;
        int add = 0;
        while (l1 != null || l2 != null){
            if (l1 != null && l2 != null){
                ListNode tmp = new ListNode((l1.val + l2.val + add) % 10);
                now.next = tmp;
                now = tmp;
                add = ((l1.val + l2.val + add) / 10);
                l1 = l1.next;
                l2 = l2.next;
            }else if (l1 != null){
                ListNode tmp = new ListNode((l1.val + add) % 10);
                now.next = tmp;
                now = tmp;
                add = ((l1.val + add) / 10);
                l1 = l1.next;
            }else{
                ListNode tmp = new ListNode((l2.val + add) % 10);
                now.next = tmp;
                now = tmp;
                add = ((l2.val + add) / 10);
                l2 = l2.next;
            }
        }
        if (add > 0){
            ListNode tmp = new ListNode(add);
            now.next = tmp;
        }
        head = head.next;
        return head;
    }
}
