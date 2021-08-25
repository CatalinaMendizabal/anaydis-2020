package anaydis.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuijoteExercice {

    public static void main(String[] args) throws IOException {

        int[] ns = {5000, 50000, 100000, 150000};

        for (int n : ns) {

            Map<String, Integer> arrayMap = new ArrayMap<>(String::compareTo);
            Map<String, Integer> randomizedTree = new RandomizedTreeMap<>(String::compareTo);
            Map<String, Integer> rWayTrieMap = new RWayTrieMap<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/catamendizabal/projects/anaydis/anaydis-cmendizabal/src/test/resources/books/words.txt"));
            BufferedReader bufferedInvertedReader = new BufferedReader(new FileReader("/Users/catamendizabal/projects/anaydis/anaydis-cmendizabal/src/test/resources/books/sdrow.txt"));
            List<String> toSearch = new ArrayList<>();

            // Map building
            for (int i = 0; i < n; i++) {
                String toAdd = bufferedReader.readLine();
                int valueA = 1;
                int valueR = 1;
                int valueT = 1;
                if (toAdd != null) {
                    if (arrayMap.containsKey(toAdd)) valueA += arrayMap.get(toAdd);
                    if (randomizedTree.containsKey(toAdd)) valueR += randomizedTree.get(toAdd);
                    if (rWayTrieMap.containsKey(toAdd)) valueT += rWayTrieMap.get(toAdd);
                    arrayMap.put(toAdd, valueA);
                    randomizedTree.put(toAdd, valueR);
                    rWayTrieMap.put(toAdd, valueT);
                }
            }

            // To search building
            for (int i = 0; i < n; i++) {
                String toAdd = bufferedInvertedReader.readLine();
                if (toAdd != null) toSearch.add(toAdd);
            }

            // Searching Array Map
            long startTimeA = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                arrayMap.get(toSearch.get(i));
            }
            long timeA = System.currentTimeMillis() - startTimeA;
            System.out.println("Array Map execution time for " + n + " = " + timeA + " ms.");

            // Searching Randomized Tree Map
            long startTimeR = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                randomizedTree.get(toSearch.get(i));
            }
            long timeR = System.currentTimeMillis() - startTimeR;
            System.out.println("Randomized Tree Map execution time for " + n + " = " + timeR + " ms.");

            long startTimeT = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                rWayTrieMap.get(toSearch.get(i));
            }
            long timeT = System.currentTimeMillis() - startTimeT;
            System.out.println("R-Way Trie execution time for " + n + " = " + timeT + " ms.");
            Map<String, Integer> rTrie = new RWayTrieMap<>();
        }
    }
}
