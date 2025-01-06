class Solution {
    public int[] minOperations(String boxes) {
        int[] leftones = new int[2];
        int[] rightones = new int[2];
        int[] ans = new int[boxes.length()];

        int initright = 0;
        int initno = 0;

        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                initright += i;
                initno += 1;
            }
        }

        rightones[0] = initright;
        rightones[1] = initno;
        ans[0] = rightones[0];
        // System.out.println(rightones[0] +" " +rightones[1]+""+ans[0]);

        for (int i = 1; i < boxes.length(); i++) {
            leftones[0] = leftones[0] + leftones[1];
            if (boxes.charAt(i-1) == '1') {
                leftones[0]++;
                leftones[1]++;
            }

            rightones[0] = rightones[0] - rightones[1];
            if (boxes.charAt(i) == '1')
                rightones[1]--;

            ans[i] = leftones[0] + rightones[0];
        }

        return ans;
    }
}