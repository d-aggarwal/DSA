class Solution {

    class Pair {
        int a;
        int b;
    }

    public static int findind( ArrayList<Pair> arr, int cost, int endindex) {

        int left = 0;
        int right = endindex;
        int ans = -1;

        while(left<= right) {
            int mid = left + (right-left)/2;

            Pair p = arr.get(mid);
            int currcost = p.a;

            if(currcost>= cost) {
                right = mid-1;
            } else {
                ans = mid;
                left = mid+1;
            }
        }
        return ans;
    }

    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        ArrayList<Pair> arr = new ArrayList<>();
        int n = costs.length;
        int max = 0;

        for(int i =0;i<costs.length;i++) {
            
            Pair p = new Pair();
            p.a = costs[i];
            p.b = capacity[i];
            arr.add(p);
            if(costs[i]<budget) max= Math.max(capacity[i],max);
        }

        Collections.sort(arr , (pa,pb)->{
            return pa.a-pb.a;
        });

        int [] pre = new int[n];
        Pair firstpair = arr.get(0);
        pre[0] = firstpair.b;
        for (int i=1;i<costs.length;i++) {
            Pair p = arr.get(i);

            pre[i] = Math.max(pre[i-1],p.b);
        }

        for(int i =1;i<n;i++) {
            Pair p = arr.get(i);
            int rem = budget - p.a;
            

            int other = findind(arr, rem, i-1);
            // System.out.println("i"+ i+"rem"+rem+"other"+other);
            if(other !=-1) {
                int total = p.b + pre[other];
                max = Math.max(total,max);
            }
        }
        return max;
    }
}