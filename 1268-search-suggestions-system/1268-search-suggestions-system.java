class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false; 

        TrieNode() {

        }

    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;

            for(int i =0;i<word.length();i++) {
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }

                curr = curr.children[ch - 'a'] ;
            }

            curr.isWord = true;
        }

        public List<String> find(String word) {
            List<String> ans = new ArrayList<>();
             TrieNode curr = root;

            for(int i =0; i<word.length() ;i++) {
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null) return ans;
                curr = curr.children[ch - 'a'] ;
            }
            dfs(curr,ans, "",word);
            return ans;
        }

        public void dfs(TrieNode curr, List<String> ans, String sol, String word) {
            if(ans.size()==3) return ;

            if(curr.isWord == true) ans.add(word+sol);
            for(int i =0;i<26;i++) {
                
                if(curr.children[i] != null) {
                    char next = (char)('a' + i);
                    dfs(curr.children[i], ans, sol+next, word);
                }
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie sol = new Trie();
        List<List<String>> ans = new ArrayList<>();
        
        
        for(int i =0;i<products.length;i++) {
                sol.insert(products[i]);
        }

        for(int i =0;i<searchWord.length();i++) {
            List<String> curr = sol.find(searchWord.substring(0,i+1));
            ans.add(curr);
        }
        return ans;
    }
}