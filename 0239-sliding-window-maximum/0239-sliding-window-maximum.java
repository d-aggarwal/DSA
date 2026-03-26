class Solution {
    

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[]ans = new int[n-k+1];

        for(int i =0;i<k;i++) {

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekFirst()]) {
                dq.pollFirst();
            }

            dq.addFirst(i);
        }
        int j = 0;
        ans[0] = nums[dq.peekLast()];
        j++;

        for(int i = k;i<n;i++) {

            while(!dq.isEmpty() && (dq.peekLast() <= i-k )) {
                dq.pollLast();
            }
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekFirst()]) {
                dq.pollFirst();
            }
            dq.addFirst(i);

            ans[j] = nums[dq.peekLast()];
            j++;

        }

        return ans;

    }
}