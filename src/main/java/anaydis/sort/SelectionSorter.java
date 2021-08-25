package anaydis.sort;

import org.jetbrains.annotations.NotNull;

public class SelectionSorter extends AbstractSorter {

    protected SelectionSorter() {
        super (SorterType.SELECTION);
    }

    @Override
    public <T> void sort(@NotNull java.util.Comparator<T> comparator, @NotNull java.util.List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (greater(comparator, list, min, j)) { min = j; }
            }
            if (i != min) swap(list, i, min);
        }
    }
}
