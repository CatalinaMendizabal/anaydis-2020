package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickMedOfThreeSorter extends QuickSorter {

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int M) {
        sort(comparator, list, 0, list.size() - 1, M);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int l, int r) {
        if (r <= l) return;
        swap(list, (l + r) / 2, r - 1);
        compAndSwap(comparator, list, l, r - 1);
        compAndSwap(comparator, list, l, r);
        compAndSwap(comparator, list, r - 1, l);
        int i = partition(comparator, list, l, r);
        sort(comparator, list, l, i - 1);
        sort(comparator, list, i + 1, r);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int l, int r, int M) {
        if (r - 1 <= M) return;
        swap(list, (l + r) / 2, r - 1);
        compAndSwap(comparator, list, l, r - 1);
        compAndSwap(comparator, list, l, r);
        compAndSwap(comparator, list, r - 1, l);
        int i = partition(comparator, list, l, r);
        sort(comparator, list, l, i - 1);
        sort(comparator, list, i + 1, r);
    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_MED_OF_THREE;
    }
}
