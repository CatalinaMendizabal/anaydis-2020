package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickThreePartitionSorter extends AbstractSorter {

    protected QuickThreePartitionSorter() {
        super(SorterType.QUICK_THREE_PARTITION);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1);
    }

    private <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int low, int hi) {
        if (hi <= low) return;
        int i = low - 1, j = hi, p = low - 1, q = hi, k;
        while (true) {
            while (greater(comparator, list, hi, ++i)) {
                if (i == hi) break;
            }
            while (greater(comparator, list, --j, hi)) {
                if (j == low) break;
            }
            if (i >= j) break;

            swap(list, i, j);
            if (equals(comparator, list, i, hi)) {
                swap(list, ++p, i);
                if (equals(comparator, list, hi, j)) {
                    swap(list, --q, j);
                }
            }
        }

        swap(list, i, hi);
        j = i - 1;
        i++;
        for (k = low; k <= p; k++, j--) {
            swap(list, k, j);
        }
        for (k = hi - 1; k >= q; k--, i++) {
            swap(list, k, i);
        }
        sort(comparator, list, low, j);
        sort(comparator, list, i, hi);

    }
}
