class Solution {

    public static void inorder(Node root, int key, Node[] pre, Node[] suc) {
        if (root == null) return;

       
        // If node is smaller than key → possible predecessor
        if (root.data < key) {
            if (pre[0] == null || pre[0].data < root.data) {
                pre[0] = root;
            }
        }

        // If node is greater than key → possible successor
        if (root.data > key) {
            if (suc[0] == null || suc[0].data > root.data) {
                suc[0] = root;
            }
        }
         inorder(root.left, key, pre, suc);


        inorder(root.right, key, pre, suc);
    }

    public ArrayList<Node> findPreSuc(Node root, int key) {

        Node[] pre = new Node[1];
        Node[] suc = new Node[1];

        inorder(root, key, pre, suc);

        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre[0]);
        ans.add(suc[0]);

        return ans;
    }
}