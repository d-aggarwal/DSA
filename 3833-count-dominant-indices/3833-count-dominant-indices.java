class Solution {
    public int dominantIndices(int[] nums) {
        int total = 0;
        int n = nums.length;
        
        
        for(int i =0;i<nums.length;i++) {
            total+=nums[i];
        }
        
System.out.println(total);
        
        int count =0;

         for(int i =0;i<nums.length-1;i++) {
            
            
             total -=nums[i];
             int l = n-1-i;
             double avg = (double)total/l;
             System.out.println(avg +" "+total);
             if(nums[i]>avg) count++;
        }





        return count;
    }
}