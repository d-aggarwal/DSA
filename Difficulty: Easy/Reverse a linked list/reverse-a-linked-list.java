/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node reverseList(Node head) {
        // code here
        Node prev= null;
        Node curr = head;
        Node n = curr.next;
        
        while(curr!=null) {
            curr.next = prev;
            prev=  curr;
            curr = n;
            
            if(curr!=null)n = curr.next;
        }
        return prev;
        }
}