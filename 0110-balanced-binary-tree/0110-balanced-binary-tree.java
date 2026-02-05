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
    public static int check(TreeNode root) {
        if(root == null)return 0;

        int lh = check(root.left);
        int rh = check(root.right);

        if(Math.abs(lh-rh)<=1) return Math.max(lh,rh)+1;
        else return 1000000;
    }
    public boolean isBalanced(TreeNode root) {
        int ch = check(root);
        if(ch >= 1000000) return false;

        return true;
    }
}