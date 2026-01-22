class Solution {
public:
    
    vector<vector<pair<int,int> > > g;
    vector<int> s;
    vector<int> t;
    vector<int> sol;
    void dfs(int u, int p, int edge){
        for(auto [v, e] : g[u]){
            if(v == p) continue;
            dfs(v, u, e);
        }
        if(s[u] != t[u] && edge != -1){
            sol.push_back(edge);
            s[u] ^= 1;
            s[p] ^= 1;
        }
    }
    vector<int> minimumFlips(int n, vector<vector<int>>& edges, string start, string target) {
        //strings are bad for doing xor ;)
        for(auto c : start){
            if(c == '1') s.push_back(1);
            else s.push_back(0);
        }
        for(auto c : target){
            if(c == '1') t.push_back(1);
            else t.push_back(0);
        }

        g.resize(n);
        for(int i = 0; i < n - 1; i ++){
            int u = edges[i][0];
            int v = edges[i][1];
            g[u].push_back({v, i});
            g[v].push_back({u, i});
        }
        dfs(0, 0, -1);
        if(s[0] != t[0]){
            return {-1};
        }
        else{
            sort(sol.begin(), sol.end());
            return sol;
        }
    }
};