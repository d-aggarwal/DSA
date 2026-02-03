/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer> > res
            = new ArrayList<>();

        // Set two pointers, first to the beginning of DLL
        // and second to the end of DLL.
        Node first = head;
        Node second = head;

        // Move second to the end of the DLL
        while (second.next != null)
            second = second.next;

        // Iterate through the list using two pointers to
        // find pairs
        while (first != second && second.next != first) {

            // If the sum of the two nodes is equal to
            // target, add the pair
            if ((first.data + second.data) == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(first.data);
                pair.add(second.data);
                res.add(pair);

                // Move first in forward direction
                first = first.next;

                // Move second in backward direction
                second = second.prev;
            }
            else {
                if ((first.data + second.data) < target)
                    first = first.next;
                else
                    second = second.prev;
            }
        }

        return res;
        
    }
}
