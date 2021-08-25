package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class BurrowsWheeler implements Compressor {

    @Override
    public void encode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        CircleString first = createCircleString(inputStream);
        CircleString[] matrix = new CircleString[first.getLength()];
        matrix[0] = first;
        for (int i = 1; i < matrix.length; i++) {
            matrix[i] = matrix[i - 1].shift();
        }
        Arrays.sort(matrix);
        int position = -1;
        for (int i = 0; i < matrix.length; i++) {
            CircleString shifting = matrix[i];
            if (shifting.getStart() ==  1 ) position = i;
            outputStream.write(shifting.last());
        }
        writeInt(position, outputStream);
        System.out.println();
    }

    @Override
    public void decode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        final byte[] string = readString(inputStream);
        final int[] transformVector = getTVector(string);
        int current = readInt(inputStream);

        for (int i = 0; i < string.length; i++) {
            outputStream.write(string[current]);
            current = transformVector[current];
        }
        System.out.println();
    }

    public CircleString createCircleString(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        char[] string = new char[inputStream.available() + 1];
        int index = 0;
        while (read != -1) {
            string[index] = (char) read;
            index++;
            read = inputStream.read();
        }
        return new CircleString(string);
    }

    private byte[] readString(InputStream inputStream) throws IOException {
        int read;
        byte[] chars = new byte[inputStream.available() - Integer.BYTES];
        int i = 0;
        while (i < chars.length) {
            read = inputStream.read();
            chars[i++] = (byte) read;
        }
        return chars;
    }

    private int[] getTVector(byte[] string) {
        byte[] sorted = Arrays.copyOf(string, string.length);
        byte[] stringCopy = Arrays.copyOf(string, string.length);
        Arrays.sort(sorted);
        int[] t = new int[stringCopy.length];

        for (int i = 0; i < string.length; i++) {
            t[i] = remove(sorted[i], stringCopy);
        }
        return t;
    }

    private int remove(byte c, byte[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                chars[i] = -1;
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    //bits utils
    private static void writeInt(int value, OutputStream outputStream) throws IOException {
        outputStream.write(value >> 24);
        outputStream.write(value >> 16);
        outputStream.write(value >> 8);
        outputStream.write(value);
        System.out.println();
    }

    private static int readInt(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[4];
        inputStream.read(bytes);
        return ByteBuffer.wrap(bytes).getInt();
    }
}