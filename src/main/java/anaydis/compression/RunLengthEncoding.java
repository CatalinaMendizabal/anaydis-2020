package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RunLengthEncoding implements Compressor {

    char scapeCharacter = (char) 27;

    @Override
    public void encode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        char readChar = scapeCharacter;
        int counter = 0;
        int read = inputStream.read();

        while (read != -1) {
            if (readChar == scapeCharacter) {
                readChar = (char) read;
                counter++;
            } else if (readChar == (char) read) {
                counter++;
            } else {
                outputStream.write(counter);
                outputStream.write(readChar);
                counter = 1;
                readChar = (char) read;
            }
            read = inputStream.read();
        }

        if (counter > 0) {
            outputStream.write(counter);
            outputStream.write(readChar);
        }

    }

    @Override
    public void decode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        while (inputStream.available() > 0) {
            int counter = inputStream.read();
            char readingChar = (char) inputStream.read();
            for (int i = 0; i < counter; i++) {
                outputStream.write(readingChar);
            }
        }
    }
}
