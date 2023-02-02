package package1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trie {
    public static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean wordEnd = false;

        public TrieNode() {
            for(int i = 0; i < 26; i++)
                next[i] = null;
        }
    }

    private TrieNode root = null;
    private List<Character> chars = null;
    private List<String> answers = new ArrayList<>();

    public Trie() { this.buildTrie(); }

    public void buildTrie(){
        Scanner x = null;

        try {
            x = new Scanner(new File("C:\\Users\\isaac\\OneDrive\\CodeProjects\\NYT Spelling Bee Solver\\NYT Spelling Bee Solver\\src\\engmix.txt"));
        }
        catch(Exception e) {
            System.out.println("file not found");
        }

        root = new TrieNode();

        while(x.hasNext()) {
            String str = x.next();
            char[] word = str.toCharArray();
            TrieNode curr = root;

            for(int i = 0; i < word.length; i++) {
                if(curr.next[word[i]-'a'] == null)
                    curr.next[word[i]-'a'] = new TrieNode();

                curr = curr.next[word[i]-'a'];
            }

            curr.wordEnd = true;
        }
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++) {
            if(curr.next[word.charAt(i) - 'a'] != null)
                curr = curr.next[word.charAt(i) - 'a'];
            else
                return false;
        }

        return curr.wordEnd;
    }

    public List<String> solveSpellingBee(List<Character> chars) {
        this.chars = chars;
        helper(root, "", false);
        return answers;
    }
    private void helper(TrieNode curr, String temp, boolean hasPivot) {
        if(curr.wordEnd == true && temp.length() >= 4 && hasPivot == true)
            answers.add(temp);

        for(int i = 0; i < 7; i++) {
            if(curr.next[chars.get(i) - 'a'] != null) {
                boolean pivot = false;
                if(i == 1)
                    pivot = true;
                String newString = temp + chars.get(i);
                helper(curr.next[chars.get(i) - 'a'], newString, (pivot || hasPivot));
            }
        }
    }
}
