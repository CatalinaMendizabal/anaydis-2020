package anaydis.search;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RandomizedTreeMapTest {

    RandomizedTreeMap<Integer, Integer> ranMap = new RandomizedTreeMap<>(Integer::compareTo, 1);
    RandomizedTreeMap<Integer, Integer> ranMap2 = new RandomizedTreeMap<>(Integer::compareTo);

    @Test
    public void randomizedMap(){
        ranMap.put(5, 1);
        ranMap.put(4, 2);
        ranMap.put(4, 4);
        ranMap.put(3, 9);
        ranMap.put(3, 4);
        ranMap.put(6, 5);
        ranMap.put(7, 2);
        ranMap.put(5, 9);
        ranMap.put(5, 10);
        ranMap.put(8, 3);
        ranMap.put(8, 9);
        ranMap.put(10, 11);
        ranMap.put(8,12);
        assertThat(ranMap.containsKey(10));
        assertThat(ranMap.containsKey(3));
        assertThat(ranMap.containsKey(5));
        assertThat(ranMap.containsKey(4));
        assertEquals(11, (int) ranMap.get(10));
        assertEquals(10, (int) ranMap.get(5));
        assertEquals(7, ranMap.size());
        List<Integer> list = new ArrayList<>();
        ranMap.keys().forEachRemaining(list::add);
        assertThat(list.size() == 8);
        ranMap.clear();
        assertTrue(ranMap.isEmpty());
    }
}