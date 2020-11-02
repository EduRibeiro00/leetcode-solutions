class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    
    private final Node head = new Node();
    private final Node tail = new Node();
    
    private int capacity;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.map = new HashMap(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if (node != null) {
            result = node.value;
            useNode(node);
        }
        
        return result;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            add(node);
        }
        else {
            if (map.size() == this.capacity) {
                remove(tail.prev);
                map.remove(tail.prev.key);
            }
            
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            add(newNode);
        }
    }
    
    
    private void useNode(Node node) {
        remove(node);
        add(node);
    }
    
    private void add(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    private void remove(Node node) {
        Node nodePrev = node.prev;
        Node nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */