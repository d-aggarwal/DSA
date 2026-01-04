class Solution {
    public static List<List<String>> word;
    public void find(String[]words, List<String> curr, int dir) {
        if(curr.size()==4) {
            word.add(new ArrayList<>(curr));

            
            return;
        }

        for(int i =0;i<words.length;i++) {
            if(dir==-1) {
                curr.add(words[i]);
                find(words, curr,dir+1);
                curr.remove(words[i]);
            } else if(dir == 0) {
                String top = curr.get(0);
                String next = words[i];
                if(!top.equals(next) && top.charAt(0)==next.charAt(0)) {
                    curr.add(words[i]);
                     find(words, curr,dir+1);
                    curr.remove(words[i]);
                }
            } else if(dir == 1) {
                String top = curr.get(0);
                String left = curr.get(1);
                String next = words[i];
                if(!top.equals(next) && !left.equals(next) && top.charAt(3)==next.charAt(0)) {
                    curr.add(words[i]);
                     find(words, curr,dir+1);
                    curr.remove(words[i]);
                }
            }else {
                String top = curr.get(0);
                String left = curr.get(1);
                String right = curr.get(2);
                String next = words[i];
                if(!top.equals(next) && !left.equals(next) && !right.equals(next) && left.charAt(3)==next.charAt(0) && right.charAt(3)==next.charAt(3) ) {
                    curr.add(words[i]);
                     find(words, curr,dir+1);
                    curr.remove(words[i]);
                }
            }
        }
        return;

    }
    public List<List<String>> wordSquares(String[] words) {
        word = new ArrayList<>();
        Arrays.sort(words);
        List<String> curr = new ArrayList<>();
        find(words,curr,-1);
        return word;
    }
}