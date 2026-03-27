class Solution {
    class Pair {
        int no;
        int mt;
        int j;
        
        Pair(int no, int i, int j) {
            this.no = no;
            this.mt = i;
            this.j = j;
        }
    }
    
    public ArrayList<Integer> findSmallestRange(int[][] mat) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int curr = 1000000;
        
        int n = mat.length;
        int k = mat[0].length;
        TreeSet<Pair> t = new TreeSet<>((a, b) -> {
    if (a.no != b.no) return a.no - b.no;
    if (a.mt != b.mt) return a.mt - b.mt;
    return a.j - b.j;
});
        
        
        for(int i =0;i<n;i++) {
            t.add(new Pair(mat[i][0],i, 0));
            // System.out.println(mat[i][0]);
        }
        
        
        while(true) {
            Pair f = t.first();
            Pair l = t.last();
            
            int small = f.no;
            int large = l.no;
            // System.out.println(small + " "+large);
            // if(large - small > curr) return ans;
            
                
                
                if(ans.size()!=0 && ((large-small) <curr)) {
                    curr = large-small;
                ans.set(0,small);
                ans.set(1,large);
                } else if(large-small <curr && ans.size()==0){
                    curr = large-small;
                    ans.add(small);
                    ans.add(large);
                }
                
                t.remove(f);
                
                int index = f.mt;
                if(mat[index].length-1 == f.j) return ans;
                else {
                    t.add(new Pair(mat[index][f.j+1], index, f.j+1));
                    // System.out.println(mat[index][f.j+1]);
                }
                
            
        }
        
        // return ans;
        
    }
}