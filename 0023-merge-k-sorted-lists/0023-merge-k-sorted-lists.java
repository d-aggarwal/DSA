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
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode itr = ans;

        while(l1!=null && l2!=null) {
            if(l1.val < l2.val) {
                itr.next = l1;
                l1 = l1.next;
            }else {
                itr.next = l2;
                l2 = l2.next;
            }
            itr = itr.next;
        }

        if(l1!=null) itr.next = l1;
        if(l2!=null) itr.next = l2;

        return ans.next;
    }
    public ListNode mergeLists(ListNode[] lists, int start, int end){
        if(start>end) return null;
        if(start == end) return lists[start];

        int mid = (start+end)/2;

        ListNode l1 = mergeLists(lists, start, mid);
        ListNode l2 = mergeLists(lists, mid+1, end);

        return merge(l1,l2);

    }
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length-1);
    }
}