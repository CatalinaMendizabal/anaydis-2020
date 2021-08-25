package anaydis.sort;

import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickCutSorter extends QuickSorter{

        private final InsertionSorter insertion;
        private final QuickMedOfThreeSorter quicksort;

        public QuickCutSorter() {
            insertion = new InsertionSorter();
            quicksort = new QuickMedOfThreeSorter();
        }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_CUT;
    }

    @Override
    public void addSorterListener(@NotNull SorterListener listener) {
        super.addSorterListener(listener);
        insertion.addSorterListener(listener);
        quicksort.addSorterListener(listener);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int M) {
        sort(comparator, list, 0, list.size() - 1, M);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int l, int r) {
        quicksort.sort(comparator, list, l, r);
        insertion.sort(comparator, list);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int l, int r, int M) {
        quicksort.sort(comparator, list, l, r, M);
        insertion.sort(comparator, list);
    }
}


