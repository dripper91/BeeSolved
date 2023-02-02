import package1.Trie;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime(), totalTime;

        List<Character> letters = new ArrayList<>();

        Trie myTrie = new Trie();

        letters.add('a');
        letters.add('b');
        letters.add('i');
        letters.add('l');
        letters.add('t');
        letters.add('v');
        letters.add('y');

        List<String> results = myTrie.solveSpellingBee(letters);

        totalTime = System.nanoTime() - startTime;

        for(String str : results)
            System.out.println(str);

        System.out.println("word count: " + results.size());

        System.out.println("program runtime: " + totalTime/1000000 + " milliseconds");
    }
}