package anaydis.search;

import anaydis.sort.IntegerDataSetGenerator;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayMapTest {

    ArrayMap<Integer, Integer> arrayMap = new ArrayMap(Comparator.naturalOrder());

    @Test
    public void testArrayMap() {
        arrayMap.put(5, 1);
        arrayMap.put(4, 2);
        arrayMap.put(3, 4);
        arrayMap.put(6, 5);
        arrayMap.put(7, 2);
        arrayMap.put(5, 9);
        arrayMap.put(8, 3);
        arrayMap.put(10, 11);
        assertThat(arrayMap.containsKey(10));
        assertThat(arrayMap.get(10).equals(11));
        assertThat(arrayMap.size() == 8);
        List<Integer> list = new ArrayList<>();
        arrayMap.keys().forEachRemaining(list::add);
        assertThat(list.size() == 8);
        arrayMap.clear();
        assertThat(arrayMap.isEmpty());
    }

}
