package anaydis.sort;

import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;
import java.util.*;

/**
 * Abstract sorter: all sorter implementations should subclass this class.
 */

public abstract class AbstractSorter implements ObservableSorter {

    private final SorterType type;
    private final Set<SorterListener> listeners;

    protected AbstractSorter(@NotNull final SorterType type) {
        this.type = type;
        this.listeners = new HashSet<>();
    }

    protected <T> void swap(List<T> list, int e1, int e2) {
        notifySwap(e1, e2);
        final T elem = list.set(e1, list.get(e2));
        list.set(e2, elem);
    }

    public void notifySwap(int i, int j) {
        for (SorterListener listener : listeners) {
            listener.swap(i, j);
        }
    }

    protected <T> boolean greater(Comparator<T> comparator, List<T> list, int e1, int e2) {
        notifyGreater(e1, e2);
        return comparator.compare(list.get(e1), list.get(e2)) > 0;
    }

    public void notifyGreater(int i, int j) {
        for (SorterListener listener : listeners) {
            listener.greater(i, j);
        }
    }

    <T> void compAndSwap(@NotNull Comparator<T> comparator, @NotNull List<T> list, int i, int j) {
        if (greater(comparator, list, i, j)) {
            swap(list, i, j);
        }
    }

    <T> boolean equals(@NotNull Comparator<T> comparator, @NotNull List<T> list, int i, int j) {
        notifyEquals(i, j);
        return comparator.compare(list.get(i), list.get(j)) == 0;
    }

    public void notifyEquals(int i, int j) {
        for (SorterListener sorterListener : listeners) {
            sorterListener.equals(i, j);
        }
    }

    <T> void copy(@NotNull List<T> lst, int i, @NotNull List<T> list, int j) {
        notifyCopy(i, j);
        lst.set(i, list.get(j));
    }

    void notifyCopy(int from, int to) {
        for (SorterListener sorterListener : listeners) {
            sorterListener.copy(from, to, true);
        }
    }

    @Override
    public void addSorterListener(@NotNull SorterListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeSorterListener(@NotNull SorterListener listener) {
        listeners.remove(listener);
    }

    @NotNull
    public Set<SorterListener> getSortersListeners() {
        return listeners;
    }

    @NotNull
    @Override
    public SorterType getType() {
        return type;
    }
}
