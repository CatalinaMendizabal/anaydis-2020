package anaydis.compression;

import anaydis.bit.Bits;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class Huffman implements Compressor {

    private static class Node {
        private char ch;
        private final int freq;
        private Node left, right;

        Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        Node(char ch, int freq) {
            this.freq = freq;
            this.ch = ch;
        }

        public boolean isLeaf() { return left == null && right == null; }

    }

    private final Map<Character, Bits> codes = new HashMap<>();
    private final List<Character> chars = new ArrayList<>();
    private final List<Integer> frequencies = new ArrayList<>();

    @Override
    public void encode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {

        BufferedInputStream buffer = new BufferedInputStream(inputStream);
        buffer.mark(Integer.MAX_VALUE);
        charFrequencies(buffer);
        buildTree();
        buffer.reset();
        int reader = buffer.read();
        while (reader != -1) {
            if (codes.get((char) reader) != null) {
                Bits a = codes.get((char) reader);
                a.writeInto(outputStream);
            }
            reader = buffer.read();
        }
    }

    @Override
    public void decode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        int reader = inputStream.read();
        while (reader != -1) {
            int length = reader;
            String s = "";

            int max;
            if (length % 8 == 0) max = length / 8;
            else max = length / 8 + 1;

            for (int i = 0; i < max; i++) {
                reader = inputStream.read();
                String s2 = Integer.toBinaryString(reader);
                while (s2.length() < 8) {
                    s2 = "0" + s2;
                }
                if (i == max - 1) {
                    if (length % 8 == 0) s += s2.substring(0, 8);
                    else s += s2.substring(0, length % 8);
                } else s += s2;
            }

            Bits bits = new Bits();
            for (int i = 0; i < length; i++) {
                bits.add(s.charAt(i) != '0');
            }
            for (Map.Entry<Character, Bits> entry : codes.entrySet()) {
                if (entry.getValue().getLength() == bits.getLength() && entry.getValue().getValue() == bits.getValue()) {
                    outputStream.write(entry.getKey());
                    break;
                }
            }
            reader = inputStream.read();
        }
    }

    private void charFrequencies(InputStream inputStream) throws IOException {
        int reader = inputStream.read();
        while (reader != -1) {
            if (!chars.contains((char) reader)) {
                chars.add((char) reader);
                frequencies.add(1);
            } else {
                frequencies.set(chars.indexOf((char) reader), frequencies.get(chars.indexOf((char) reader)) + 1);
            }
            reader = inputStream.read();
        }
    }

    private void buildTree() {
        Queue<Node> nodeQueue = createQueue();
        Node aux = null;
        while (nodeQueue.size() > 1) {
            Node node1 = nodeQueue.remove();
            Node node2 = nodeQueue.remove();
            Node node = new Node(node1.freq + node2.freq, node1, node2);
            aux = node;
            nodeQueue.add(node);
        }
        createCodes(aux, "");
        nodeQueue.remove();
    }

    private Queue<Node> createQueue() {
        Queue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));
        for (int i = 0; i < chars.size(); i++) {
            Node node = new Node(chars.get(i), frequencies.get(i));
            priorityQueue.add(node);
        }
        return priorityQueue;
    }

    private void createCodes(Node node, String s) {
        if (node != null) {
            if (node.isLeaf()) {
                Bits bits = new Bits();
                for (int i = 0; i < s.length(); i++) {
                    bits.add(s.charAt(i) != '0');
                }
                codes.put(node.ch, bits);
                return;
            }
        }
        assert node != null;
        createCodes(node.left, s + '0');
        createCodes(node.right, s + '1');
    }
}