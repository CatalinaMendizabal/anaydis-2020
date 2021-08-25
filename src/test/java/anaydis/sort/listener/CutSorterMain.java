package anaydis.sort.listener;

import anaydis.sort.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class CutSorterMain {
    public static void main(String[] args) throws IOException {

        int[] ns = {1000, 10000, 100000, 1000000};
        int[] ms = new int[25];
        int j = 0;
        for (int i = 5; i < 30; i++) {
            ms[j] = i;
            j++;
        }

        final FileWriter csv = new FileWriter("CutSorterBenchmark.csv", true);
        createCsv(csv);
        cutPerform(new IntegerDataSetGenerator(), ms, ns);
    }

    public static void cutPerform(IntegerDataSetGenerator generator, int[] ms, int[] ns) throws IOException {
        QuickCutSorter sorter = (QuickCutSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.QUICK_CUT);

        for (int n : ns) {
            for (int m : ms) {
                OrderSorterListener listener = new OrderSorterListener();
                sorter.addSorterListener(listener);
                List<Integer> list = generator.createRandom(n);
                sorter.sort(Comparator.naturalOrder(), list, m);
                saveResultsToCSV(n, listener);
                sorter.removeSorterListener(listener);
            }

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

    public static void saveResultsToCSV(int n, OrderSorterListener listener) throws IOException {
        FileWriter csvWriter = new FileWriter("CutSorterBenchmark.csv", true);
        csvWriter.append(SorterType.QUICK_CUT.toString());
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
