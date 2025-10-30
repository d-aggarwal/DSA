 class pair {
    int a;
    int index;
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<pair> arr = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            pair p = new pair();
            p.a = nums[i];
            p.index = i;
            arr.add(p);
            // arr.add(new pair(nums[i],i));
        }

        Collections.sort(arr, (a,b)-> a.a - b.a);
       

int i =0, j = nums.length-1;

        while(i<j) {
            int sum = arr.get(i).a+ arr.get(j).a;

            if(sum == target) {
                return new int[]{arr.get(i).index,arr.get(j).index};
            } else if(sum < target) i++;
            else j--;
        }

        return new int[1];
    }
}