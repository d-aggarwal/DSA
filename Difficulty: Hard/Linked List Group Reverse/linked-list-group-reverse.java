/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        int i =0;
        Node chead = null;
        Node nexthead = null;
        Node prev = null;
        Node curr = head;
        Node nxt = curr.next;
        Node r = head;
        if(k==1) return head;
        while (curr!=null) {
            // System.out.println(curr.data);
            i++;
            //  System.out.println(curr.data + " "+i);
            curr.next = prev;
            if(i%k ==0 ) {
                //  System.out.println(curr.data);
                if(chead!=null) chead.next = curr;
                else r = curr;
                chead = nexthead;
                prev = null;
            } else if(nxt == null && chead!=null ) {
                chead.next = curr;
                // System.out.println("in the loop");
                break;
            }
            else{
                prev = curr;
            }
            
            if(i%k ==1) nexthead = curr;
            // if(nxt == null && k==1) return curr;
            curr = nxt;
            // if(curr == null && k==1) return curr;
            if(curr!=null)nxt = curr.next;
            
        }
        
        return r;
        
    }
}