class AuthenticationManager {

    int timeToLive;
    TreeSet<Integer> treeSet;
    Map<String, Integer> map;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        treeSet = new TreeSet<>();
        map = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
        treeSet.add(currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        
        Integer time = map.get(tokenId);
		// If null the token was never added, or it has expired before the renew call, which makes it invalid for renewing
        if (time == null || time <= currentTime) return;
       
	   
	   // Update the hashmap and treeSet with the new values
        map.put(tokenId, currentTime + timeToLive);
        treeSet.remove(time);
        treeSet.add(currentTime + timeToLive);
        
		// Clearing the treeset from already expired timestamps, it doesn't really improve the time execution, with about 10% only.
        while (!treeSet.isEmpty() && treeSet.lower(currentTime) != null) {
            treeSet.remove(treeSet.lower(currentTime));
        }
    }
    
	// Return the number of timestamps in the treeset, which have greated expiry time than the currentTime
    public int countUnexpiredTokens(int currentTime) {
        return treeSet.tailSet(currentTime, false).size();
    }
}