class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if(a[1]!=b[1]) return a[1] - b[1];
            else return b[0]-a[0];        } );

        int prev = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return n - count;
    }
}