class Solution {
    public int[][] merge(int[][] intervals) {
        


        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        int i =0;
        int n = intervals.length;
        int j ;
        int mergedc ;
        int[][]ans = new int[n][2];
        int k =0;
        // Stack<Pair>

        while(i<n) {
            int currr = intervals[i][0];
            int currc = intervals[i][1];
            mergedc = currc;

            j=i+1;

            while(j<n) {
                int r = intervals[j][0];
            int c = intervals[j][1];

            if(mergedc >= r) {
                mergedc = Math.max(mergedc,c);
                j++;
            }else {
                break;
            }
            }

            ans[k][0] = currr;
            ans[k][1] = mergedc;
            k++;
            i=j;





        }

        return Arrays.copyOf(ans, k);
    }
}