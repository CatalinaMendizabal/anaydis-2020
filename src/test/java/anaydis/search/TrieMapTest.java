package anaydis.search;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class TrieMapTest {

    RWayTrieMap<String> rWayTrie = new RWayTrieMap<>();
    TSTMap<String> tstMap = new TSTMap<>();

    @Test
    public void testArrayMap() {
        rWayTrie.put("H", "J");
        rWayTrie.put("K", "L");
        rWayTrie.put("K", "J");
        assertTrue(rWayTrie.containsKey("H"));
        assertThat(rWayTrie.size() == 3);
        assertThat(rWayTrie.get("H").equals("L"));
        assertThat(rWayTrie.get("S") == null);
        assertThat(rWayTrie.get("K"));
        assertFalse(rWayTrie.isEmpty());
        assertThat(rWayTrie.keys().hasNext());
        rWayTrie.clear();
        assertThat(rWayTrie.size() == 0);
    }

    @Test
    public void tstMapTest(){
        tstMap.put("H", "J");
        tstMap.put("K", "L");
        tstMap.put("K", "J");
        assertThat(tstMap.containsKey("H"));
        assertThat(tstMap.size() == 3);
        assertThat(tstMap.get("H"));
        assertThat(tstMap.get("S") == null);
        assertThat(tstMap.get("K"));
        assertFalse(tstMap.isEmpty());
        assertThat(tstMap.keys().hasNext());
        tstMap.clear();
        assertThat(tstMap.size() == 0);
    }

}
