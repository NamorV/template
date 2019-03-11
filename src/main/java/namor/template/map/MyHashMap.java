package namor.template.map;

public class MyHashMap<K, V> {

    private Node<K, V>[] table;
    private int size;
    private static final int STANDARD_TABLE_SIZE = 16;

    public MyHashMap() {
        table = new Node[STANDARD_TABLE_SIZE];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash & (STANDARD_TABLE_SIZE - 1);
        Node<K, V> node = new Node<>(key, value, hash);

        if(table[index] == null) {
            table[index] = node;
        } else {
            Node<K, V> currentNode = table[index];

            while(currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }

            currentNode.setNext(node);
        }

        size++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash & (STANDARD_TABLE_SIZE - 1);
        Node<K, V> node = table[index];

        while (node != null) {
            if(node.getHash() == hash) {
                return node.getValue();
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        if(get(key) == null) {
            return false;
        }

        return true;
    }
}
