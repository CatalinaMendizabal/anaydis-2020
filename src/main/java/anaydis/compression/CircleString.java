package anaydis.compression;

import org.jetbrains.annotations.NotNull;
import java.util.Iterator;

public class CircleString implements Comparable<CircleString> {
    private final char[] string;
    private final int start;
    private final int length;

    public CircleString(char[] string) {
        this.string = string;
        this.start = 0;
        this.length = string.length;
    }

    public CircleString(char[] string, int start) {
        this.string = string;
        this.start = start;
        this.length = string.length;
    }

    public CircleString shift(){
        int temp = start - 1;
        if (temp == -1) temp = length - 1;
        return new CircleString(string, temp);
    }

    public int getLength(){ return length; }

    public int getStart() { return start; }

    public char last(){
        if (start == 0) return string[length - 1];
        return string[start - 1];
    }

    public Iterator<Character> iterator(){
        return new Iterator<Character>() {
            private int count = 0;
            private int index = start;
            @Override
            public boolean hasNext() {
                return count < length;
            }

            @Override
            public Character next() {
                count++;
                char c = string[index];
                index++;
                if (index == length) index = 0;
                return c;
            }
        };
    }

    @Override
    public int compareTo(@NotNull CircleString o) {
        if (o.length != this.length) throw new IllegalArgumentException("Can not compare with different length");
        Iterator<Character> iterator1 = this.iterator();
        Iterator<Character> iterator2 = o.iterator();
        int cmp = Character.compare(iterator1.next(), iterator2.next());
        while (cmp == 0 && iterator1.hasNext()) {
            cmp = Character.compare(iterator1.next(), iterator2.next());
        }
        return cmp;
    }

}
