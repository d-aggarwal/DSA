/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    TreeNode root;
    TreeNode cur;


    public BSTIterator(TreeNode root) {
        this.root = root;
        this.cur = root;
    }
    
    public int next() {

        // Loop until the current
        // node is not NULL
        while (cur != null) {
            // If the current node's
            // left child is NULL
            if (cur.left == null) {
                // Add the value of the current
                // node to the inorder list
                
                // Move to the right child
                int ans = cur.val;
                cur = cur.right;
                return ans;
            } else {
                // If the left child is not NULL,
                // find the predecessor (rightmost node
                // in the left subtree)
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the predecessor's right child
                // is NULL, establish a temporary link
                // and move to the left child
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    // If the predecessor's right child
                    // is already linked, remove the link,
                    // add current node to inorder list,
                    // and move to the right child
                    prev.right = null;
                    int sans = cur.val;
                    cur = cur.right;
                    return sans;
                }
            }
        }
        return 0;
        
    }
    
    public boolean hasNext() {
        if(cur!=null) return true;
        else return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */