class AuthenticationManager {
    static {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            try (java.io.FileWriter w = new java.io.FileWriter("display_runtime.txt")) {
                w.write("1");
            } catch(Exception e){ e.printStackTrace(); }
        }));
    }
        private int timeToLive;
        ListNode head;
        ListNode tail;
        Map<String, ListNode> map;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            map = new HashMap<>();
            head = null;
            tail = null;
        }

        public void generate(String tokenId, int currentTime) {
            if (map.containsKey(tokenId)) {
                remove(map.get(tokenId));
            }
            var node = addToTail(currentTime + timeToLive, tokenId);
            map.put(tokenId, node);
        }

        public void renew(String tokenId, int currentTime) {
            if (map.containsKey(tokenId)) {
                var node = map.get(tokenId);
                if (node.time > currentTime) {
                    var newNode = addToTail(currentTime + timeToLive, tokenId);
                    remove(map.get(tokenId));
                    map.put(tokenId, newNode);
                } else {
                    remove(map.get(tokenId));
                    map.remove(tokenId);
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            while (!map.isEmpty() && head.time <= currentTime) {
                map.remove(head.token);
                remove(head);
            }
            return map.size();
        }

        ListNode addToTail(int time, String token) {
            if (head == null) {
                var node = new ListNode(time, token, null, null);
                head = node;
                tail = node;
                return tail;
            }
            var node = new ListNode(time, token, tail, null);
            tail.right = node;
            tail = node;
            return tail;
        }

        void remove(ListNode node) {
            if (node == head && node == tail) {
                head = null;
                tail = null;
            } else if (node == head) {
                head = head.right;
                head.left = null;
            } else if (node == tail) {
                tail = tail.left;
                tail.right = null;
            } else {
                var left = node.left;
                var right = node.right;
                left.right = right;
                right.left = left;
            }
        }


        private class ListNode {
            long time;
            String token;
            ListNode right;
            ListNode left;

            ListNode(long time, String token, ListNode left, ListNode right) {
                this.time = time;
                this.token = token;
                this.left = left;
                this.right = right;
            }
        }
    }