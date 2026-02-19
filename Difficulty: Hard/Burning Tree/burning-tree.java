/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
       private void mapParents(Node root, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // Record left child's parent
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }

            // Record right child's parent
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }
    
    class Pair {
        Node node;
        int time;
        
        Pair(Node target, int t) {
            this.node = target;
            this.time = t;
        }
    }
    
    private Node findTarget(Node root, int target) {
    if (root == null) return null;

    if (root.data == target)
        return root;

    Node left = findTarget(root.left, target);
    if (left != null)
        return left;

    return findTarget(root.right, target);
}

    
    public int minTime(Node root, int target1) {
        
         if (root == null) return 0;

        // Step 1: Build parent references using BFS
        Map<Node, Node> parentMap = new HashMap<>();
        mapParents(root, parentMap);
        Node target = findTarget(root, target1);
        
        
        Queue<Pair> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(new Pair(target,0));
        visited.add(target);

        int currentLevel = 0;
        int max = 0;
        // Standard level-order BFS
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Stop traversal once we reach distance K
           

            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                max = Math.max(max,p.time);

                // Explore left child
                if (p.node.left != null && !visited.contains(p.node.left)) {
                    visited.add(p.node.left);
                    queue.offer(new Pair(p.node.left, p.time+1));
                }

                // Explore right child
                if (p.node.right != null && !visited.contains(p.node.right)) {
                    visited.add(p.node.right);
                    queue.offer(new Pair(p.node.right, p.time+1));
                }

                // Explore parent from map
                if (parentMap.containsKey(p.node) && !visited.contains(parentMap.get(p.node))) {
                    visited.add(parentMap.get(p.node));
                    queue.offer(new Pair(parentMap.get(p.node), p.time+1));
                }
            }
        
    }
    return max;
    
}


}

