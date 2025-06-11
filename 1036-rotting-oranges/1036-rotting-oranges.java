class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;
        int total = 0;

        for (int i =0;i<n;i++){
            for(int j =0;j<m;j++) {
                if(grid[i][j] ==2){
                    int [] arr = new int [] {i,j};
                    q.add(arr);
                }
                if(grid[i][j]!=0) total ++;
            }
        }
        int [] dx = new int[]{-1,1,0,0};
        int [] dy = new int [] {0,0,-1,1};

        int processed = 0;
        int time = 0;
        while(q.size()>0) {

            int size = q.size();
            processed +=size;
            while(size > 0) {
                int [] arr = q.poll();
                int oldi = arr[0];
                int oldj = arr[1];
                for (int i = 0;i<4;i++) {
                    
                        int newi = oldi + dx[i];
                        int newj = oldj + dy[i];

                        if(newi >=0 && newj >=0 && newi < n && newj <m && grid[newi][newj]==1){
                            grid[newi][newj] = 2;
                            int [] newarr = {newi,newj};
                            q.add(newarr);
                        }
                    
                }
            size--;
            }
if(q.size()!=0) time++;
        }
        System.out.println(processed +" "+total);
        return processed == total?  time : -1;
    }
}