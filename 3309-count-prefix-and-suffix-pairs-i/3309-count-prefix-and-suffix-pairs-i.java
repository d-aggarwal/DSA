class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        // Arrays.sort(words, ((a,b) -> (b.length() - a.length())));
        int count =0;

        for (int i=0; i<words.length; i++) {
            for(int j = i+1;j<words.length;j++){

                if(j==i) continue;
                String orig = words[j];
                String check = words[i];
                if(orig.length()<check.length()) continue;

                if(orig.contains(check)) {
                    int first = orig.indexOf(check);
                    int last = orig.lastIndexOf(check);

                    if(first ==0 && ((last + check.length()) == orig.length()) ) count++;
                }
            }
        }

        return count;
    }
}