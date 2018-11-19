package Wyszukiwarka_najpopularniejszych_słow;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main1 {


    private static Map<String, Integer> wordCount = new HashMap<>();
    private static List<String> bannedWords = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        bannedWords.add("tej");
        bannedWords.add("ten");
        bannedWords.add("znów");

        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                parseLine(elem.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("popular_Words.txt"));

        Set<String> words = wordCount.keySet();

        for(String word : words){

            bufferedWriter.write(word + " : " + wordCount.get(word) + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();

        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("popular_Words.txt"));
        BufferedWriter bufferedWriterFiltration = Files.newBufferedWriter(Paths.get("filtered_popular_words.txt"));

        for(String word: words){
            if(!bannedWords.contains(word)){
                bufferedWriterFiltration.write(word + " : " + wordCount.get(word) + "\n");
            }
        }


    }

    private static void parseLine(String line) {
        for(String word : line.split(" ")){
            countWord(word);
        }
    }

    private static void countWord(String word) {
        if(word.length() > 2) {
            if (!wordCount.keySet().contains(word)) {
                wordCount.put(word, 1);
            } else {
                Integer counter = wordCount.get(word);
                counter++;

                wordCount.put(word, counter);
            }
        }
    }

}