package anaydis.search;

import java.io.*;

public class QuijoteUtils {

    public static void main(String[] args) throws IOException {
        constructFile();
        constructInvertedFile();
    }

    public static void constructFile() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/catamendizabal/projects/anaydis/anaydis-cmendizabal/src/test/resources/books/words.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/catamendizabal/projects/anaydis/anaydis-cmendizabal/src/test/resources/books/quijote.txt"));
        String line = bufferedReader.readLine();
        int counter = 0;
        while (line != null){
            for (String word : line.split(" ")){
                if(filter(word) && counter < 200000){
                    word = clean(word);
                    bufferedWriter.append(word).append("\n");
                    counter++;
                }
            }
            line = bufferedReader.readLine();
        }
    }

    public static void constructInvertedFile() throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/catamendizabal/projects/anaydis/anaydis-cmendizabal/src/test/resources/books/sdrow.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/catamendizabal/projects/anaydis/anaydis-cmendizabal/src/test/resources/books/quijote.txt"));
        String line = bufferedReader.readLine();
        int counter = 0;
        while (line != null){
            for (String word : line.split(" ")){
                if(filter(word) && counter < 200000){
                    word = clean(word);
                    word = new StringBuilder(word).reverse().toString();
                    bufferedWriter.append(word).append("\n");
                    counter++;
                }
            }
            line = bufferedReader.readLine();
        }
    }

    public static boolean filter(String s){
        switch (s){
            case ".":
            case ":":
            case ",":
            case ";":
            case "?":
            case "¿":
            case "!":
            case "¡":
            case "-":
            case "'":
            case "\"":
            case "\n":
            case " ":
            case "":
                return false;
            default: return true;
        }
    }

    public static String clean(String s){
        s = s.replace(".", "");
        s = s.replace(":", "");
        s = s.replace(",", "");
        s = s.replace(";", "");
        s = s.replace("?", "");
        s = s.replace("¿", "");
        s = s.replace("!", "");
        s = s.replace("¡", "");
        s = s.replace("-", "");
        s = s.replace("'", "");
        s = s.replace("\"", "");
        return s;
    }
}
