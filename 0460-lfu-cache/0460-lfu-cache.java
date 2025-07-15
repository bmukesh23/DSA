class LFUCache {
    class Node {
        int key, value, freq;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> keyNodeMap;
    private final Map<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyNodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyNodeMap.containsKey(key))
            return -1;
        Node node = keyNodeMap.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyNodeMap.size() >= capacity)
                evictLFU();
            Node newNode = new Node(key, value);
            keyNodeMap.put(key, newNode);
            freqMap.computeIfAbsent(1, ignore -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        freqMap.get(freq).remove(node.key);
        if (freqMap.get(freq).isEmpty()) {
            freqMap.remove(freq);
            if (freq == minFreq)
                minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, ignore -> new LinkedHashSet<>()).add(node.key);
    }

    private void evictLFU() {
        LinkedHashSet<Integer> minFreqKeys = freqMap.get(minFreq);
        int evictKey = minFreqKeys.iterator().next();
        minFreqKeys.remove(evictKey);
        if (minFreqKeys.isEmpty()) {
            freqMap.remove(minFreq);
        }
        keyNodeMap.remove(evictKey);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */