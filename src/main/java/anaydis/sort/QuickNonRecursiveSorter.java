package anaydis.sort;

import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class QuickNonRecursiveSorter extends QuickSorter {

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        Stack<Integer> stack = new Stack<>();
        stack.push(list.size() - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            final int lo = stack.pop();
            final int hi = stack.pop();
            final int i = partition(comparator, list, lo, hi);
            if (i - 1 > lo) {
                stack.push(i - 1);
                stack.push(lo);
            }
            if (hi > i + 1) {
                stack.push(hi);
                stack.push(i + 1);
            }
        }
    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_NON_RECURSIVE;
    }
}
