package anaydis.search;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TSTMap<V> implements Map<String, V> {

    private class Node {
        final char c;
        V value;
        Node left, right, middle;

        Node(char c) {
            this.c = c;
        }
    }

    private Node head;
    private int size;
    private V lastFound;

    public TSTMap() {
        this.head = null;
        this.size = 0;
        lastFound = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(@NotNull String s) {
        return get(s) != null;
    }

    @Override
    public V get(@NotNull String s) {
        return get(head, s, 0);
    }

    public V get(Node node, String key, int level) {
        if (node == null || level >= key.length()) return null;
        if (level == key.length() - 1) {
            if (node.c == key.charAt(level)) return node.value;
            else if (node.c < key.charAt(level)) return get(node.right, key, level);
            else return get(node.left, key, level);
        } else {
            if (node.c == key.charAt(level)) return get(node.middle, key, level + 1);
            else if (node.c < key.charAt(level)) return get(node.right, key, level);
            else return get(node.left, key, level);
        }
    }

    @Override
    public V put(@NotNull String s, V v) {
        head = put(head, s, v, 0);
        return lastFound;
    }

    public Node put(Node node, String key, V value, int level) {
        if (node == null) {
            if (level == key.length() - 1) {
                node = new Node(key.charAt(level));
                node.value = value;
                size++;
            } else if (level < key.charAt(level)) {
                node = new Node(key.charAt(level));
                node.middle = put(node.middle, key, value, level + 1);
            }
        } else {
            if (level == key.length() - 1) {
                if (node.c == key.charAt(level)) {
                    lastFound = node.value;
                    node.value = value;
                } else if (node.c < key.charAt(level)) node.right = put(node.right, key, value, level);
                else node.left = put(node.left, key, value, level);
            } else if (level < key.length()) {
                if (node.c == key.charAt(level)) node.middle = put(node.middle, key, value, level + 1);
                else if (node.c < key.charAt(level)) node.right = put(node.right, key, value, level);
                else node.left = put(node.left, key, value, level);
            }
        }
        return node;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public Iterator<String> keys() {
        List<String> list = new ArrayList<>();
        keys(head, "", list);
        return list.iterator();
    }

    public void keys(Node node, String s, List<String> list) {
        if (node == null) return;
        if (node.value != null) list.add(s + node.c);
        keys(node.left, s, list);
        keys(node.right, s, list);
        keys(node.middle, s + node.c, list);
    }

    // Always
    public List<String> autocomplete(String key){
        List<String> list = new ArrayList<>();
        autocomplete(key, head, "",  0, list);
        return list;
    }

    // Non wildcard
    private void autocomplete(String key, Node node, String path, int level, List<String> list) {
        if (node != null){
            if (level < key.length()){
                char c = key.charAt(level);
                if (node.c == c) autocomplete(key, node.middle, path + c,  level + 1, list);
                else if (node.c < c) autocomplete(key, node.right, path, level, list);
                else autocomplete(key, node.left, path, level, list);
            } else {
                if (node.middle == null) list.add(path + node.c);
                autocomplete(key, node.middle, path + node.c, level + 1,  list);
                autocomplete(key, node.left, path, level, list);
                autocomplete(key, node.right, path, level, list);
            }
        }
    }
/*
    // A*A -> prefix
    private void autocomplete(String key, Node node, String path, int level, List<String> list) {
        if (node != null){
            if (level < key.length()){
                char c = key.charAt(level);
                if(c == '*'){
                    autocomplete(key, node.middle, path + node.c, level + 1, list)
                    autocomplete(key, node.left, path, level, list)
                    autocomplete(key, node.right, path, level, list)
                } else {
                    if (node.c == c) autocomplete(key, node.middle, path + c,  level + 1, list);
                    else if (node.c < c) autocomplete(key, node.right, path, level, list);
                    else autocomplete(key, node.left, path, level, list);
                }
            } else {
                if (node.middle == null) list.add(path + node.c);
                autocomplete(key, node.middle, path + node.c, level + 1,  list);
                autocomplete(key, node.left, path, level, list);
                autocomplete(key, node.right, path, level, list);
            }
        }
    }

    // A*A -> full key
    private void autocomplete(String key, Node node, String path, int level, List<String> list) {
        if (node != null){
            if (level < key.length() - 1){
                char c = key.charAt(level);
                if(c == '*'){
                    autocomplete(key, node.middle, path + node.c, level + 1, list)
                    autocomplete(key, node.left, path, level, list)
                    autocomplete(key, node.right, path, level, list)
                } else {
                    if (node.c == c) autocomplete(key, node.middle, path + c,  level + 1, list);
                    else if (node.c < c) autocomplete(key, node.right, path, level, list);
                    else autocomplete(key, node.left, path, level, list);
                }
            } else {
                if (node.middle == null && node.c == key.charAt(key.length() - 1)) list.add(path + node.c);
                autocomplete(key, node.left, path, level, list);
                autocomplete(key, node.right, path, level, list);
            }
        }
    }

    //A*A* -> full key
    private void autocomplete(String key, Node node, String path, int level, List<String> list) {
        if (node != null){
            if (level < key.length() - 1){
                char c = key.charAt(level);
                if(c == '*'){
                    autocomplete(key, node.middle, path + node.c, level + 1, list)
                    autocomplete(key, node.left, path, level, list)
                    autocomplete(key, node.right, path, level, list)
                } else {
                    if (node.c == c) autocomplete(key, node.middle, path + c,  level + 1, list);
                    else if (node.c < c) autocomplete(key, node.right, path, level, list);
                    else autocomplete(key, node.left, path, level, list);
                }
            } else {
                if (node.middle == null) list.add(path + node.c);
                autocomplete(key, node.left, path, level, list);
                autocomplete(key, node.right, path, level, list);
            }
        }
    }*/

}





