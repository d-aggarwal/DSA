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
class Solution {
    public int r(TreeNode root, HashMap<TreeNode, Integer> mp) {
        if(root == null) return 0;
        if(mp.get(root)!=null) return mp.get(root);

        int nl = r(root.left,mp);
        int nr = r(root.right,mp);
        int n = nl+nr;
        int i = 0;
        int il = 0;
        int ir = 0;
       
        if(root.left!=null)    il = r(root.left.left,mp) + r(root.left.right,mp);
        if(root.right!=null)    ir =  r(root.right.left,mp) + r(root.right.right,mp);
        i = il+ir + root.val;
        mp.put(root,Math.max(n,i) );
        
        return mp.get(root);
    }
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> mp = new HashMap<>();
        return r(root,mp);
    }
}