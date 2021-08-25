package anaydis.sort.listener;

import anaydis.sort.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class MergeSorterMain {

    public static void main(String[] args) throws IOException {
        int[] ns = {100, 500, 1000, 2500, 5000};
        final FileWriter csv = new FileWriter("MergeSorter.csv", true);
        createCsv(csv);
        mergePerform(new IntegerDataSetGenerator(), ns);
    }

    public static void mergePerform(IntegerDataSetGenerator generator, int[] ns) throws IOException {

        BottomUpMergeSorter bottomUpMergeSorter = (BottomUpMergeSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.MERGE_BOTTOM_UP);

        for (int n : ns) {
            OrderSorterListener listener = new OrderSorterListener();
            bottomUpMergeSorter.addSorterListener(listener);
            List<Integer> list = generator.createRandom(n);
            bottomUpMergeSorter.sort(Comparator.naturalOrder(), list);
            saveResultsToCSV(n, listener, SorterType.MERGE_BOTTOM_UP);
            bottomUpMergeSorter.removeSorterListener(listener);
        }

        TopDownMergeSorter topDownMergeSorter = (TopDownMergeSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.MERGE_TOP_DOWN);
        for (int n : ns) {
            OrderSorterListener listener = new OrderSorterListener();
            topDownMergeSorter.addSorterListener(listener);
            List<Integer> list = generator.createRandom(n);
            topDownMergeSorter.sort(Comparator.naturalOrder(), list);
            saveResultsToCSV(n, listener, SorterType.MERGE_TOP_DOWN);
            topDownMergeSorter.removeSorterListener(listener);
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
        FileWriter csvWriter = new FileWriter("MergeSorter.csv", true);
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
