package anaydis.sort.tp3;

import anaydis.sort.AbstractSorter;
import anaydis.sort.SorterProviderImpl;
import anaydis.sort.SorterType;
import anaydis.sort.gui.SorterListener;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSorterTest {
    @Test
    public void listenersTest(){
        AbstractSorter sorter = (AbstractSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.QUICK_CUT);
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
