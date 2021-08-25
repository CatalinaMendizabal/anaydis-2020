package anaydis.sort;
import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import java.util.List;

public class TopDownMergeSorter extends AbstractMergeSorter {

    protected TopDownMergeSorter() {
        super(SorterType.MERGE_TOP_DOWN);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size() - 1);
    }

    private <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int hi) {
        if (hi <= lo) return;
        int m = (lo + hi)/ 2;
        sort(comparator, list, lo, m);
        sort(comparator, list, m + 1, hi);
        merge(comparator, list, lo, m, hi);
    }
}
