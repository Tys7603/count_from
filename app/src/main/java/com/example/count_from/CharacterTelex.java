package com.example.count_from;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CharacterTelex {
    private HashMap<String, Character> mapping;

    public CharacterTelex() {
        this.mapping = new HashMap<>();
        mapping.put("aw", 'ă');
        mapping.put("aa", 'â');
        mapping.put("dd", 'đ');
        mapping.put("ee", 'ê');
        mapping.put("oo", 'ô');
        mapping.put("ow", 'ơ');
        mapping.put("w", 'ư');
    }

    public int countVietnameseCharacters(String inputString) {
        Set<Character> foundChars = new HashSet<>();
        int i = 0;
        while (i < inputString.length()) {
            for (int j = 2; j > 0; j--) {
                if (i + j <= inputString.length() && mapping.containsKey(inputString.substring(i, i + j))) {
                    foundChars.add(mapping.get(inputString.substring(i, i + j)));
                    i += j;
                    break;
                }
            }
            i++;
        }
        return foundChars.size();
    }
}
