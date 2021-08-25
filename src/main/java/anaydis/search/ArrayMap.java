package anaydis.search;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayMap<K, V> implements Map<K, V> {

    @NotNull
    private final List<K> keys;
    @NotNull
    private final List<V> values;
    private final Comparator<K> comparator;

    public ArrayMap(Comparator<K> comparator) {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
        this.comparator = comparator;
    }

    private int find(K key, int low, int high){
        if (low > high) return -(low + 1);
        final int middle = (low + high)/2;
        final int cmp = comparator.compare(key, keys.get(middle));
        if (cmp == 0) return middle;
        if (cmp < 0 ) return find(key, 0, middle - 1);
        else return find(key, middle + 1, high);
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean containsKey(@NotNull K key) { return keys.contains(key); }

    @Override
    public V get(@NotNull K key) {
        int index = find(key, 0, size() - 1);
        if (index < 0) return null;
        return values.get(index);
    }

    @Override
    public V put(@NotNull K key, V value) {
        int index = find(key, 0, size() - 1);
        if (index >= 0) {
            return values.set(index, value);
        } else {
            keys.add(-index - 1 ,key);
            values.add(-index - 1, value);
            return null;
        }
    }

    @Override
    public void clear() {
        values.clear();
        keys.clear();
    }

    @Override
    public Iterator<K> keys() {
        return keys.iterator();
    }
}
