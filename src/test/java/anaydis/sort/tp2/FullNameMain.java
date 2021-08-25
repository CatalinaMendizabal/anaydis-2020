package anaydis.sort.tp2;

import anaydis.sort.Sorter;
import anaydis.sort.SorterProviderImpl;
import anaydis.sort.SorterType;
import java.util.List;

public class FullNameMain {

    public static void main(String[] args) {
        FullNameDataSetGenerator generator = new FullNameDataSetGenerator();
        List<FullName> list = generator.createRandom(10);
        printList(list);
        Sorter sorter = new SorterProviderImpl().getSorterForType(SorterType.SELECTION);
        sorter.sort(generator.getComparator(), list);
        System.out.println(" ");
        printList(list);
    }

    private static void printList(List<FullName> list) {
        for (FullName fullName : list) {
            System.out.println("Name: " + fullName.getLastName() + " " + fullName.getFirstName());
        }
    }
}
