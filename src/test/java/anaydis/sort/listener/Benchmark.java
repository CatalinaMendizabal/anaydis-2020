package anaydis.sort.listener;

import anaydis.sort.*;
import anaydis.sort.gui.ObservableSorter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;


public class Benchmark {
    private final SorterProvider provider = new SorterProviderImpl();
    private final OrderSorterListener listener = new OrderSorterListener();

    private final IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
    private final FileWriter csv;

    List<Integer> values;
    private int n;
    private SorterType sorterType;
    private SorterCase sorterCase;


    public Benchmark() throws IOException {
        csv = new FileWriter("benchmark.csv", true);
        createCsv();
    }

    public void perform(SorterType type, SorterCase sorterCase, int n) throws IOException {
        this.n = n;
        sorterType = type;
        this.sorterCase = sorterCase;
        final ObservableSorter sorter = (ObservableSorter) provider.getSorterForType(type);
        sorter.addSorterListener(listener);

        switch (sorterCase) {
            case ASCENDING:
                values = generator.createAscending(n);
            case RANDOM:
                values = generator.createRandom(n);
            default:
                values = generator.createDescending(n);

                sorter.sort(generator.getComparator(), values);
                sorter.removeSorterListener(listener);
                saveResultsToCSV();
        }
    }


    private void createCsv() throws IOException {
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


    public void saveResultsToCSV() throws IOException {
        FileWriter csvWriter = new FileWriter("benchmark.csv", true);
        csvWriter.append(sorterType.toString());
        csvWriter.append(",");
        csvWriter.append(sorterCase.toString());
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