class Solution {
    
    public void heapify(int[]arr, int n, int i) {
        
        int largest = i;
        
        int left = 2*i+1;
        int right = 2*i+2;
        
        if(left <= n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if(right <= n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if(largest!=i) {
        int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            
            heapify(arr, n, largest);
        }
    }
    
    public void swap(int []arr, int i) {
        int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
    }
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[]) {
        // code here
        int n = arr.length;
        
        for(int i = n/2-1;i>=0;i--) {
            
                heapify(arr,n-1,i);
            
            
        }
        
        for(int i = n-1;i>=0;i--) {
            heapify(arr, i,0);
            swap(arr, i);
        }
    }
}