package anaydis.sort.listener;

import anaydis.sort.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ShellMain {

    public static void main(String[] args) throws IOException {
        int[] seq1 = {1, 8, 23, 77, 281, 1073, 4193, 16577};
        int[] seq2 = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841};
        int[] ns = {100, 1000, 10000};
        final FileWriter csv2 = new FileWriter("benchmark2.csv", true);
        createCsv2(csv2);
        shellPerform(new IntegerDataSetGenerator(), seq1, ns);
        shellPerform(new IntegerDataSetGenerator(), seq2, ns);
    }


    public static void shellPerform(IntegerDataSetGenerator generator, int[] seq, int[] ns) throws IOException {

        ShellSorter sorter = (ShellSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.SHELL);

        for (int n : ns) {
            OrderSorterListener listener = new OrderSorterListener();
            sorter.addSorterListener(listener);
            List<Integer> list = generator.createRandom(n);
            sorter.sort(Comparator.naturalOrder(), list, seq);
            saveResultsToCSV2(n, listener);
            sorter.removeSorterListener(listener);
        }
    }

    private static void createCsv2(FileWriter csv2) throws IOException {
        csv2.append("Type ");
        csv2.append(",");
        csv2.append("Case");
        csv2.append(",");
        csv2.append("Size");
        csv2.append(",");
        csv2.append("Swaps");
        csv2.append(",");
        csv2.append("Greater");
        csv2.append(",");
        csv2.append("Equals");
        csv2.append(",");
        csv2.append("Order");
        csv2.append("\n");
        csv2.flush();
        csv2.close();
    }

    public static void saveResultsToCSV2(int n, OrderSorterListener listener) throws IOException {
        FileWriter csvWriter = new FileWriter("benchmark2.csv", true);
        csvWriter.append(SorterType.SHELL.toString());
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


