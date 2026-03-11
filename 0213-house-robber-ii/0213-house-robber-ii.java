class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1) return nums[0];
        if(nums.length ==2) return Math.max(nums[0],nums[1]);

        
        int n = nums.length;
        // ans[0] = nums[0];
        int prev = nums[0];
        int prev2 = 0;
         int curr =0;

        for(int i =1;i<n-1;i++) {
         curr = Math.max(prev, prev2+nums[i]);

            
            prev2 = prev;
            prev= curr;
        }

        
       
        prev = nums[1];
        prev2 =0;
         int curr2=0;

         for(int i =2;i<n;i++) {
            curr2 = Math.max(prev, prev2+nums[i]);

            
            prev2 = prev;
            prev= curr2;
        }
        System.out.println(curr+ " "+curr2);

        return Math.max(curr,curr2);


    }
}