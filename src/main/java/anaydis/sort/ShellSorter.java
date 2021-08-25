package anaydis.sort;

import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import java.util.List;

public class ShellSorter extends AbstractSorter {

    private final HSorter hSorter;

    protected ShellSorter(final HSorter h) {
        super(SorterType.SHELL);
        this.hSorter = h;
    }

    @Override
    public void addSorterListener(@NotNull SorterListener listener) {
        super.addSorterListener(listener);
        hSorter.addSorterListener(listener);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        int h;
        int n = list.size();
        for (h = 1; h < (n / 9); h = (3 * h) + 1);
        for (; h > 0; h /= 3) {
            hSorter.sort(comparator, list, h);
        }
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, @NotNull int[] items) {
        for (int item : items) {
            if (item < list.size()) {
                hSorter.sort(comparator, list, item);
            }
        }
    }
}
