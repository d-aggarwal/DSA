class Solution {

    class Pair {
        int i;
        int j;
        int steps;
        Pair(int i, int j, int steps) {
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
    }

    public void dfs(int[][]grid, int r, int c, boolean[][]vis) {
         int n = grid.length;
        int m = grid[0].length;
        int [] dx = {0,1,-1,0};
        int [] dy = {1,0,0,-1};
        
        vis[r][c] = true;
        // grid[r][c] = -1;

        int newr, newc;

            for(int i =0;i<4;i++) {
                newr = r+dx[i];
                newc = c+dy[i];

                if(newr>=0 && newc>=0 && newr<n && newc<m && grid[newr][newc] == 1 && !vis[newr][newc] ) {
                   
            
                    dfs(grid, newr, newc, vis);
                    
                }
            }

    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][]vis = new boolean[n][m];
        boolean flag = true;

        for(int i =0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1 ) {
                    dfs(grid, i, j, vis);
                    flag = false;
                    break;
                }
            }
            if(flag == false) break;
        }

        Queue<Pair> q = new LinkedList<>();

        for(int i =0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(vis[i][j] ) {
                    grid[i][j] = -1;
                }else if(grid[i][j]==1) {
                    q.add(new Pair(i,j,0));
                }

                // System.out.println(grid[i][j]);
            }
        }

        int [] dx = {0,1,-1,0};
        int [] dy = {1,0,0,-1};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.i;
            int c = p.j;
            int steps = p.steps;
            int newr, newc;

            for(int i =0;i<4;i++) {
                newr = r+dx[i];
                newc = c+dy[i];

                if(newr>=0 && newc>=0 && newr<n && newc<m ) {
                    // System.out.println(r+" "+c+" "+ newr+" "+newc+" "+grid[newr][newc]+" "+steps);
                    if(grid[newr][newc]==-1) return steps;
                    else if (grid[newr][newc]==0 && (!vis[newr][newc] )) {
                        vis[newr][newc] = true;
                        q.add(new Pair(newr, newc, steps+1));
                    }
                }
            }
        }


        return 0;

    }
}