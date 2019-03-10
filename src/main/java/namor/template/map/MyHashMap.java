package namor.template.map;

public class MyHashMap<K, V> {

    private Node<K, V>[] table;
    private int size;
    private static final int STANDART_TABLE_SIZE = 16;

    public MyHashMap() {
        table = new Node[STANDART_TABLE_SIZE];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
