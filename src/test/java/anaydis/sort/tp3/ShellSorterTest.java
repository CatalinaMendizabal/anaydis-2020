package anaydis.sort.tp3;

import anaydis.sort.*;
import anaydis.sort.gui.SorterListener;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ShellSorterTest {

    private final DataSetGenerator<Integer> generator = new IntegerDataSetGenerator();
    private final ShellSorter sorter = (ShellSorter) new SorterProviderImpl().getSorterForType(SorterType.SHELL);
    int[] seq1 = {1, 8, 23, 77, 281, 1073, 4193, 16577};

    @Test
    public void testSort() {
        List<Integer> list = generator.createAscending(10);
        List<Integer> lst = new ArrayList<>(list);
        sorter.sort(generator.getComparator().reversed(), lst, seq1);
        sorter.sort(generator.getComparator(), lst, seq1);
        assertThat(list).usingElementComparator(generator.getComparator()).containsExactlyElementsOf(lst);
    }
    @Test
    public void listenersTest(){
        AbstractSorter sorter = (AbstractSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.SHELL);
        SorterListener sorterListener = new SorterListener() {
            @Override
            public void box(int from, int to) {

            }

            @Override
            public void copy(int from, int to, boolean copyToAux) {

            }

            @Override
            public void equals(int i, int j) {

            }

            @Override
            public void greater(int i, int j) {

            }

            @Override
            public void swap(int i, int j) {

            }
        };
        sorter.addSorterListener(sorterListener);
        sorter.notifySwap(0, 0);
        sorter.notifyGreater(0, 0);
        sorter.notifyEquals(0, 0);
        assertEquals(1, sorter.getSortersListeners().size());
        sorter.removeSorterListener(sorterListener);
    }
}
