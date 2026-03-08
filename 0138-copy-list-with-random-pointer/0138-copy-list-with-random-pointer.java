/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashSet<Node> st = new HashSet<>();
        HashMap<Node,Node> mp = new HashMap<>();
        if(head == null) return null;

        Node retu  = null;
        while(head!=null) {
            Node h;
            if(!st.contains(head))
                { h = new Node(head.val);
                 st.add(head);
                 mp.put(head,h);
                }
            else {
                 h = mp.get(head);
            }
            if(retu == null) retu = h;
            Node nxt = head.next;
            Node cnxt;
            if(nxt!=null) {
            if(st.contains(nxt)) {
                cnxt = mp.get(nxt);
                
            } else {
                cnxt = new Node(nxt.val);
                st.add(nxt);
                mp.put(nxt,cnxt);
            }
            h.next = cnxt;
           
            }

            Node ran = head.random;
            Node cran;
            if(ran!=null) {
            if(st.contains(ran)) {
                cran = mp.get(ran);
                
            } else {
                cran = new Node(ran.val);
                st.add(ran);
                mp.put(ran,cran);
            }
            h.random = cran;
            }

            head = head.next;

        }

        return retu;
    }
}