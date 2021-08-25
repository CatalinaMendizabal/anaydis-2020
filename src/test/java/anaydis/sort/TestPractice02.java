package anaydis.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestPractice02 extends SorterTest {

    //~ Methods ..................................................................................................................

    /** Test BubbleSorter with String generator. */
    @Test
    public void testBubbleWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.BUBBLE, 10);
        testSorter(createStringDataSetGenerator(), SorterType.BUBBLE, 50);
        testSorter(createStringDataSetGenerator(), SorterType.BUBBLE, 100);
    }

    /** Test BubbleSorter with Integer generator. */
    @Test public void testBubbleWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.BUBBLE, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.BUBBLE, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.BUBBLE, 100);
    }

    /** Test InsertionSorter with String generator. */
    @Test public void testInsertionWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.INSERTION, 10);
        testSorter(createStringDataSetGenerator(), SorterType.INSERTION, 50);
        testSorter(createStringDataSetGenerator(), SorterType.INSERTION, 100);
    }

    /** Test InsertionSorter with Integer generator. */
    @Test public void testInsertionWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.INSERTION, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.INSERTION, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.INSERTION, 100);
    }

    /** Test SelectionSorter with String generator. */
    @Test public void testSelectionWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.SELECTION, 10);
        testSorter(createStringDataSetGenerator(), SorterType.SELECTION, 50);
        testSorter(createStringDataSetGenerator(), SorterType.SELECTION, 100);
    }

    /** Test SelectionSorter with Integer generator. */
    @Test public void testSelectionWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.SELECTION, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.SELECTION, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.SELECTION, 100);
    }
    /** Test HSorter with Integer generator. */
    @Test public void testHWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.H, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.H, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.H, 100);
    }
    /** Test HSorter with Integer generator. */
    @Test public void testHWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.H, 10);
        testSorter(createStringDataSetGenerator(), SorterType.H, 50);
        testSorter(createStringDataSetGenerator(), SorterType.H, 100);
    }
    /** Test ShellSorter with String generator. */
    @Test public void testShellWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.SHELL, 10);
        testSorter(createStringDataSetGenerator(), SorterType.SHELL, 50);
        testSorter(createStringDataSetGenerator(), SorterType.SHELL, 100);
    }

    /** Test ShellSorter with Integer generator. */
    @Test public void testShellWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.SHELL, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.SHELL, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.SHELL, 100);
    }
    /** Test QuickSorter with String generator. */
    @Test public void testQuickWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK, 100);
    }

    /** Test QuickSorter with Integer generator. */
    @Test public void testQuickWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK, 100);
    }
    /** Test QuickNonRecursiveSorter with String generator. */
    @Test public void testQuickNonRecursiveWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 100);
    }

    /** Test QuickNonRecursiveSorter with Integer generator. */
    @Test public void testQuickNonRecursiveWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 100);
    }

    /** Test QuickMedOfThreeSorter with String generator. */
    @Test public void testQuickMedOfThreeWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 100);
    }

    /** Test QuickMedOfThreeSorter with Integer generator. */
    @Test public void testQuickMedOfThreeWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 100);
    }
    /** Test QuickCutSorter with String generator. */
    @Test public void testQuickCutWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_CUT, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_CUT, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_CUT, 100);
    }

    /** Test QuickCutSorter with Integer generator. */
    @Test public void testQuickCutWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_CUT, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_CUT, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_CUT, 100);
    }

    /** Test QuickThreePartitionSorter with String generator. */
    @Test public void testQuickThreePartitionWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 100);
    }

    /** Test QuickThreePartitionSorter with Integer generator. */
    @Test public void testQuickThreePartitionWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 100);
    }

    /** Test MergeBottomUpSorter with String generator. */
    @Test public void testMergeBottomUpWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 10);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 50);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 100);
    }

    /** Test MergeBottomUpSorter with Integer generator. */
    @Test public void testMergeBottomUpWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 100);
    }

    /** Test MergeTopDownSorter with String generator. */
    @Test public void testMergeTopDownUpWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 10);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 50);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 100);
    }

    /** Test MergeTopDownSorter with Integer generator. */
    @Test public void testMergeTopDownWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 100);
    }

    @Test
    public void mTests() {
        int i = 3;
        int j = 4;
        int k= 7;
        int m = 5;

        DataSetGenerator<Integer> generator = createIntegerDataSetGenerator();

        List<Integer> list1 = generator.createAscending(10);
        List<Integer> list2 = new ArrayList<>(list1);
        QuickMedOfThreeSorter quick = new QuickMedOfThreeSorter();
        quick.sort(generator.getComparator().reversed(), list2, i, j);
        quick.sort(generator.getComparator(), list2, i, j);
        assertThat(list1).usingElementComparator(generator.getComparator()).containsExactlyElementsOf(list2);

        quick.sort(generator.getComparator().reversed(), list2, i, j, k);
        quick.sort(generator.getComparator(), list2, i, j, k);
        assertThat(list1).usingElementComparator(generator.getComparator()).containsExactlyElementsOf(list2);

        quick.sort(generator.getComparator().reversed(), list2, m);
        quick.sort(generator.getComparator(), list2,m);
        assertThat(list1).usingElementComparator(generator.getComparator()).containsExactlyElementsOf(list2);

        QuickCutSorter cutSorter = new QuickCutSorter();
        cutSorter.sort(generator.getComparator().reversed(), list2, i, j, k);
        cutSorter.sort(generator.getComparator(), list2, i, j, k);
        assertThat(list1).usingElementComparator(generator.getComparator()).containsExactlyElementsOf(list2);

        cutSorter.sort(generator.getComparator().reversed(), list2, m);
        cutSorter.sort(generator.getComparator(), list2,m);
        assertThat(list1).usingElementComparator(generator.getComparator()).containsExactlyElementsOf(list2);

    }


}

