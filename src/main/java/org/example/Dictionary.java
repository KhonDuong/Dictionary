package org.example;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words;

    public Dictionary(HashMap<String, String> words) {
        this.words = words;
    }

    public boolean checkWord(String word) {
        return word.trim().matches("[a-z A-Z]+");
    }
    public void addWord(String word, String definition)
    {
        if (checkWord(word)) this.words.put(word.toLowerCase(), definition);
    }

    public String getWord(String word)
    {
        if (this.words.get(word.toLowerCase()) != null) {
            return word + " : " + this.words.get(word.toLowerCase());
        }
        return "We don't have the definition for that word.";
    }

    public String getAllWords()
    {
        StringBuilder result = new StringBuilder();
        for (String key : this.words.keySet()) {
            result.append(getWord(key)).append("\n");
        }
        return result.toString();
    }

    public void removeWord(String word)
    {
        this.words.remove(word);
    }
}
