class Solution {
    public int totalMoney(int n) {
        
        int modulo = n%7;
        int rem = n/7;

        int start = ((7)* (7+1) )/2;
        int ist = start * rem;
        rem = rem -1;
        int sec = ((rem)* (rem+1) )/2;
        int secr = sec *7;
        rem++;
        int third = ((modulo)* (modulo+1) )/2 + + modulo * rem;
        return ist + secr + third;

    }
}