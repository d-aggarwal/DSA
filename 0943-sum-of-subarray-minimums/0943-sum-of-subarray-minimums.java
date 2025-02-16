class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        
        Stack<Integer> ls = new Stack<>();
        int[]lse = new int[arr.length];
        lse[0] = 0;
        ls.push(0);
        long mod = (long) (1e9 + 7);

        Stack<Integer> rs = new Stack<>();
        int[]rse = new int[arr.length];
        rse[n-1] = n-1;
        rs.push(n-1);

        for (int i =1;i<arr.length;i++) {
            while(ls.size()>0 && arr[ls.peek()]> arr[i]) {
                ls.pop();
            }

            if(ls.size()>0) {
                lse[i] = ls.peek()+1;
            } else {
                lse[i] = -1;
            }
            ls.push(i);
        }

        for (int i =n-2;i>=0;i--) {
            while(rs.size()>0 && arr[rs.peek()]>= arr[i]) {
                rs.pop();
            }

            if(rs.size()>0) {
                rse[i] = rs.peek()-1;
            } else {
                rse[i] = -1;
            }
            rs.push(i);
        }
        long count = 0;

        for (int i =0;i<arr.length;i++) {
            System.out.println(lse[i] +" "+rse[i]);
            int left = 0,right =0;
            if(lse[i] == -1) {
                left = i +1;
            } else {
                left = i - lse[i] +1;
            }

            if(rse[i] == -1) {
                right = n-i;
            } else {
                right  = rse[i] - i +1;

        }

         count = (count + (long) arr[i] * left * right) % mod;
        }

        return (int)count;
    }
}