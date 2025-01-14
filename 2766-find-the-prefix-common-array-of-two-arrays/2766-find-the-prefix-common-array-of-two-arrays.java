class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int [] c = new int [A.length];
        Arrays.fill(c,-1);
        int pref = 0;
        int [] res = new int[A.length];

        for(int i =0; i<c.length; i++) {
            int Ano = A[i] -1;
            int Bno = B[i] -1;
            c[Ano] ++;
            if(c[Ano] == 1) pref++;
            c[Bno] ++;
            
            if(c[Bno] ==1) pref++;
            res[i] = pref;
        }

        return res;
    }
}