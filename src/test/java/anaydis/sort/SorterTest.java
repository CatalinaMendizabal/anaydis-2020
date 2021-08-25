package anaydis.sort;

import anaydis.sort.gui.SorterListener;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Sorter tests should subclass this abstract implementation
 */
abstract class SorterTest extends AbstractSorterTest {

    @Override
    protected DataSetGenerator<String> createStringDataSetGenerator() {
        return new StringDataSetGenerator();
    }

    @Override
    protected DataSetGenerator<Integer> createIntegerDataSetGenerator() {
        return new IntegerDataSetGenerator();
    }

    @Override
    protected SorterProvider getSorterProvider() {
        return new SorterProviderImpl();
    }

    @Test
    public void listenersTest(){
        AbstractSorter sorter = (AbstractSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.H);
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
        sorter.notifyCopy( 0, 0);
        assertEquals(1, sorter.getSortersListeners().size());
        sorter.removeSorterListener(sorterListener);
    }
    @Test
    public void testEquals(){
        AbstractSorter sorter = (AbstractSorter) new SorterProviderImpl().getSorterForType(SorterType.SELECTION);;
        IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        List<Integer> list = generator.createAscending(10);
        assertTrue(sorter.equals(Comparator.naturalOrder(), list, 0, 0));
    }
}
