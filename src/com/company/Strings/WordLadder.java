package com.company.Strings;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, Integer> mapIndex = new HashMap<>();
        Queue<String> queue = new LinkedList();
        int index = 0;
        String temp = beginWord;
        mapIndex.put(beginWord, 1);
        List<String> words = new ArrayList(wordList);
        if(!wordList.contains(endWord)) {
            return 0;
        }
        while ( temp!= null && !temp.equalsIgnoreCase(endWord)) {
            List<String> list = findNextWord(temp, endWord, words);
            if(list.isEmpty()) return 0;
            for (String item : list) {
                if (!mapIndex.containsKey(item)) {
                    mapIndex.put(item, mapIndex.get(temp) + 1);
                }
            }
            index++;
            queue.addAll(list);
            map.put(temp, list);
            temp = queue.isEmpty() ? null : queue.remove();
            while (map.containsKey(temp)) {
                temp = queue.isEmpty() ? null : queue.remove();
            }
        }
        return mapIndex.get(endWord);
    }

    private List<String> findNextWord (String word, String endWord, List<String> wordList) {

        int position = 0;

        List<String> all = new ArrayList<>();

        for (; position < word.length(); position++ ){

            StringBuilder sb = new StringBuilder(word);
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(position, c);
                if(!sb.toString().equalsIgnoreCase(word) && ( wordList.contains(sb.toString()) || sb.toString().equalsIgnoreCase(endWord))) {
                    all.add(sb.toString());
                }
            }
        }

        return all;
    }



    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log", "cog");

        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
    }
}
