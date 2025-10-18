class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int n = people.length;

        int start = 0;
        int end = n-1;
        int noofboats = 0;
        Arrays.sort(people);

        while(end >=0 && people[end]==limit) {
            end--;
            noofboats++;
        }

        if(end > 0) {

            while (start < end && start < n && end>0) {
                if(people[start] + people[end] <= limit) {
                    start ++;
                    end --;
                    noofboats++;
                } else {
                    end --;
                    noofboats++;
                }
            }
        }

        if(start == end) {
            noofboats++;
        }
        
    return noofboats;
    }
}