class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // Add beginWord to wordSet if not present
        wordSet.add(beginWord);

        // Step 1: Build adjacency list (graph)
        Map<String, List<String>> adj = new HashMap<>();
        for (String word1 : wordSet) {
            for (String word2 : wordSet) {
                if (isOneLetterDifferent(word1, word2)) {
                    adj.computeIfAbsent(word1, k -> new ArrayList<>()).add(word2);
                }
            }
        }

        // Step 2: BFS to find shortest path
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);
        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();
                if (curr.equals(endWord)) return steps;

                for (String neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        q.add(neighbor);
                    }
                }
            }
            steps++;
        }

        return 0;
    }

    private boolean isOneLetterDifferent(String a, String b) {
        if (a.length() != b.length()) return false;
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
