package anaydis.compression;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class RunLengthEncodingTest {

    @Test
    public void runLengthTest() throws IOException {
        String s = "assssnnanajjj";
        ByteArrayOutputStream encoded = new ByteArrayOutputStream();
        ByteArrayOutputStream decoded = new ByteArrayOutputStream();
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        runLengthEncoding.encode(new ByteArrayInputStream(s.getBytes()), encoded);
        runLengthEncoding.decode(new ByteArrayInputStream(encoded.toByteArray()), decoded);
        assertArrayEquals(s.getBytes(), decoded.toByteArray());
    }

  /*  public void huffmanTest(){
        String s = "atalavacaalaestaca";
        Huffman h;


    }*/


}
