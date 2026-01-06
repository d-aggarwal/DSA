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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int high = Integer.MIN_VALUE;
        int maxl = 0;
        int level =0;
        while(q.size()>0){
            int sz = q.size();
            int curr = 0;
            level++;
            while(sz >0) {
                TreeNode c = q.remove();
                curr+=c.val;
                if(c.left!=null)q.add(c.left);
                if(c.right!=null)q.add(c.right);
                sz--;
            }
            if(curr > high) {
                maxl = level;
            }
            high = Math.max(high,curr);
            
        }
        return maxl;
    }
}