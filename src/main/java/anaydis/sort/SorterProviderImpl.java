package anaydis.sort;

import org.jetbrains.annotations.NotNull;
import org.junit.runner.manipulation.Sorter;

import java.util.EnumMap;
import java.util.Map;

public class SorterProviderImpl implements SorterProvider {
    @NotNull
    private final Map<SorterType, Sorter> sorters;

    public static SorterProvider newSorter() {
        return new SorterProviderImpl();
    }

    public SorterProviderImpl() {
        sorters = new EnumMap<>(SorterType.class);
        sorters.put(SorterType.BUBBLE, new BubbleSorter());
        sorters.put(SorterType.SELECTION, new SelectionSorter());
        sorters.put(SorterType.INSERTION, new InsertionSorter());
        HSorter h = new HSorter();
        sorters.put(SorterType.H, h);
        sorters.put(SorterType.SHELL, new ShellSorter(h));
        sorters.put(SorterType.QUICK, new QuickSorter());
        QuickNonRecursiveSorter quickNonRecursiveSorter = new QuickNonRecursiveSorter();
        sorters.put(SorterType.QUICK_NON_RECURSIVE, quickNonRecursiveSorter);
        sorters.put(SorterType.QUICK_MED_OF_THREE, new QuickMedOfThreeSorter());
        sorters.put(SorterType.QUICK_CUT, new QuickCutSorter());
        sorters.put(SorterType.QUICK_THREE_PARTITION, new QuickThreePartitionSorter());
        sorters.put(SorterType.MERGE_BOTTOM_UP, new BottomUpMergeSorter());
        sorters.put(SorterType.MERGE_TOP_DOWN, new TopDownMergeSorter());
    }

    @NotNull
    @Override
    public Iterable<Sorter> getAllSorters() {
        return sorters.values();
    }

    @NotNull
    @Override
    public Sorter getSorterForType(@NotNull SorterType type) {
        final Sorter sorter = sorters.get(type);
        if (sorter == null) throw new IllegalArgumentException("No implementation for " + type + " sorter.");
        return sorter;
    }
}
