class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        
        boolean[]vis = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i =0; i<n;i++) {
            if(!vis[i])
                finddfs(adj, i,ans, vis);
        }
        return ans;
    }
    
    
    public void finddfs(ArrayList<ArrayList<Integer>> adj, int i , ArrayList<Integer> ans,boolean[]vis){
        
        vis[i] = true;
        ans.add(i);
        
        for(int nbr:adj.get(i)) {
            if(!vis[nbr])
                finddfs(adj, nbr,ans,vis );
        }
        
        return;
    } 
}