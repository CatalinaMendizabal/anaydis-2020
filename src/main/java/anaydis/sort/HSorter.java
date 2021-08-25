package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class HSorter extends AbstractSorter{

    protected HSorter() {
        super(SorterType.H);
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator,@NotNull List<T> list){
        sort(comparator, list, 1);
    }

    <T> void sort(Comparator<T> comparator, List<T> list, int h) {
        for (int i = h; i < list.size(); i++) {
            int j = i;
           while(j >= h && greater(comparator, list, j - h, j)){
               swap(list, j - h, j);
               j -= h;
           }
        }
    }
}