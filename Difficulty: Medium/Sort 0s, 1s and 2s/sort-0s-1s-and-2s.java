class Solution {
    public void swap(int[] arr,int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
    public void sort012(int[] arr) {
        // code here
        int i =0,j=0,k=arr.length-1;
        while(k>=0 && arr[k]==2) k--;
        while(i<arr.length && arr[i]==0){
            i++;
            j++;
        }
        while(j<=k) {
            int n = arr[j];
            if(n==1) j++;
            else if(n==0) {
                swap(arr,i,j);
                i++;
                j++;
            } else {
                swap(arr,j,k);
                k--;
                // j++;
            }
        }
        
        return  ;
    }
}