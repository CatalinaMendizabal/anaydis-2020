package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractMergeSorter extends AbstractSorter {

    protected AbstractMergeSorter(@NotNull SorterType type) {
        super(type);
    }

    public<T> void merge(@NotNull Comparator<T> comparator, @NotNull List<T> list, int lo, int m, int hi) {
        List<T> aux = new ArrayList<>();

        for (int l = 0; l < list.size(); l++) {
            aux.add(list.get(l));
        }
        for (int j = m + 1; j <= hi; j++) {
            copy(aux, hi + (m + 1) - j, list, j);
        }
        for (int k = lo, i = lo, j = hi; k <= hi; k++) {
            if (greater(comparator, aux, i, j)) {
                copy(list, k, aux, j--);
            } else {
                copy(list, k, aux, i++);
            }
        }
    }
}
