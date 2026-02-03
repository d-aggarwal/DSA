/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        Node currhead = null;
        Node currtail = head;
        
        
        while(currtail!=null) {
            
            while(currtail!=null && currtail.data == x) {
                currtail = currtail.next;
            }
            
            
            if(currtail == null && currhead == null) return null;
            if(currtail == null) {
                currhead.next = null;
                return head;
            } if(currhead == null) {
               if(currtail.prev !=null) currtail.prev.next = null;
               if(currtail.prev !=null) currtail.prev = null;
                head = currtail;
                currhead = currtail;
                
            } else {
                currhead.next = currtail;
                currtail.prev = currhead;
                // System.out.println(currhead.data +" "+currtail.data);
                currhead = currtail;
                
            }
            
            currtail = currtail.next;
        }
        
        return head;
    }
}