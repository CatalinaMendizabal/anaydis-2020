package anaydis.sort.tp3;

import anaydis.sort.*;
import org.jetbrains.annotations.NotNull;
import java.util.*;

public class ShellSorterMain {

    public static void main(String[] args) {

        int[] seq1= {1, 8, 23, 77, 281, 1073, 4193, 16577};
        int[] seq2= {1, 4, 13, 40, 121, 364, 1093, 3280, 9841};

        int[] ns = {100,1000,10000};
        DataSetGenerator<Integer> generator = new IntegerDataSetGenerator();
        System.out.println("Times for sequence 1");
        tester(generator,seq1, ns);
        System.out.println("Times for sequence 2");
        tester(generator, seq2, ns);
    }
    private static void tester(@NotNull DataSetGenerator<Integer> generator, @NotNull int[] sequence, int[] ns){
        ShellSorter sorter = (ShellSorter) SorterProviderImpl.newSorter().getSorterForType(SorterType.SHELL);
        for (int n : ns){
            for (int i = 0; i < 5; i++) {
                List<Integer> list = generator.createRandom(n);
                long time = System.currentTimeMillis();
                sorter.sort(Comparator.naturalOrder(), list, sequence);
                System.out.println("for "+ n + " elements, run number: " + i + " is: "+(System.currentTimeMillis() - time));
            }
        }

    }
    //Calculate times


}
