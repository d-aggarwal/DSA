// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer> occur = new ArrayList<>();
        
        int i =0;
        while(i<arr.length) {
            if(arr[i]==x) {
                if(occur.size()==0){occur.add(i);
                occur.add(i);}
                else {
                    occur.set(1,i);
                }
                
                
            }
            i++;
        }
        
        if(occur.isEmpty()){
            occur.add(-1);
            occur.add(-1);
            return occur;
        }
        
        // int cur = i;
        
        // while(i<arr.length && arr[i]==x) {
        //     i++;
        // } 
        
        // if(i > arr.length) 
        return occur;
        
    }
}
