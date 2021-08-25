package anaydis.compression;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class BurrowsWheelerTest {

    @Test
    public void test() throws IOException {
        String s = "DRDOBBS";
        ByteArrayOutputStream encoded = new ByteArrayOutputStream();
        ByteArrayOutputStream decoded = new ByteArrayOutputStream();
        BurrowsWheeler burrowsWheeler = new BurrowsWheeler();
        burrowsWheeler.encode(new ByteArrayInputStream(s.getBytes()), encoded);
        burrowsWheeler.decode(new ByteArrayInputStream(encoded.toByteArray()),decoded);
        assertArrayEquals(s.getBytes(), decoded.toByteArray());
    }
}
