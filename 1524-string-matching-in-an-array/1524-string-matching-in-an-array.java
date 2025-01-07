class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words,(
            (a,b) -> b.length() - a.length() ));

            List<String> arr = new ArrayList<>();
            arr.add(words[0]);
            List<String> ans = new ArrayList<>();
            int flag =0;

            for (int i =1;i<words.length;i++) {
                flag =0;
                for (String curr : arr) {
                     
                     if(curr.contains(words[i])) {
                        ans.add(words[i]);
                        flag = 1;
                        break;
                     }
                }

                if(flag ==0) {
                    arr.add(words[i]);
                }
            }

            return ans;
    }
}