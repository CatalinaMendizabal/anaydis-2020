package anaydis.sort.tp2;
import anaydis.sort.Sorter;
import anaydis.sort.SorterProviderImpl;
import anaydis.sort.SorterType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class FullNameSortingTest {

    private final FullNameDataSetGenerator fullNameDataSetGenerator = new FullNameDataSetGenerator();

    private final Sorter sorter = new SorterProviderImpl().getSorterForType(SorterType.SELECTION);

    @Test
    public void testGenerator() {
        List<FullName> list = fullNameDataSetGenerator.createRandom(10);
        assertThat(list.size()).isEqualTo(10);
    }
    @Test
    public void testAscending(){
        List<FullName> list = fullNameDataSetGenerator.createAscending(10);
        List<FullName> lst = new ArrayList<>(list);
        sorter.sort(fullNameDataSetGenerator.getComparator().reversed(), lst);
        sorter.sort(fullNameDataSetGenerator.getComparator(), lst);
        assertThat(list).usingElementComparator(fullNameDataSetGenerator.getComparator()).containsExactlyElementsOf(lst);
    }
    @Test
    public void testDescending(){
        List<FullName> list = fullNameDataSetGenerator.createDescending(10);
        List<FullName> lst = new ArrayList<>(list);
        sorter.sort(fullNameDataSetGenerator.getComparator(), lst);
        sorter.sort(fullNameDataSetGenerator.getComparator().reversed(), lst);
        assertThat(list).usingElementComparator(fullNameDataSetGenerator.getComparator()).containsExactlyElementsOf(lst);
    }


}
