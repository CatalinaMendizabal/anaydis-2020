package anaydis.sort.listener;

import anaydis.sort.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;


public class QuickSortMain {

    public static void main(String[] args) throws IOException {
        int[] ns = {12500, 25000, 50000, 100000};
        final FileWriter csv = new FileWriter("QuickSortBenchmark.csv", true);
        int m = 9;
        createCsv(csv);
        quickPerform(new IntegerDataSetGenerator(), ns);
        quickCutPerform(new IntegerDataSetGenerator(), ns,m);
        quickMedOfThreePerform(new IntegerDataSetGenerator(), ns,m);
        quickNonRecursivePerform(new IntegerDataSetGenerator(), ns);
        quickThreePartitionPerform(new IntegerDataSetGenerator(), ns);


    }

    public static void quickPerform(IntegerDataSetGenerator generator, int[] ns) throws IOException {

        QuickSorter sorter = (QuickSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.QUICK);
        for (int n : ns) {
            OrderSorterListener listener = new OrderSorterListener();
            sorter.addSorterListener(listener);
            List<Integer> list = generator.createRandom(n);
            sorter.sort(Comparator.naturalOrder(), list);
            saveResultsToCSV(n, listener, SorterType.QUICK);
            sorter.removeSorterListener(listener);
        }
    }

    public static void quickCutPerform(IntegerDataSetGenerator generator, int[] ns, int m) throws IOException {

        QuickCutSorter sorter = (QuickCutSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.QUICK_CUT);
        for (int n : ns) {
            OrderSorterListener listener = new OrderSorterListener();
            sorter.addSorterListener(listener);
            List<Integer> list = generator.createRandom(n);
            sorter.sort(Comparator.naturalOrder(), list, m);
            saveResultsToCSV(n, listener,SorterType.QUICK_CUT);
            sorter.removeSorterListener(listener);
        }
    }

    public static void quickMedOfThreePerform(IntegerDataSetGenerator generator, int[] ns, int m) throws IOException {

        QuickMedOfThreeSorter sorter = (QuickMedOfThreeSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.QUICK_MED_OF_THREE);
        for (int n : ns) {
            OrderSorterListener listener = new OrderSorterListener();
            sorter.addSorterListener(listener);
            List<Integer> list = generator.createRandom(n);
            sorter.sort(Comparator.naturalOrder(), list,m);
            saveResultsToCSV(n, listener, SorterType.QUICK_MED_OF_THREE);
            sorter.removeSorterListener(listener);
        }
    }

    public static void quickNonRecursivePerform(IntegerDataSetGenerator generator, int[] ns) throws IOException {

        QuickNonRecursiveSorter sorter = (QuickNonRecursiveSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.QUICK_NON_RECURSIVE);
        for (int n : ns) {
            OrderSorterListener listener = new OrderSorterListener();
            sorter.addSorterListener(listener);
            List<Integer> list = generator.createRandom(n);
            sorter.sort(Comparator.naturalOrder(), list);
            saveResultsToCSV(n, listener, SorterType.QUICK_NON_RECURSIVE);
            sorter.removeSorterListener(listener);
        }
    }

    public static void quickThreePartitionPerform(IntegerDataSetGenerator generator, int[] ns) throws IOException {

        QuickThreePartitionSorter sorter = (QuickThreePartitionSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.QUICK_THREE_PARTITION);
        for (int n : ns) {
            OrderSorterListener listener = new OrderSorterListener();
            sorter.addSorterListener(listener);
            List<Integer> list = generator.createRandom(n);
            sorter.sort(Comparator.naturalOrder(), list);
            saveResultsToCSV(n, listener, SorterType.QUICK_THREE_PARTITION);
            sorter.removeSorterListener(listener);
        }
    }

    private static void createCsv(FileWriter csv) throws IOException {
        csv.append("Type ");
        csv.append(",");
        csv.append("Case");
        csv.append(",");
        csv.append("Size");
        csv.append(",");
        csv.append("Swaps");
        csv.append(",");
        csv.append("Greater");
        csv.append(",");
        csv.append("Equals");
        csv.append(",");
        csv.append("Order");
        csv.append("\n");
        csv.flush();
        csv.close();
    }

    public static void saveResultsToCSV(int n, OrderSorterListener listener, SorterType type) throws IOException {
        FileWriter csvWriter = new FileWriter("QuickSortBenchmark.csv", true);
        csvWriter.append(type.toString());
        csvWriter.append(",");
        csvWriter.append(SorterCase.RANDOM.toString());
        csvWriter.append(",");
        csvWriter.append("").append(String.valueOf(n));
        csvWriter.append(",");
        csvWriter.append("").append(String.valueOf(listener.getSw()));
        csvWriter.append(",");
        csvWriter.append("").append(String.valueOf(listener.getGr()));
        csvWriter.append(",");
        csvWriter.append("").append(String.valueOf(listener.getEq()));
        csvWriter.append(",");
        csvWriter.append("").append(String.valueOf(listener.getTotalOrder()));
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }
}
