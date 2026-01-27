/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public static ListNode iterative(ListNode head) {
        if(head.next ==null) return head;

        ListNode r = iterative(head.next);
        System.out.println(head.val);
        head.next.next = head;
        head.next = null;
        return r;   
    }
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        // ListNode prev = null;
        // ListNode curr = head;
        // ListNode next = head.next ;

        // while(curr !=null) {
        //     curr.next = prev;
        //     prev = curr;
        //     curr = next;
        //     if(curr!=null)next = curr.next;
        // }

        // return prev;

        return iterative(head);
    }
}