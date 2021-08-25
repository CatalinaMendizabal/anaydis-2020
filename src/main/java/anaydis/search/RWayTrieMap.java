package anaydis.search;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;

public class RWayTrieMap<V> implements Map<String, V> {

    private static class Node<V> {
        V value;
        Node<V>[] next = new Node[256];

        Node(V value) {
            this.value = value;
        }
    }

    private Node<V> head = null;
    private int size = 0;

    @Override
    public int size() { return size; }

    @Override
    public boolean containsKey(@NotNull String s) {
        return find(head, s, 0) != null;
    }

    private Node<V> find(Node<V> node, String key, int level) {
        if (node == null) return null;
        if (level == key.length()) return node;
        int next = key.charAt(level);
        return find(node.next[next], key, level + 1);
    }

    @Override
    public V get(@NotNull String key) {
        Node<V> node = find(head, key, 0);
        if (node == null) return null;
        return node.value;
    }

    @Override
    public V put(@NotNull String key, V value) {
        V v = get(key);
        head = put(head, key, value, 0);
        return v;
    }

    private Node<V> put(Node<V> node, String key, V value, int level) {
        if (node == null) {
            Node<V> result;
            if (level == key.length()) result = new Node<>(value);
            else result = new Node<>(null);
            if (level < key.length()) {
                int next = key.charAt(level);
                result.next[next] = put(result.next[next], key, value, level + 1);
            } else size++;
            return result;
        } else if (level == key.length()) {
            if (node.value == null) size++;
            node.value = value;
            return node;
        } else {
            int next = key.charAt(level);
            node.next[next] = put(node.next[next], key, value, level + 1);
            return node;
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<String> keys() {
        ArrayList<String> keys = new ArrayList<>();
        keys(keys, head, "");
        return keys.iterator();
    }

    private void keys(ArrayList<String> keys, Node<V> node, String key) {
        Node<V>[] next = node.next;
        for (int i = 0; i < next.length; i++) {
            if (next[i] != null) {
                String currentKey = key + (char) i;
                if (next[i].value != null) {
                    keys.add(currentKey);
                }
                keys(keys, next[i], currentKey);
            }
        }
    }
}