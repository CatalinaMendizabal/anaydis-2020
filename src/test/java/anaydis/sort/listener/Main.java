package anaydis.sort.listener;

import anaydis.sort.SorterType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        Benchmark benchmark = new Benchmark();
        Set<SorterCase> sorterCases = new HashSet<>();
        sorterCases.add(SorterCase.ASCENDING);
        sorterCases.add(SorterCase.DESCENDING);
        sorterCases.add(SorterCase.RANDOM);

        List<Integer> sampleSizes = new ArrayList<>();
        sampleSizes.add(10);
        sampleSizes.add(50);
        sampleSizes.add(500);
        sampleSizes.add(1000);
        sampleSizes.add(5000);

        for (SorterCase sorterCase : sorterCases) {
            for (Integer sampleSize : sampleSizes) {
                benchmark.perform(SorterType.INSERTION, sorterCase, sampleSize);
            }
        }

        for (SorterCase sorterCase : sorterCases) {
            for (Integer sampleSize : sampleSizes) {
                benchmark.perform(SorterType.BUBBLE, sorterCase, sampleSize);
            }
        }

        for (SorterCase sorterCase : sorterCases) {
            for (Integer sampleSize : sampleSizes) {
                benchmark.perform(SorterType.SELECTION, sorterCase, sampleSize);
            }
        }
        sorterCases.add(SorterCase.ASCENDING);
        sorterCases.add(SorterCase.RANDOM);
        sorterCases.add(SorterCase.DESCENDING);

    }
}