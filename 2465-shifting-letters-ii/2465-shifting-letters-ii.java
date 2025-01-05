class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int [] prefix = new int [s.length()];

        for (int i =0; i<shifts.length; i++) {
             int direction = shifts[i][2];
             if(direction == 0) {
                int left = shifts[i][0];
                int right = shifts[i][1];
                prefix[left] -=1;
                if((right+1)<s.length()) prefix[right+1]+=1;
             } else {
                int left = shifts[i][0];
                int right = shifts[i][1];
                prefix[left] +=1;
                if((right+1)<s.length()) prefix[right+1]-=1;
             }
        }

        for (int i =1;i<prefix.length; i++) {
            prefix[i] = prefix[i]+prefix[i-1];
             System.out.println(prefix[i]);
        }

        String finals = "";

         for (int i =0;i<prefix.length; i++) {
            char ch = s.charAt(i);

            if(prefix[i]>=0) {
               int curr = (ch + ((prefix[i])%26));
               if(curr > 'z') {
                finals+=(char)(curr - 'z' +'a' -1);
               } else {
                finals+=(char)curr;
               }
            //    System.out.println(ch);
            //    System.out.println(prefix[i]);

// System.out.println(ch+prefix[i]-'a');
// System.out.println(ch);


            } else {
                prefix[i] = Math.abs(prefix[i])%26;
                int currn = (ch - prefix[i]);
                if(currn < 'a') {
                    finals+=(char)(currn + 'z' -'a' +1);
                } else {
                    finals+=(char)currn;
                }
            }
        }
        return finals;
    }

    
}