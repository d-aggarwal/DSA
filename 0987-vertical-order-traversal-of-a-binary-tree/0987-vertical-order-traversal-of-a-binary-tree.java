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

    public static class Pair {
        TreeNode node ;
        int vlevel ;
        int hlevel;

        Pair(TreeNode node, int vlevel, int hlevel) {
            this.node = node;
            this.vlevel = vlevel;
            this.hlevel = hlevel;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList();

        q.add(new Pair(root,0,0));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int vlevel = p.vlevel;
            int hlevel = p.hlevel;
            map.putIfAbsent(vlevel, new TreeMap<Integer, PriorityQueue<Integer>>());
            map.get(vlevel).putIfAbsent(hlevel, new PriorityQueue<>());

            map.get(vlevel).get(hlevel).add(node.val);

            if(node.left !=null) {
                q.add(new Pair(node.left, vlevel -1, hlevel+1));
            }
            if(node.right !=null) {
                q.add(new Pair(node.right, vlevel +1, hlevel+1));
            }

        }
        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> t: map.values()) {
            List<Integer> curr = new ArrayList<>();
            for(PriorityQueue<Integer> qu: t.values()) {
                while(!qu.isEmpty()) {
                    int val = qu.poll();
                    curr.add(val);
                }
            }
            ans.add(curr);

        } 
        return ans;


    }
}