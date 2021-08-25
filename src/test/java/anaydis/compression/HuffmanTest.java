package anaydis.compression;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class HuffmanTest {
    @Test
    public void huffmanTest() throws IOException {
        String s = "atalavacaalaestacaatalavacaalaestacaatadalavacaabcdefghijklmnoppppqrrstuvwxyz";
        String a = "abcd";
        ByteArrayOutputStream encoded = new ByteArrayOutputStream();
        ByteArrayOutputStream decoded = new ByteArrayOutputStream();
        ByteArrayOutputStream empty = new ByteArrayOutputStream();
        Huffman huf = new Huffman();
        huf.encode(new ByteArrayInputStream(s.getBytes()), encoded);
        huf.decode(new ByteArrayInputStream(encoded.toByteArray()), decoded);
        assertArrayEquals(s.getBytes(), decoded.toByteArray());
        huf.decode(new ByteArrayInputStream(a.getBytes()), encoded);
    }
}
