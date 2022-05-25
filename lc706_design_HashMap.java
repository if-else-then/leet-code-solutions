class Pair<K,V> {
    public K key;
    public V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
class Bucket {
    private List<Pair<Integer, Integer>> bucket;
    
    public Bucket() {
        this.bucket = new LinkedList<>();
    }
    
    public Integer get(Integer key) {
        for (var pair: bucket) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return -1;
    }
    
    public void remove(Integer key) {
        for (var pair: bucket) {
            if (pair.key.equals(key)) {
                bucket.remove(pair);
                return;
            }
        }
    }
    
    public void update(Integer key, Integer value) {
        boolean found = false;
        for (var pair: bucket) {
            if (pair.key.equals(key)) {
                pair.value = value;
                found = true;
                break;
            }
        }
        if(found!=true) {
            bucket.add(new Pair<Integer, Integer>(key, value));
        }
    }
}



class MyHashMap {
    private final int KEY_SPAN=2345;
    private List<Bucket> hashTable;

    public MyHashMap() {
        this.hashTable = new ArrayList<Bucket>();
        for (int i =0; i< KEY_SPAN; i++) {
            this.hashTable.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        this.hashTable.get(key%KEY_SPAN).update(key, value);
    }
    
    public int get(int key) {
        return this.hashTable.get(key%KEY_SPAN).get(key);
    }
    
    public void remove(int key) {
        this.hashTable.get(key%KEY_SPAN).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

/*
Runtime: 41 ms, faster than 45.87% of Java online submissions for Design HashMap.
Memory Usage: 66.8 MB, less than 42.94% of Java online submissions for Design HashMap.
*/
