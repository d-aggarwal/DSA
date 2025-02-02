class Solution {
public:
    int maxDistance(string str, int k) {
        vector<int> ans;
        int n = 0;
        int w = 0;
        int s = 0;
        int e = 0;
        
        for(char c : str){
            if(c=='N'){
                n++;
            }else if(c=='W'){
                w++;
            }else if(c=='S'){
                s++;
            }else{
                e++;
            }
            int ma = max(n, s);
            int mi = min(n, s);
            int maa = max(w, e);
            int mii = min(w, e);
            int p = min(mi+mii, k);
            ans.push_back(ma + maa -mi -mii + 2*p);
            
        }

        
        int res = 0;
        for(int i : ans){
            res = max(res, i);
        }
        return res;
        
    }
};