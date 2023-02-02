import package1.Trie;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime(), totalTime;

        List<Character> letters = new ArrayList<>();

        Trie myTrie = new Trie();

        letters.add('a');
        letters.add('d');
        letters.add('g');
        letters.add('n');
        letters.add('o');
        letters.add('r');
        letters.add('u');

        List<String> results = myTrie.solveSpellingBee(letters);

        totalTime = System.nanoTime() - startTime;

        for(String str : results)
            System.out.println(str);

        System.out.println("word count: " + results.size());

        System.out.println("program runtime: " + totalTime/1000000 + " milliseconds");
    }
}
