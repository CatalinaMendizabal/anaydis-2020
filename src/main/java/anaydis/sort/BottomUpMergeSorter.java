package anaydis.sort;


import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class BottomUpMergeSorter extends AbstractMergeSorter {

    protected BottomUpMergeSorter() {
        super(SorterType.MERGE_BOTTOM_UP);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi) {
        if (hi <= lo) return;
        for (int m = 1; m <= hi - lo; m *= 2) {
            for (int i = lo; i <= hi - m; i += m + m)
                merge(comparator, list, i, i + m - 1, Math.min(i - lo + m + m - 1, hi));
        }
    }
}
